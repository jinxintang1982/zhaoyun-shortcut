package sanguo.zhaoyun.shortcut.AdviceException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class BusiService {

    @Transactional
    public void doBusiness(String param){
        //IllegalArgumentException类型异常
        Assert.hasText(param,"param不能为空");

        //BusinessException自定义业务异常
        throw new BusinessException(ErrCodeEnum.JOB_CONFORM_FAIL,"param = "+param);

        //其他异常
        //int a = 1/0;
        //throw new RuntimeException("运行时异常");
    }
}
