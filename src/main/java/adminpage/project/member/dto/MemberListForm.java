package adminpage.project.member.dto;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberListForm {
    private Rank rank;
    private Gender gender;
    private String name;
}
