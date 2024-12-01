package umc.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {


    @Query("SELECT mm FROM MemberMission mm WHERE mm.status = :status AND mm.member = :member")
    Page<MemberMission> findByMemberAndMissionStatus(
            @Param("member") Member member,
            @Param("status") MissionStatus status,
            PageRequest pageRequest
    );

}

