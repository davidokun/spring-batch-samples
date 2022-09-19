package com.darksideofthedev.csvtomysqlprocessor.config;

import com.darksideofthedev.csvtomysqlprocessor.listener.FirstJobListener;
import com.darksideofthedev.csvtomysqlprocessor.listener.FirstStepListener;
import com.darksideofthedev.csvtomysqlprocessor.task.FirstSimpleTask;
import com.darksideofthedev.csvtomysqlprocessor.task.SecondSimpleTask;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SimpleJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final FirstSimpleTask firstSimpleTask;
    private final SecondSimpleTask secondSimpleTask;
    private final FirstJobListener firstJobListener;
    private final FirstStepListener firstStepListener;

    @Bean
    public Job firstSimpleJob() {
        return jobBuilderFactory.get("First Simple job")
                .incrementer(new RunIdIncrementer())
                .listener(firstJobListener)
                .start(firstStep())
                .next(secondStep())
                .build();
    }

    private Step firstStep() {
        return stepBuilderFactory.get("First Step")
                .listener(firstStepListener)
                .tasklet(firstSimpleTask)
                .build();
    }

    private Step secondStep() {
        return stepBuilderFactory.get("Second Step")
                .tasklet(secondSimpleTask)
                .build();
    }
}
