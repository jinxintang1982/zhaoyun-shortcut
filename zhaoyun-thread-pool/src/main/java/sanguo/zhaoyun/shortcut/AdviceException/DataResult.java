package sanguo.zhaoyun.shortcut.AdviceException;


import lombok.Data;


/**
 * wms调用旷视接口后响应给wms的对象  需要转化为json字符串
 * 其他地方可能也会用到这个  因为那个BaseResponse里边的字段信息和WMS要求的不对应
 * 重新按照BaseResponse的形式写了一个类
 *
 * @param <T>
 */
@Data
public class DataResult<T> {

    /**
     * 成功与否标识:0表示成功，其他为错误代码
     */
    Integer code = 0;

    /**
     * 错误码
     */
    T data = null;

    /**
     * 错误信息
     */
    String msg = null;

    public DataResult() {

    }

    public DataResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static DataResult success() {
        return success(null);
    }

    public static <T> DataResult success(T data) {
        return new DataResult<>(0, "操作成功", data);
    }

    public static DataResult success(String errMsg) {
        return new DataResult(0, errMsg, null);
    }

    public static DataResult fail(ErrCodeEnum codeEnum) {
        return fail(codeEnum, null);
    }

    public static <T> DataResult fail(ErrCodeEnum codeEnum, T data) {
        return new DataResult<>(codeEnum.getErrCode(), codeEnum.getErrMsg(), data);
    }

    public static DataResult fail(BusinessException e) {
        return fail(e.getErrCode(), e.getErrMsg());
    }

    public static DataResult fail(int errCode, String errMsg) {
        return new DataResult(errCode, errMsg, null);
    }

}
