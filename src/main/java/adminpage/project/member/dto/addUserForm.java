package adminpage.project.member.dto;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Member;
import adminpage.project.member.entity.Rank;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Setter
@Builder
@Getter
@NoArgsConstructor
public class addUserForm {
    @NotBlank
    private String userId;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private Gender gender;
    @NotNull
    private Rank rank;
    public Member covertMember(addUserForm addUserForm){
        return Member.builder().
                email(email).name(name).password(password).gender(gender).rank(rank).build();
    }
}
