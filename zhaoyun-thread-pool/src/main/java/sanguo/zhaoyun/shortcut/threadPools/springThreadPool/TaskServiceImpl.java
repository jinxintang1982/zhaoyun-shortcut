package sanguo.zhaoyun.shortcut.threadPools.springThreadPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskServiceImpl {

    @Async
    public void run(){
        log.info("-----start------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.info("----exception");
        }
        log.info("-----end------");
    }
}
