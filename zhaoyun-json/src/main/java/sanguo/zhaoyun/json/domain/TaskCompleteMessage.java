package sanguo.zhaoyun.json.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TaskCompleteMessage extends MessageContent {
    /**
     * tes任务id
     */
    private long taskID;

    /**
     * 任务优先级
     */
    private int priority;

    /**
     * 业务id
     */
    private String bizID;

    /**
     * 任务类型 3: MOVE_POD 载具移动 2: MOVE_ROBOT 机器人移动 60：CUSTOM    外部任务 4： GO_CHARGE  去充电 5：CHANGE_MAP 切换地图 TaskTypePALLETIZE
     * = 6; // 码垛 TaskTypeDEPALLETIZE = 7; // 拆垛
     */
    private int taskType;

    /**
     * 任务当前状态 0: INIT 初始状态 1: READY, 待分配运力 2: RUNNING 进行中 4: DONE, 已成功, 5: FAILED, 已失败 3: CANCELING, 取消中 6: CANCELED,
     * 已取消
     */
    private int status;

    /**
     * 任务失败的错误码
     */
    private int errorCode;

    /**
     * 任务失败的错误信息
     */
    private String errorReason;

    /**
     * 运力机器人ID
     */
    private String robotID;

    /**
     * 载具ID
     */
    private String podID;


    /**
     * 终点位置类型 1 NODEID, 导航点, 2 STORAGEID, 储位, 3 ZONEID, 存储区 | 站点 | 作业位组
     */
    private int desType;

    /**
     * 导航点ID
     */
    private String desNodeID;

    /**
     * 背篓ID
     */
    private Integer desBasketID;

    /**
     * 储位ID
     */
    private String desStorageID;

    /**
     * 目标区域ID
     */
    private String desZoneID;

    /**
     * 目标站点
     */
    private String desZoneCode;

    /**
     * 拆垛扩展字段
     */
    private String result;

    /**
     * 入库使用储位id， 出库使用stationCode
     */
    public String getLocation() {
        if (this.desType == 7 || this.desType == 2) {
            return this.desStorageID;
        } else {
            return this.desZoneCode;
        }
    }
}
