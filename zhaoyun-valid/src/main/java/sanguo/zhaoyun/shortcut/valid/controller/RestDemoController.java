package sanguo.zhaoyun.shortcut.valid.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/test")
public class RestDemoController {

    @RequestMapping(value = "/valid")
    public String testValid(@Valid RequestParam msgPageRequest ) {
        System.out.println("test");
        return "ok";
    }

}
