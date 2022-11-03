package sanguo.zhaoyun.shortcut.valid.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;


@RestController
@RequestMapping(value = "/test")
@Validated
public class RestDemoController {

    @RequestMapping(value = "/validObject")
    public String validObject(@Validated @RequestBody RequestParam requestParam) {
        System.out.println("test");
        return "ok";
    }

    @RequestMapping(value = "/validBase")
    public String validBase(@Min(10) Integer count) {
        System.out.println("test = " + count);
        return "test = " + count;
    }

    @RequestMapping("/validGroup")
    public String saveUser(@RequestBody @Validated(ISaveGroup.class) RequestParam requestParam) {
        //必须填写name，才能通过
        return requestParam.toString();
    }
}
