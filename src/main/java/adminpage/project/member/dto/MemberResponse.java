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
public class MemberResponse {
    private Long id;

    private String userid;

    private String name;

    private String email;

    private Gender gender;

    private Rank rank;

    public static MemberResponse covertmemberResponse(Member member){
        MemberResponse memberResponse= new MemberResponse();
        memberResponse.setId(memberResponse.getId());
        memberResponse.setUserid(member.getUserid());
        memberResponse.setEmail(member.getEmail());
        memberResponse.setName(member.getName());
        memberResponse.setGender(member.getGender());
        memberResponse.setRank(member.getRank());
        return memberResponse;
    }
}
