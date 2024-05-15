package adminpage.project.member;

import adminpage.project.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
    final private MemberService memberService;

    @GetMapping("add")
    public String addForm(Model model){
        model.addAttribute("member",new Member());
        return "member/addForm";
    }
    @PostMapping("add")
    public String addMember(SignupRequest signupRequest){
        memberService.save(signupRequest);
        return "redirect::/member/list";
    }

}
