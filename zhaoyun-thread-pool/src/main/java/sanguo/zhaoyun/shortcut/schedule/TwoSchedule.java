package sanguo.zhaoyun.shortcut.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwoSchedule {

    //@Scheduled(fixedDelay = 1000)
    public void scheduled1() {
        try {
            log.info("-------scheduled1-------");
            Thread.sleep(40000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //@Scheduled(fixedDelay = 1000)
    public void scheduled2() {
        try {
            log.info("-------scheduled2-------");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
