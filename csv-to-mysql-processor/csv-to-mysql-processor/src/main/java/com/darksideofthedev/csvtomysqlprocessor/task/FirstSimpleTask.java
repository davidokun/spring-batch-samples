package com.darksideofthedev.csvtomysqlprocessor.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class FirstSimpleTask implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        log.warn("This is the first tasklet step");
        return RepeatStatus.FINISHED;
    }
}
