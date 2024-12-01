package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.study.validation.annotation.PageAvailable;

@Component
public class PageAvailableValidator implements ConstraintValidator<PageAvailable, Integer> {

    @Override
    public void initialize(PageAvailable constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {
        return page != null && page >= 0;
    }
}