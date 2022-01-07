package springapplicationcontext.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")    //application-test.xml 존재하면 안됨
public class ProfileConfig {

    @Bean
//    @Profile("test")
    public ProfileService profileService() {
        return new ProfileService();
    }
}
