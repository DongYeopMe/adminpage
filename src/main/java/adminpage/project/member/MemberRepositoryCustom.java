package adminpage.project.member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberResponse> findMemberResponselist(MemberListRequest memberListRequest);
}
