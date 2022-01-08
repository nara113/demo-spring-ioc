package springapplicationcontext.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class ValidatorRunner implements ApplicationRunner {

    //스프링부트 2.0.5 부터 LocalValidatorFactoryBean 등록
    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("validator : " + validator.getClass());

        Event event = new Event();
        event.setAge(-1);
        event.setEmail("a");
        Errors errors = new BeanPropertyBindingResult(event, "event");

//        EventValidator validator = new EventValidator();

        validator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println(Arrays.toString(e.getCodes()));
            System.out.println(e.getDefaultMessage());
        });
    }
}
