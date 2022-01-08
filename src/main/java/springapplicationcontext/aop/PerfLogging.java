package springapplicationcontext.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.CLASS)
public @interface PerfLogging {
}
