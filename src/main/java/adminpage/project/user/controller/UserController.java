package adminpage.project.user.controller;

import adminpage.project.user.dto.SignupRequest;
import adminpage.project.user.entity.User;
import adminpage.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    final private UserService userService;

    @GetMapping("/signup")
    public String saveFrom(){
        return "user/addForm";
    }
    @PostMapping("/signup")
    public String createUser(@ModelAttribute("signupRequest") SignupRequest signupRequest){
        userService.saveUser(signupRequest);

        return "user/loginForm";
    }


}
