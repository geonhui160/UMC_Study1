package umc.study.web.dto.MissionDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class addMissionResultDTO {

        @NotNull
        Integer reward;

        @NotNull
        String missionSpec;
    }
}