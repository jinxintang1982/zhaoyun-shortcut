package sanguo.zhaoyun.shortcut.reuslt;

/**
 * 各种错误码
 *
 * @author anning
 * 2019-08-22 10:07
 **/
public enum ErrCodeEnum {
    COMMON_ERROR(1000, "通用错误"),

    //-----1000~2000为系统异常,
    UPDATE_ERROR(1001,"更新数据失败"),
    SAVE_ERROR(1002,"保存数据失败"),
    ENUM_ERROR(1003,"枚举值异常"),
    PARAM_ERROR(1004,"参数校验异常"),

    //-----2000~3000为业务异常；
    ORDER_NO_JOB(2001,"该订单的货架没有出库job"),
    ORDER_NOT_ARRIVED(2002,"订单还未到站点"),
    ORDER_CONFIRM_REPEAT(2003,"此订单任务正在或者已经返回库区，请勿重复请求"),
    ORDER_NO_REPEAT(2009,"订单编码重发"),
    ORDER_NO_INVALID(2011,"订单编码不存在"),

    NOTIFY_BACK_FAIL(2010,"通知WM返回仓库失败"),
    NOTIFY_FORK_FAIL(2004,"叉车任务执行失败"),
    NOTIFY_CANCEL_FAIL(2012,"通知WM返回仓库失败"),
    AGV_MOVE_FAIL(2005,"AGV移动任务下发失败"),
    FORK_MOVE_FAIL(2006,""),
    JOB_CONFORM_FAIL(2007,"AGV返回任务发送失败"),

    FRAME_NO_REPEAT(2009,"当前货架已经有正在执行的订单"),
    ;

    private int errCode;
    private String errMsg;

    ErrCodeEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }}
