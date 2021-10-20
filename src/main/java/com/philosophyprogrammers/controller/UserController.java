package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.PhilosophyProgrammersEntity;
import com.philosophyprogrammers.modules.User;
import com.philosophyprogrammers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String users(ModelMap modelMap) {
        List<PhilosophyProgrammersEntity> users = userService.getUsers();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/registration")
    public String register(@ModelAttribute("newUser")
                                   PhilosophyProgrammersEntity philosophyProgrammersEntity) {
        return "registration";
    }

    @PostMapping("/registration")
    public String signUp(PhilosophyProgrammersEntity philosophyProgrammersEntity, ModelMap modelMap) {
        Optional<PhilosophyProgrammersEntity> userFromDb =
                userService.findByUsername(philosophyProgrammersEntity.getName());

        if (userFromDb != null) {
            modelMap.put("message", "User exists!");
            return "registration";
        }

        User user = new User();

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setRoles(Arrays.asList("ROLE_USER"));

//        return repository.save(user);

        userService.signUpUser(philosophyProgrammersEntity);
        return "redirect:/users";
    }

//    @PostMapping("/registration")
//    public String register(, Map<String, Object> model) {
//        //todo тут изменить model
//        UserEntity userFromDb =
//                userRepository.findByUsername(userEntity.getUsername());
//
//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//
//        userEntity.setActive(true);
//        userEntity.setUserRoles(Collections.singleton(UserRole.USER));
//        userRepository.save(userEntity);
//
//        return "redirect:/user";
//    }


}
