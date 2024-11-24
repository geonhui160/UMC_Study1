package umc.study.web.dto.ReviewDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddResultDTO {

        @NotNull
        String title;

        @NotNull
        Float score;
    }
}