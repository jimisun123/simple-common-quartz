package com.jimisun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jimisun
 * @create 2022-08-09 09:14
 **/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }

    //public static void main(String[] args) throws SchedulerException {
    //    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
    //
    //
    //    JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
    //            .withIdentity("jobDetail1","group1")
    //            .usingJobData("name","value")
    //            .build();
    //
    //
    //    Trigger trigger = TriggerBuilder.newTrigger()
    //            .startNow()
    //            .usingJobData("msg","我是trigger触发的")
    //            .withPriority(2)
    //            .withSchedule(
    //                    SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()
    //            )
    //            .build();
    //
    //
    //    scheduler.scheduleJob(jobDetail,trigger);
    //
    //    scheduler.start();
    //
    //    try {
    //        Thread.sleep(600000);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    }
    //
    //    scheduler.shutdown();
    //
    //}

}
