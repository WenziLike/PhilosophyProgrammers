package com.philosophyprogrammers.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Spring Security Login Configurations
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/registration", "/login").permitAll()
                .antMatchers("/account/**", "/write").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .and()
                /*============== REMEMBER ME*/
                .rememberMe().tokenRepository(persistentTokenRepository())
                .rememberMeCookieName("custom-remember-me-cookie")
                .userDetailsService(this.userDetailsService)
//                .rememberMeParameter("username")
//                .rememberMeServices(null)

                // Checking cookies in seconds
                .tokenValiditySeconds(86400)
                .useSecureCookie(true)
                .and()


                /*============== LOGIN configurations*/
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/account/home")
                        .failureUrl("/login?error=true")
                )
                /*============== LOGOUT*/
                .logout().invalidateHttpSession(true)
                .logoutSuccessUrl("/login");
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

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**");
    }

    /**
     * DAO authentication provider. This authentication provider will authenticate the user with the help of
     * This is based on the validating the user with the username and password.
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

}