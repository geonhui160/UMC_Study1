package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.ReviewDto.ReviewRequestDTO;
import umc.study.web.dto.ReviewDto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping(value = "/add/review/storeId/{storeId}")
    public ApiResponse<ReviewResponseDTO.addResultDTO> add(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO.AddResultDTO request
    ) {
        Review review = reviewCommandService.addReview(storeId, request);

        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }
}