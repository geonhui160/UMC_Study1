package umc.study.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public MemberMission findMemberMissionByMissionId(Long missionId) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(missionId != null) {
            predicate.and(memberMission.mission.id.eq(missionId));
        }

        return jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .where(predicate)
                .fetchOne();
    }
}
