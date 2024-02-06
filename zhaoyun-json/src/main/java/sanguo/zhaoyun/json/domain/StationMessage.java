package sanguo.zhaoyun.json.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StationMessage extends MessageContent {
    /**
     * 站点编号
     */
    private String stationCode;

    /**
     * 容器编号
     */
    private String podID;

    /**
     * 1：站点预占状态
     * 2：站点占用状态
     * 3：站点释放状态
     */
    private int occupyStatus;

}
