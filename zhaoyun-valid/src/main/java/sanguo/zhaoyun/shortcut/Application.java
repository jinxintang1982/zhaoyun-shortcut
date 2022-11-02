package sanguo.zhaoyun.shortcut;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sanguo.zhaoyun.shortcut.valid.ServiceMethod;


@SpringBootApplication
public class Application {

    @Autowired
    ServiceMethod validMethod;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}

