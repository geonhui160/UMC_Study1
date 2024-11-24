package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionDto.MissionRequestDTO;
import umc.study.web.dto.MissionDto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {

    public static MissionResponseDTO.addResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.addResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(Store store, MissionRequestDTO.addMissionResultDTO request) {

        return Mission.builder()
                .memberMissionList(new ArrayList<>())
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }
}
