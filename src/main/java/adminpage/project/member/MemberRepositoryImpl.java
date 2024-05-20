package adminpage.project.member;

import adminpage.project.member.entity.Rank;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static adminpage.project.member.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    @Override
    public List<MemberResponse> findMemberResponselist(MemberListRequest memberListRequest) {
        return queryFactory.select(Projections.fields(
                MemberResponse.class,
                member.email,
                member.gender,
                member.rank
        ))
                .from(member)
                .where(condRank(memberListRequest.getRank()))
                .orderBy(member.id.desc())
                .fetch();
    }
    private static Predicate condRank(Rank rank){
        return rank != null ? member.rank.eq(rank) : null;
    }
}
