package springapplicationcontext.validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    @NotEmpty
    String title;

    @Min(0)
    Integer age;

    @Email
    String email;
}
