package sanguo.zhaoyun.shortcut.reuslt;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 *
 * @author anning
 * 2019-07-05 11:49
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -671383964620401627L;

    private int errCode = ErrCodeEnum.COMMON_ERROR.getErrCode();

    private String errMsg;

    private BusinessException(int _errCode, String _errMsg) {
        super(_errMsg);
        this.errCode = _errCode;
        this.errMsg = _errMsg;
    }

    private BusinessException(String _errMsg) {
        super(_errMsg);
        this.errMsg = _errMsg;
    }

    private BusinessException(Throwable _throwable) {
        super(_throwable);
        this.errMsg = _throwable.getMessage();
    }

    private BusinessException(Throwable _throwable, String _errMsg) {
        super(_errMsg, _throwable);
        this.errMsg = _throwable.getMessage();
    }

    public BusinessException(ErrCodeEnum errCodeEnum) {
        super(errCodeEnum.getErrMsg());
        this.errCode = errCodeEnum.getErrCode();
        this.errMsg = errCodeEnum.getErrMsg();
    }

    public BusinessException(ErrCodeEnum errCodeEnum, String remarks) {
        super(errCodeEnum.getErrMsg() + ":" + remarks);
        this.errCode = errCodeEnum.getErrCode();
        this.errMsg = errCodeEnum.getErrMsg() + ":" + remarks;
    }

    public BusinessException(ErrCodeEnum errCodeEnum, Throwable cause) {
        super(errCodeEnum.getErrMsg(), cause);
        this.errCode = errCodeEnum.getErrCode();
        this.errMsg = errCodeEnum.getErrMsg();
    }

    public BusinessException(ErrCodeEnum errCodeEnum, String remarks, Throwable cause) {
        super(errCodeEnum.getErrMsg() + ":" + remarks, cause);
        this.errCode = errCodeEnum.getErrCode();
        this.errMsg = errCodeEnum.getErrMsg() + ":" + remarks;
    }

    public static BusinessException build(String errMsg) {
        return new BusinessException(errMsg);
    }


    public static BusinessException build(ErrCodeEnum errCodeEnum) {
        return new BusinessException(errCodeEnum.getErrCode(), errCodeEnum.getErrMsg());
    }

    public static BusinessException build(ErrCodeEnum errCodeEnum, String remarks) {
        return new BusinessException(errCodeEnum.getErrCode(), errCodeEnum.getErrMsg() + ":" + remarks);
    }

    public static BusinessException build(Throwable throwable) {
        return new BusinessException(throwable);
    }

    public static BusinessException build(String errMsg, Object... objs) {
        if (objs != null) {
            for (int i = 0; i < objs.length; i++) {
                errMsg = errMsg.replaceFirst("\\{\\}", String.valueOf(objs[i]));
            }
        }
        return build(errMsg);
    }

    public static BusinessException build(Throwable throwable, String errMsg, Object... objs) {
        if (objs != null) {
            for (int i = 0; i < objs.length; i++) {
                errMsg = errMsg.replaceFirst("\\{\\}", String.valueOf(objs[i]));
            }
        }

        return new BusinessException(throwable, errMsg);
    }
}
