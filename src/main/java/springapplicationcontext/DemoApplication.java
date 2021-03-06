package springapplicationcontext;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import out.OutService;
import springapplicationcontext.configuration.ApplicationConfig;

import java.util.Arrays;

@PropertySource("classpath:/app.properties")
@EnableAsync
@SpringBootApplication
public class DemoApplication {

    public  static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    private static void method2(String[] args) {
        //빠르다. @Bean 으로 등록하는 것 보단 나음
        new SpringApplicationBuilder()
                .sources(DemoApplication.class)
                .initializers((ApplicationContextInitializer<GenericApplicationContext>) applicationContext -> {
                    applicationContext.registerBean(OutService.class);
                    applicationContext.registerBean(ApplicationRunner.class, () -> a -> System.out.println("runner!!"));
                })
                .run(args);
    }

    private static void method1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-testtest.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beanDefinitionNames));

        ApplicationContext context2 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String[] beanDefinitionNames2 = context2.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beanDefinitionNames2));
    }

    @Bean
    public MessageSource messageSource() {
        var m = new ReloadableResourceBundleMessageSource();
        m.setBasename("classpath:/messages");
        m.setDefaultEncoding("UTF-8");
//        m.setCacheSeconds(2);

        return m;
    }

}
