package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.DTO.MissionDTO;
import umc.study.DTO.MissionRegionDTO;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionDto.MissionRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MissionDTO> getOngoingMissions(Long memberId, Long cursor) {
        return missionRepository.findIsOnGoingMissions(memberId, cursor);
    }

    @Override
    public List<MissionDTO> getFinishedMissions(Long memberId, Long cursor) {
        return missionRepository.findIsFinishedMissions(memberId, cursor);
    }

    @Override
    public List<MissionRegionDTO> getMissionsInRegion(String regionName, Long cursor, Long memberId) {
        return missionRepository.findMissionsInRegion(regionName, cursor, memberId);
    }

    @Override
    public Mission addMission(Long storeId, MissionRequestDTO.addMissionResultDTO request) {

        Store store = storeRepository.getReferenceById(storeId);

        Mission newMission = MissionConverter.toMission(store, request);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission changeMissionToOnGoing(Long missionId) {

        Member member = memberRepository.getReferenceById(2L);

        Mission mission = missionRepository.getReferenceById(missionId);

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);

        return memberMissionRepository.save(memberMission);
    }
}
