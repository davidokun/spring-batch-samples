package com.darksideofthedev.csvtomysqlprocessor.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecondSimpleTask implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        log.warn("This is the second tasklet step");
        log.warn("Execution Context {}", chunkContext.getStepContext().getJobExecutionContext());
        return RepeatStatus.FINISHED;
    }
}
