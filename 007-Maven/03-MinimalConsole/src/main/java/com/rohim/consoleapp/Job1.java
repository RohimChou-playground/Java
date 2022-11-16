package com.rohim.consoleapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job1 implements Job {
    public DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(DTF.format(LocalDateTime.now()) + " 111111111 Job1 Triggered");
    }
}
