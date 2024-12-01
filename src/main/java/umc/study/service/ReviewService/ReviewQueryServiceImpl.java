package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService{
    private final MemberRepository memberrepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMyReviews(Long memberId, Integer page) {
        Member member = memberrepository.findById(memberId).get();

        Page<Review> reviews = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return reviews;
    }
}
