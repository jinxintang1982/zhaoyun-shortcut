import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sanguo.zhaoyun.shortcut.MegviiApplication;
import sanguo.zhaoyun.shortcut.threadPools.springThreadPool.CallThread;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MegviiApplication.class)
@Slf4j
public class ThreadPoolTest {
    @Autowired
    CallThread callThread;

    @Test
    public void testSpringThreadPool() throws InterruptedException {
        callThread.main();
        Thread.sleep(10000L);
    }
}
