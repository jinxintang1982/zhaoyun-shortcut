package sanguo.zhaoyun.shortcut.AdviceException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhangchangzhi
 * @create: 2020-07-24 17:49
 **/

@RestController
@Slf4j
@RequestMapping("/test/fork")
public class BusiController {

    @Autowired
    BusiService busiService;

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public DataResult doBusiness(String param){

        return DataResult.success();
    }


}
