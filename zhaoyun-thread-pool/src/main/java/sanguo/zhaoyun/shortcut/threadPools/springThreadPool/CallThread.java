package sanguo.zhaoyun.shortcut.threadPools.springThreadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallThread {

    @Autowired
    TaskServiceImpl taskService;

    public void main() {
        for (int i = 0; i < 6; i++) {
            taskService.run();
        }
    }
}
