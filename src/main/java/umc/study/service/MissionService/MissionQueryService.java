package umc.study.service.MissionService;

import umc.study.DTO.MissionDTO;
import umc.study.DTO.MissionRegionDTO;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionDto.MissionRequestDTO;

import java.util.List;

public interface MissionQueryService {
    List<MissionDTO> getOngoingMissions(Long memberId, Long cursor);
    List<MissionDTO> getFinishedMissions(Long memberId, Long cursor);
    List<MissionRegionDTO> getMissionsInRegion(String regionName, Long cursor, Long memberId);

    Mission addMission(Long storeId, MissionRequestDTO.addMissionResultDTO request);

    MemberMission changeMissionToOnGoing(Long missionId);
}
