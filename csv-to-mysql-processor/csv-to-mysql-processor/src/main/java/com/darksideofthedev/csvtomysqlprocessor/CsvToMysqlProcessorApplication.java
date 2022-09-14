package com.darksideofthedev.csvtomysqlprocessor;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class CsvToMysqlProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvToMysqlProcessorApplication.class, args);
    }

}
