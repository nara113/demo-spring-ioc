package springapplicationcontext.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SpELRunner implements ApplicationRunner {

    @Value("#{1 + 3}")
    int value;

    @Value("#{'hello ' + 'world'}")
    String hello;

    @Value("#{1 eq 1}")
    boolean aBoolean;

    @Value("#{'hello'}")
    String hello2;

    //$는 프로퍼티
    @Value("${my.value}")
    int myValue;

    @Value("#{${my.value} == 200}")
    boolean b;

    //bean의
    @Value("#{bean.value}")
    int beanValue;


    @Override
    public void run(ApplicationArguments args) throws IOException {
        System.out.println("================= SpEL");
        System.out.println(value);
        System.out.println(hello);
        System.out.println(aBoolean);
        System.out.println(hello2);
        System.out.println(myValue);
        System.out.println(b);
        System.out.println(beanValue);

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("1 + 1");
        //ConversionService 사용
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);
        System.out.println("================= SpEL");

    }
}
