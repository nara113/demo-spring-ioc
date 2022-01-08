package springapplicationcontext.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class validator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty");
    }
}
