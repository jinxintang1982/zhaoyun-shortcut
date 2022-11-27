package sanguo.zhaoyun.shortcut.reuslt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.validation.ConstraintViolationException;

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
     * @param
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
     * @param
     * @return
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Object exceptionHandler(IllegalArgumentException e) {
        log.error("assert 参数错误异常", e);
        return DataResult.fail(ErrCodeEnum.ENUM_ERROR,e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object exceptionHandler(MethodArgumentNotValidException e) {
        log.error("valid 参数校验异常", e);
        return DataResult.fail(ErrCodeEnum.ENUM_ERROR,e.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Object exceptionHandler(ConstraintViolationException e) {
        log.error("valid 参数校验异常", e);
        return DataResult.fail(ErrCodeEnum.ENUM_ERROR,e.getMessage());
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
        return DataResult.fail(ErrCodeEnum.COMMON_ERROR, e.getMessage());
    }

}
