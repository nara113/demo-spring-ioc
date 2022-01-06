package springapplicationcontext.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springapplicationcontext.CoffeeRepository;
import springapplicationcontext.CoffeeService;
import springapplicationcontext.DemoApplication;

@Configuration
//@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {

    @Bean
    public CoffeeRepository coffeeRepository() {
        return new CoffeeRepository();
    }

    @Bean
    public CoffeeService coffeeService(CoffeeRepository coffeeRepository) {
        CoffeeService coffeeService = new CoffeeService();
        coffeeService.setCoffeeRepository(coffeeRepository);

        return coffeeService;
    }
}
