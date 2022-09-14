package com.darksideofthedev.csvtomysqlprocessor.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SimpleJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job firstSimpleJob() {
        return jobBuilderFactory.get("First Simple job")
                .start(firstStep())
                .build();
    }

    private Step firstStep() {
        return stepBuilderFactory.get("First Step")
                .tasklet(firstTask())
                .build();
    }

    private Tasklet firstTask() {
        return (stepContribution, chunkContext) -> {
            System.out.println("This is the first tasklet step");
            return RepeatStatus.FINISHED;
        };
    }
}
