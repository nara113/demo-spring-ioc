package springapplicationcontext.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ResourceRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws IOException {
        System.out.println("resourceLoader.getClass() : " + resourceLoader.getClass());

        //classpath 접두어로 resource 타입 강제 (ClassPathResource)
        Resource resource = resourceLoader.getResource("classpath:text.txt");
        System.out.println("resource.getClass() : " + resource.getClass());
        System.out.println(resource.exists());
        System.out.println(Files.readString(Path.of(resource.getURI())));

        //Tomcat started on port(s): 8080 (http) with context path ''
        //내장 톰캣은 context path 가 지정되어 있지 않다. (리소스 찾을 수 없음)
        Resource resource2 = resourceLoader.getResource("text.txt");
        System.out.println("resource2.getClass() : " + resource2.getClass());
    }
}
