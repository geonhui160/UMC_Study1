package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewDto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Review addReview(Long storeId, ReviewRequestDTO.AddResultDTO request) {

        Member member = memberRepository.getReferenceById(2L);
        Store store = storeRepository.getReferenceById(storeId);

        Review newReview = ReviewConverter.toReview(member, store, request);

        return reviewRepository.save(newReview);
    }
}