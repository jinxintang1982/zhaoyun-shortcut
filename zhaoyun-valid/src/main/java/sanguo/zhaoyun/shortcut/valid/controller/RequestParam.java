package sanguo.zhaoyun.shortcut.valid.controller;
import javax.validation.constraints.NotNull;

public class RequestParam {

    private static final long serialVersionUID = 1L;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Long pageNo;

    @Override
    public String toString() {
        return "AssistMsgPageRequest{" +
                "pageNo=" + pageNo +
                '}';
    }

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }
}
