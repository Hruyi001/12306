package com.hry.train.batch.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class Test2Job implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TestJob2222222222222222 Test开始");
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("TestJob22222222222222222 Test结束");
    }
}
