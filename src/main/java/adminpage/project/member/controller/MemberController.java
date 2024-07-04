package adminpage.project.member.controller;

import adminpage.project.member.dto.MemberForm;
import adminpage.project.member.dto.MemberListForm;
import adminpage.project.member.dto.MemberResponse;
import adminpage.project.member.dto.SignupForm;
import adminpage.project.member.service.MemberService;
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
        model.addAttribute("signupForm",new SignupForm());
        return "member/addForm";
    }
    @PostMapping("/add")
    public String addMember(SignupForm signupForm){
        memberService.save(signupForm);
        return "redirect:/member/getMemberList";
    }
    @GetMapping("/edit/{memberId}")
    public String editForm(@PathVariable Long memberId,Model model){
        MemberResponse memberResponse = memberService.getMember(memberId);
        model.addAttribute("memberResponse",memberResponse);
        return "member/editForm";
    }
    @PostMapping("/edit/{memberId}")
    public String editMember(@PathVariable Long memberId ,@ModelAttribute MemberForm memberForm){
        memberService.updateMember(memberId, memberForm);
        return "redirect:/member/getMemberList";
    }
    @GetMapping("/getMember/{memberId}")
    public String getMember(@PathVariable Long memberId, Model model){
        MemberResponse memberResponse = memberService.getMember(memberId);
        model.addAttribute("memberResponse",memberResponse);
        return "member/member";
    }
    @GetMapping("/getMemberList")
    public String getMember(MemberListForm memberListForm, Model model){
        List<MemberResponse> memberResponseList = memberService.getMemberList(memberListForm);
        model.addAttribute("memberList",memberResponseList);
        model.addAttribute("memberListRequest", memberListForm);
        return "member/members";
    }


}
