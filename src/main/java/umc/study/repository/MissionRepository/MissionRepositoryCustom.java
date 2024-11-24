package umc.study.repository.MissionRepository;

import umc.study.DTO.MissionDTO;
import umc.study.DTO.MissionRegionDTO;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MissionDTO> findIsOnGoingMissions(Long memberId, Long cursor);
    List<MissionDTO> findIsFinishedMissions(Long memberId, Long cursor);
    List<MissionRegionDTO> findMissionsInRegion(String regionName, Long cursor, Long memberId);
}