package com.quizjob.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import com.quizjob.model.PreguntasDAO;
import com.quizjob.reader.ReaderCSV;
import com.quizjob.writer.WriterDB;
import org.springframework.batch.item.ItemWriter;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    public static String JOB_NAME = "job";
    public static String STEP_NAME = "step2.11";

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public FlatFileItemReader<PreguntasDAO> reader() {
        return ReaderCSV.reader();
    }

    @Bean
    public ItemWriter<PreguntasDAO> writer() {
        return new WriterDB<>("http://localhost:8080/");
    }

    @Bean
    public Step step() throws Exception {
        return stepBuilderFactory.get(STEP_NAME)
                .<PreguntasDAO, PreguntasDAO>chunk(10)
                .reader(reader())
                .writer(writer())
                .build();
    }
    
    @Bean
    public Job importPreguntasJob(Step step) {
        return jobBuilderFactory.get(JOB_NAME)
                .flow(step)
                .end()
                .build();
    }
}



/* @Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    
    public static String JOB_NAME = "job";
    public static String STEP_NAME = "step2.10";

    
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;



    // IMPORT READER
    @Bean
    public FlatFileItemReader<PreguntasDAO> reader() {
        return ReaderCSV.reader();
    }

    // IMPORT WRITER
    @Bean
    public JdbcBatchItemWriter<PreguntasDAO> writer() throws Exception {
        return WriterDB.writer();
    }
    

    // DEFINING STEP
    @Bean
    public Step step() throws Exception {
        return stepBuilderFactory.get(STEP_NAME)
                .<PreguntasDAO, PreguntasDAO>chunk(10)
                .reader(reader())
                .writer(writer())
                .build();
    }

    // DEFINING JOB
    @Bean
    public Job importPreguntasJob(Step step) {
        return jobBuilderFactory.get(JOB_NAME)
                .flow(step)
                .end()
                .build();
    }



} */

    /* @Bean
    public JdbcBatchItemWriter<PreguntasDAO> writer(DataSource dataSource){
        return WriterDB.writer(dataSource);
    } */


