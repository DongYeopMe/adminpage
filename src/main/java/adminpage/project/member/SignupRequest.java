package adminpage.project.member;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Rank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignupRequest {

    private String email;

    private String password;

    private Gender gender;

    private Rank rank;
}
