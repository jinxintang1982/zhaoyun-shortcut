package sanguo.zhaoyun.shortcut.threadPools.springThreadPool;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration  //告诉SpringBoot这是配置类
@EnableAsync  //开启线程池
public class SpringPoolConfig {
    @Bean("runAsyncExecutor")  //让Spring容器管理返回的线程池对象，并起名"imgAsyncExecutor"
    public Executor taskExecutor() {
        //定义线程池：
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数：
        threadPoolTaskExecutor.setCorePoolSize(6);
        //设置线程池最大线程数：
        threadPoolTaskExecutor.setMaxPoolSize(10);
        //设置线程（阻塞）队列最大线程数：
        threadPoolTaskExecutor.setQueueCapacity(100);
        //初始化线程池：
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
