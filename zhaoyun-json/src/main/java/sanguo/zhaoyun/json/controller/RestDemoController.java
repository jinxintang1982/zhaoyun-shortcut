package sanguo.zhaoyun.json.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class RestDemoController {
    //Controller默认为单例模式，其成员变量生命周期为整个应用，并且为各线程公用，使用ThreadLocal和线程安全对象
    @PostMapping("helloWorld")
    public String helloWorld() {
        return "hello world";
    }
}
