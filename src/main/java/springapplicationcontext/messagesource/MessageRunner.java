package springapplicationcontext.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springapplicationcontext.profile.ProfileService;

import java.util.Arrays;
import java.util.Locale;

@Component
public class MessageRunner implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true) {
            System.out.println(messageSource.getMessage("hello", new String[]{"스프링"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("hello", new String[]{"spring"}, Locale.getDefault()));

            Thread.sleep(1000);
        }
    }
}
