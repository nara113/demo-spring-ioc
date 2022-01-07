package springapplicationcontext.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    @Autowired
    Proto proto;

    @Autowired
    ObjectProvider<Proto> proto2;

    public Proto getProto() {
//        return proto2.getIfAvailable();

        return proto;
    }
}
