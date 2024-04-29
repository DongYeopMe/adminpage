package adminpage.project.member.controller;

import adminpage.project.member.dto.SignupRequest;
import adminpage.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberController {
    final private MemberService memberService;

    @GetMapping("/signup")
    public String saveForm(){
        return "user/addForm";
    }
    @PostMapping("/signup")
    public String createUser(@ModelAttribute("signupRequest") SignupRequest signupRequest){
        memberService.saveUser(signupRequest);
        return "redirect:user/loginForm";
    }


}
