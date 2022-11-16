package com.rohim.consoleapp;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class App {
    public static void main(String[] args) {
        JobDetail job1 = JobBuilder.newJob(Job1.class).withIdentity("jb1", "grp1").build();

        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trig1", "grp1")
            .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(5)).build();

        Scheduler scheduler1;
        try {
            scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
