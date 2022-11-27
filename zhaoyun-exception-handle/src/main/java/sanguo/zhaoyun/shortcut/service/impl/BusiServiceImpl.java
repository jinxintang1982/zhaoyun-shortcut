package sanguo.zhaoyun.shortcut.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import sanguo.zhaoyun.shortcut.reuslt.BusinessException;
import sanguo.zhaoyun.shortcut.reuslt.ErrCodeEnum;
import sanguo.zhaoyun.shortcut.service.IBusiService;

@Service
public class BusiServiceImpl implements IBusiService {

    @Override
    public void doBusiness(String param){
        //IllegalArgumentException类型异常
        Assert.hasText(param,"param不能为空");
        //BusinessException自定义业务异常
        throw new BusinessException(ErrCodeEnum.JOB_CONFORM_FAIL,"param = "+param);
        //其他异常
        // int a = 1/0;
        //自定义异常
        //throw new RuntimeException("运行时异常");
    }
}
