package sanguo.zhaoyun.shortcut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sanguo.zhaoyun.shortcut.reuslt.BusinessException;
import sanguo.zhaoyun.shortcut.reuslt.DataResult;
import sanguo.zhaoyun.shortcut.reuslt.ErrCodeEnum;


@RestController
@RequestMapping(value = "/test")

public class RestTestController {

    @RequestMapping(value = "/throw")
    public DataResult throwException(Boolean isThrow) {
        if (isThrow) {
            throw new BusinessException(ErrCodeEnum.UPDATE_ERROR);
        }
        return DataResult.success();
    }

}
