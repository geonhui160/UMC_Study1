package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewDto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(Long storeId, ReviewRequestDTO.AddResultDTO request);
}
