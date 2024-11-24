package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MemberExistValidator;

import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션
@Constraint(validatedBy = {
        MemberExistValidator.class,
}) // 어노테이션의 적용 범위를 지정
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER } )
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 생명 주기를 지정합니다. 위의 코드는 RUNTIME이기에 실행 하는 동안에만 유효
public @interface ExistMember {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}