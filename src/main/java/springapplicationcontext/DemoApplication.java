package springapplicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springapplicationcontext.configuration.ApplicationConfig;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public  static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private static void method1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-test.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beanDefinitionNames));

        ApplicationContext context2 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String[] beanDefinitionNames2 = context2.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beanDefinitionNames2));
    }

}
