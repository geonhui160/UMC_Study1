package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberDto.MemberRequestDTO;
import umc.study.web.dto.MemberDto.MemberResponseDTO;
import umc.study.web.dto.MemberMissionDto.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
    public static MemberMissionResponseDTO.MemberMissionPreViewDTO memberMissionPreViewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionPreViewDTO.builder()
                .missionId(memberMission.getMission().getId())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreViewListDTO memberMissionPreViewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDtoList = memberMissionList
                .stream()
                .map(MemberConverter::memberMissionPreViewDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreViewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDtoList.size())
                .memberMissionList(memberMissionPreViewDtoList)
                .build();
    }
}
