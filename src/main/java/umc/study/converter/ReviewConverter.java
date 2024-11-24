package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewDto.ReviewRequestDTO;
import umc.study.web.dto.ReviewDto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static ReviewResponseDTO.addResultDTO toAddResultDTO(Review review) {
        return ReviewResponseDTO.addResultDTO.builder()
                .title(review.getTitle())
                .score(review.getScore())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(Member member, Store store, ReviewRequestDTO.AddResultDTO request) {
        return Review.builder()
                .member(member)
                .store(store)
                .title(request.getTitle())
                .reviewImageList(new ArrayList<>())
                .score(request.getScore())
                .build();
    }
}