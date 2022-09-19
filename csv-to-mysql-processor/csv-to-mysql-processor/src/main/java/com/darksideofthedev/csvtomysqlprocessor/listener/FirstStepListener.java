package com.darksideofthedev.csvtomysqlprocessor.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirstStepListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.warn("Before Step {}", stepExecution.getStepName());
        log.warn("Job Exec Context {}", stepExecution.getJobExecution().getExecutionContext());
        log.warn("Step Exec Context {}", stepExecution.getExecutionContext());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.warn("After Step {}", stepExecution.getStepName());
        log.warn("Job Exec Context {}", stepExecution.getJobExecution().getExecutionContext());
        log.warn("Step Exec Context {}", stepExecution.getExecutionContext());

        return ExitStatus.COMPLETED;
    }
}
