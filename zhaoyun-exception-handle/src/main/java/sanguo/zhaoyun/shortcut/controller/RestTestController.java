package sanguo.zhaoyun.shortcut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sanguo.zhaoyun.shortcut.reuslt.BusinessException;
import sanguo.zhaoyun.shortcut.reuslt.DataResult;
import sanguo.zhaoyun.shortcut.reuslt.ErrCodeEnum;
import sanguo.zhaoyun.shortcut.service.IBusiService;


@RestController
@RequestMapping(value = "/test")
public class RestTestController {

    @Autowired
    IBusiService iBusiService;

    //没有使用统一异常处理；
    @RequestMapping(value = "noExceptionHandle")
    public DataResult noExceptionHandle(String param){
        try {
            iBusiService.doBusiness(param);
        } catch (BusinessException e) {
            return DataResult.fail(101, e.getMessage());
        }catch (IllegalArgumentException e) {
            return DataResult.fail(101, e.getMessage());
        } catch (Exception e) {
            return DataResult.fail(102, e.getMessage());
        }
        return DataResult.success();

    }

    //使用统一异常处理；
    @RequestMapping(value = "/useExceptionHandle")
    public DataResult useExceptionHandle(String param) {
        iBusiService.doBusiness(param);
        return DataResult.success();
    }

}
