package springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import springapplicationcontext.scope.Proto;
import springapplicationcontext.scope.Single;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    Proto proto;

    @Autowired
    Single single;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(single.getProto());
        System.out.println(single.getProto());
        System.out.println(single.getProto());
    }
}
