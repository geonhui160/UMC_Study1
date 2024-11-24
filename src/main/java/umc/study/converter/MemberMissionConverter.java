package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionDto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MissionResponseDTO.changeResultDTO changeResultDTO(MemberMission mission) {
        return MissionResponseDTO.changeResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission) {

        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }
}