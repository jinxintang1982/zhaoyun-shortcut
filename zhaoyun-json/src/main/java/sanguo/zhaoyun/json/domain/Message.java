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
    private int  messageType;
    private String warehouseID;
    private String clientCode;
    private long taskID;
    private String createTime;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
    @JsonSubTypes({
            @JsonSubTypes.Type(value=TaskCompleteMessage.class, name = "10"),
            @JsonSubTypes.Type(value=StationMessage.class, name = "60"),
    })
    private MessageContent content;
}
