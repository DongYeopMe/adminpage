package adminpage.project.member.dto;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Rank;
import lombok.*;

@AllArgsConstructor
@Setter
@Builder
@Getter
@NoArgsConstructor
public class MemberEditForm {
    private String email;

    private String password;

    private String name;

    private Gender gender;

    private Rank rank;
}
