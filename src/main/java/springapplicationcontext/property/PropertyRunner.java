package springapplicationcontext.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertyRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Value("${property.test}")
    private String propertyTest;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}'.split(',')}")
    private List<String> propertyTestList;

    @Override
    public void run(ApplicationArguments args) {
        Environment environment = ctx.getEnvironment();
        System.out.println("environment.getProperty : " + environment.getProperty("property.test.spring"));
    }
}
