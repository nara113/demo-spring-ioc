package springapplicationcontext.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springapplicationcontext.scope.Proto;
import springapplicationcontext.scope.Single;

import java.util.Arrays;

@Component
public class ProfileRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    ProfileService profileService;

    @Override
    public void run(ApplicationArguments args) {
        Environment environment = ctx.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
    }
}
