package sanguo.zhaoyun.json.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private long messageID;
    private int  messageType;//根据该类型对content熟悉进行转换
    private String warehouseID;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
    //JsonTypeInfo.Id.NAME 与JsonSubTypes.Type中的name进行匹配
    //property = "messageType" 与主类型中int messageType匹配
    @JsonSubTypes({
            @JsonSubTypes.Type(value=TaskCompleteMessage.class, name = "10"),
            @JsonSubTypes.Type(value=StationMessage.class, name = "60"),
    })
    //value=TaskCompleteMessage.class指定要转换的类
    //name = "10"指定messageType所对应的转换类
    //如果messageType不等于10或60，则会抛出异常；
    //value=TaskCompleteMessage.class指定转换的类型，继承与MessageContent类型
    private MessageContent content;
}
