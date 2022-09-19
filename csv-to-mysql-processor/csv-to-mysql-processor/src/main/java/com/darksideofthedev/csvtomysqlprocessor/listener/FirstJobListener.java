package com.darksideofthedev.csvtomysqlprocessor.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirstJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.warn("Before Job {}", jobExecution.getJobInstance().getJobName());
        log.warn("Job Params {}", jobExecution.getJobParameters());
        log.warn("Job Execution Context {}", jobExecution.getExecutionContext());

        jobExecution.getExecutionContext().put("key_1", "value_1");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.warn("After Job {}", jobExecution.getJobInstance().getJobName());
        log.warn("Job Params {}", jobExecution.getJobParameters());
        log.warn("Job Execution Context {}", jobExecution.getExecutionContext());
    }
}
