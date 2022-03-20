一、非@EnableAsync和@Async模式下；
1.schedule不会自动运行，需要在启动类中添加@EnableScheduling注解；

2.schedule默认为单线程运行；
如需多线程，需要在启动类中注入ThreadPoolTaskSchedule的Bean;
    @Bean
    public TaskScheduler scheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(50);
        return scheduler;
    }


二、加@EnableAsync和@Async模式下；
1.fixedRate情况下，无论是否在周期内是否完成；在下个时间节点，task都会被再次执行；
