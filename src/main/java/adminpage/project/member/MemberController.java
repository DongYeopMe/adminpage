package adminpage.project.member;

import adminpage.project.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    final private MemberService memberService;

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("signupRequest",new SignupRequest());
        return "member/addForm";
    }
    @PostMapping("/add")
    public String addMember(SignupRequest signupRequest){
        memberService.save(signupRequest);
        return "redirect:/member/getMemberList";
    }
    @GetMapping("/edit/{memberId}")
    public String editForm(@PathVariable Long memberId,Model model){
        MemberResponse memberResponse = memberService.getMember(memberId);
        model.addAttribute("memberResponse",memberResponse);
        return "member/editForm";
    }
    @PostMapping("/edit/{memberId}")
    public String editMember(@PathVariable Long memberId ,@ModelAttribute MemberRequest memberRequest){
        memberService.updateMember(memberId,memberRequest);
        return "redirect:/member/getMemberList";
    }
    @GetMapping("/getMember/{memberId}")
    public String getMember(@PathVariable Long memberId, Model model){
        MemberResponse memberResponse = memberService.getMember(memberId);
        model.addAttribute("memberResponse",memberResponse);
        return "member/member";
    }
    @GetMapping("/getMemberList")
    public String getMember(MemberListRequest memberListRequest, Model model){
        List<MemberResponse> memberResponseList = memberService.getMemberList(memberListRequest);
        model.addAttribute("memberList",memberResponseList);
        model.addAttribute("memberListRequest",memberListRequest);
        return "member/members";
    }


}
