package sanguo.zhaoyun.shortcut.valid.controller;


import javax.validation.constraints.NotNull;

public class RequestParam {

    @NotNull(message = "年龄不能为空")
    public Long age;

    @NotNull(message = "姓名不能为空", groups = {ISaveGroup.class})
    public String name;

    @Override
    public String toString() {
        return "RequestParam{" +
                "age=" + age +
                ", nanme=" + name +
                '}';
    }
}
