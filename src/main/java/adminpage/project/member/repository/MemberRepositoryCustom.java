package adminpage.project.member.repository;

import adminpage.project.member.dto.MemberListForm;
import adminpage.project.member.dto.MemberResponse;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberResponse> findMemberResponselist(MemberListForm memberListForm);
}
