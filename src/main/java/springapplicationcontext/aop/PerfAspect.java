package springapplicationcontext.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    @Around("@annotation(PerfLogging)")
//    @Around("execution(* springapplicationcontext.aop.EventService.*(..))")
    public Object logPert(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return proceed;
    }

    @Before("bean(eventServiceImpl)")
    public void hello() {
        System.out.println("hello event!");
    }
}
