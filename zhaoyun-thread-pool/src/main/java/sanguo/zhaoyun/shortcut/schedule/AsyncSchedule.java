package sanguo.zhaoyun.shortcut.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//@EnableAsync
public class AsyncSchedule {

    @Scheduled(fixedRate = 1000)
    //@Async
    public void scheduled1() {
        try {
            log.info("-------scheduled1-------");
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 1000)
    //@Async
    public void scheduled2() {
        try {
            log.info("-------scheduled2-------");
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
