package adminpage.project.member;

import adminpage.project.member.entity.Gender;
import adminpage.project.member.entity.Rank;
import adminpage.project.product.entity.Category;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static adminpage.project.member.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    @Override
    public List<MemberResponse> findMemberResponselist(MemberListRequest memberListRequest) {
        return queryFactory.select(Projections.fields(
                MemberResponse.class,
                member.id,
                member.email,
                member.name,
                member.gender,
                member.rank
        ))
                .from(member)
                .where(condRank(memberListRequest.getRank()),condGender(memberListRequest.getGender()),condLikeName(memberListRequest.getName()))
                .orderBy(member.id.desc())
                .fetch();
    }
    private static Predicate condRank(Rank rank){
        return rank != null ? member.rank.eq(rank) : null;
    }
    private static Predicate condGender(Gender gender) {
        return gender != null ? member.gender.eq(gender) : null;
    }
    private static Predicate condLikeName(String name){
        return StringUtils.hasText(name) ? member.name.contains(name) : null;
    }
}
