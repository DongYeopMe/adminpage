package adminpage.project.member.service;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ErrorCode;
import adminpage.project.member.dto.addUserForm;
import adminpage.project.member.repository.MemberRepository;
import adminpage.project.member.dto.MemberEditForm;
import adminpage.project.member.dto.MemberListForm;
import adminpage.project.member.dto.MemberResponse;
import adminpage.project.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static adminpage.project.member.dto.MemberResponse.covertmemberResponse;

@Service
@RequiredArgsConstructor
public class MemberService {
    final private MemberRepository memberRepository;

    public void save(addUserForm addUserForm) {
        Member member= addUserForm.covertMember(addUserForm);
        memberRepository.save(member);
    }
    public void updateMember(Long memberId, MemberEditForm memberEditForm){
        Member member=memberRepository.findById(memberId).orElseThrow(() ->new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        member.setEmail(memberEditForm.getEmail());
        member.setName(memberEditForm.getName());
        member.setPassword(memberEditForm.getPassword());
        member.setGender(memberEditForm.getGender());
        member.setRank(memberEditForm.getRank());
    }
    public MemberResponse getMember(Long memberId) {
        Member member=memberRepository.findById(memberId).orElseThrow(() ->new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        return covertmemberResponse(member);
    }
    public List<MemberResponse> getMemberList(MemberListForm memberListForm){
        List<MemberResponse> responseList= memberRepository.findMemberResponselist(memberListForm);
        return responseList;
    }
}
