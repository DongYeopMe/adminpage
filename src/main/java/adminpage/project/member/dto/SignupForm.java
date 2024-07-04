package adminpage.project.member.dto;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Member;
import adminpage.project.member.entity.Rank;

import lombok.*;

@AllArgsConstructor
@Setter
@Builder
@Getter
@NoArgsConstructor
public class SignupForm {

    private String userId;

    private String name;

    private String email;

    private String password;

    private Gender gender;

    private Rank rank;
    public Member covertMember(SignupForm signupForm){
        return Member.builder().
                email(email).name(name).password(password).gender(gender).rank(rank).build();
    }
}
