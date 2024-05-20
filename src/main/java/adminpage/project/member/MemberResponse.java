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
public class MemberResponse {
    private String email;

    private Gender gender;

    private Rank rank;

    public static MemberResponse covertmemberResponse(Member member){
        MemberResponse memberResponse= new MemberResponse();
        memberResponse.setEmail(member.getEmail());
        memberResponse.setGender(member.getGender());
        memberResponse.setRank(member.getRank());
        return memberResponse;
    }
}
