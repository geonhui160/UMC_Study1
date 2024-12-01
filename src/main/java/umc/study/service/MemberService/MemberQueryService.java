package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    Page<Review> getmyReviewList(Long memberId, Integer page);

    Page<MemberMission> getCHALLENGINGMissionList(Long memberId, Integer page);


}
