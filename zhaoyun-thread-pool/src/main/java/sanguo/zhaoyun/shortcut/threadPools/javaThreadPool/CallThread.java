package sanguo.zhaoyun.shortcut.threadPools.javaThreadPool;

import java.util.concurrent.*;

public class CallThread {


    public static void main(String[] args) {
        //固定线程数
        //ExecutorService es = Executors.newFixedThreadPool(4);

        ExecutorService es = newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            es.submit(new TaskRunnable("" + i));
        }
        es.shutdown();
    }


    private static ExecutorService newCachedThreadPool() {
        //工作线程小于corePoolSize时，创建线程，执行task;
        //工作线程等于corePoolSize时，放入阻塞队列
        //阻塞队列满后，继续新建线程，执行task
        //创建的工作线程，大于maximumPoolSize时，还有task需要执行，则抛异常(RejectExecutionException)
        //当工作线程，空闲时间小于keepAliveTime时，如果当前创建线程数大于maximumPoolSize，则销毁线程；

        return new ThreadPoolExecutor(10, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
    }


}

