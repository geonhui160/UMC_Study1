package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.PageAvailable;
import umc.study.web.dto.MemberDto.MemberRequestDTO;
import umc.study.web.dto.MemberDto.MemberResponseDTO;
import umc.study.web.dto.MemberMissionDto.MemberMissionResponseDTO;
import umc.study.web.dto.ReviewDto.ReviewResponseDTO;
import umc.study.web.dto.StoreDto.StoreResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberqueryservice;
    private final ReviewQueryService reviewqueryservice;

    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
    @GetMapping("/member/{memberId}/Myreviews")
    @Operation(summary = "특정 맴버가 쓴 리뷰 조회 ",description = "특정 멤버의 리뷰를 조회하는 API, query String 으로 page 번호")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!")
    })
//    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistMember @PathVariable(name = "memberId") Long storeId, @RequestParam(name = "page") Integer page){
//        Page<Review> reviewList = memberqueryservice.getmyReviewList(memberId, page);
//        return ApiResponse.onSuccess(MemberConverter.ReviewPreViewListDTO(reviewList));
//    }

    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMemberReviews(@ExistMember @PathVariable(name = "memberId") Long memberId,@   PageAvailable @RequestParam(name = "page") Integer page) {
        Page<Review> reviews = reviewqueryservice.getMyReviews(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviews));
    }

    @GetMapping("{memberId}/missions")
    @Operation(summary = "특정 맴버의 진행중인 미션 조회 ",description = "특정 멤버가 수행중인 미션을 조회하는 API, query String 으로 page 번호")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버아이디 넣어주세요, path variable")
    })

    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getCHALLENGINGMissionList(
            @ExistMember  @PathVariable(name = "memberId") Long memberId,
            @PageAvailable @RequestParam(name = "page") Integer page
    ){
        Page<MemberMission> memberMissionList = memberqueryservice.getCHALLENGINGMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.memberMissionPreViewListDTO(memberMissionList));
    }
}