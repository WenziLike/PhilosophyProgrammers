package com.philosophyprogrammers.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Spring Security Login Configurations
 * <p>
 * #-> Создаем первым делом Web Security Config + Authentication Provider
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    public WebSecurityConfig(UserDetailsService userDetailsService,
                             PasswordEncoder passwordEncoder,
                             DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/login").permitAll()
                .antMatchers("/account/**", "/write").hasAnyAuthority("USER")
                .and()

                /* ============== Setting HTTPS for my account*/
//                .requiresChannel().anyRequest().requiresSecure()
                .requiresChannel().antMatchers("/account/**").requiresSecure()
                .and()

                /*============== REMEMBER ME*/
                .rememberMe().tokenRepository(persistentTokenRepository())
                .userDetailsService(this.userDetailsService)
                .tokenValiditySeconds(86400) // 24 hour
                .useSecureCookie(true)

                .and()

                /*============== LOGIN configurations*/
                .formLogin().defaultSuccessUrl("/account/home")
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()

                /*============== LOGOUT configurations*/
                .logout().deleteCookies("programmersCookie");

    }

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    /**
     * We need this bean for the session management. Specially if we want to control the concurrent session-control support
     * with Spring security.
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }



    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**");
    }

    /**
     * DAO authentication provider. This authentication provider will authenticate the user with the help of
     *
     * @return
     * @UserdetailsService. This is based on the validating the user with the username and password.
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    /**
     * Authentication manager which will be invoked by Spring security filter chain. This authentication
     * manager will delegate the work to the Authentication provider to
     * authenticate the user. Look out for the @DaoAuth provider in the above section to see
     * how it works with this.
     *
     * @param auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }

    /**
     * Using this to persist the remember-me token in the database for more secure approach.
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}