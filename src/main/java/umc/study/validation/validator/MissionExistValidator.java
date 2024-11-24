package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionRepository.existsById(value);

        MemberMission memberMission = memberMissionRepository.findMemberMissionByMissionId(value);

        if (memberMission == null) {
            return true; // 진행 중이지 않으므로 검증 통과
        }
        // memberMission 상태가 CHALLENGING인지 확인
        if (memberMission.getStatus().equals(MissionStatus.CHALLENGING)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
            return false; // 이미 진행 중인 상태
        }
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }



        return isValid;
    }
}