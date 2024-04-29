package adminpage.project.member.service;

import adminpage.project.member.dto.SignupRequest;
import adminpage.project.member.entity.Member;
import adminpage.project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    final private MemberRepository memberRepository;

    public void saveUser(SignupRequest signupRequest){
        if(memberRepository.findByEmail(signupRequest.getEmail()).isPresent()){
            System.out.println("이미 존재하는 이메일");
        }
        Member member =signupRequest.signuprequestconvertToUser(signupRequest);
        memberRepository.save(member);
    }


}
