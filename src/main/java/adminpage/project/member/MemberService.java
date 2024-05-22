package adminpage.project.member;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ErrorCode;
import adminpage.project.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static adminpage.project.member.MemberResponse.covertmemberResponse;

@Service
@RequiredArgsConstructor
public class MemberService {
    final private MemberRepository memberRepository;

    public void save(SignupRequest signupRequest) {
        Member member=signupRequest.covertMember(signupRequest);
        memberRepository.save(member);
    }
    public void updateMember(Long memberId,MemberRequest memberRequest){
        Member member=memberRepository.findById(memberId).orElseThrow(() ->new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        member.setEmail(memberRequest.getEmail());
        member.setName(memberRequest.getName());
        member.setPassword(memberRequest.getPassword());
        member.setGender(memberRequest.getGender());
        member.setRank(memberRequest.getRank());
    }
    public MemberResponse getMember(Long memberId) {
        Member member=memberRepository.findById(memberId).orElseThrow(() ->new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        return covertmemberResponse(member);
    }
    public List<MemberResponse> getMemberList(MemberListRequest memberListRequest){
        List<MemberResponse> responseList= memberRepository.findMemberResponselist(memberListRequest);
        return responseList;
    }
}
