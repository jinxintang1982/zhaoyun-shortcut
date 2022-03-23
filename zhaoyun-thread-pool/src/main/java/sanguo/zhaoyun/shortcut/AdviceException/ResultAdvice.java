package sanguo.zhaoyun.shortcut.AdviceException;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 返回结果处理
 *
 * @author anning
 * 2019-07-09 22:55
 **/
@Slf4j
@RestControllerAdvice
public class ResultAdvice {

    /**
     * 业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public DataResult exceptionHandler(BusinessException e) {
        log.error("业务异常", e);
        return DataResult.fail(e);

    }

    /**
     * 参数错误异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Object exceptionHandler(IllegalArgumentException e) {
        log.error("参数错误异常", e);
        return DataResult.fail(120, e.getMessage());
    }

    /**
     * 其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        log.error("未定义异常", e);
        return DataResult.fail(110, e.getMessage());
    }

}
