package umc.study.repository.MemberMissionRepository;

import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepositoryCustom {
    MemberMission findMemberMissionByMissionId(Long missionId);
}
