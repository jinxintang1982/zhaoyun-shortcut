package sanguo.zhaoyun.shortcut.threadPools.javaThreadPool;


public class TaskRunnable implements Runnable {

    private final String name;

    public TaskRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }


}