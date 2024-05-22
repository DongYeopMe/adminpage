package adminpage.project.member;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Member;
import adminpage.project.member.entity.Rank;

import lombok.*;

@AllArgsConstructor
@Setter
@Builder
@Getter
@NoArgsConstructor
public class SignupRequest {

    private String email;

    private String password;

    private Gender gender;

    private Rank rank;
    Member covertMember(SignupRequest signupRequest){
        return Member.builder().
                email(email).password(password).gender(gender).rank(rank).build();
    }
}
