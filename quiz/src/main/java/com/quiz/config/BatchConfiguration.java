package com.quiz.config;

import com.quiz.model.PreguntasDAO;
import com.quiz.reader.ReaderCSV;
import com.quiz.repo.PreguntasDAORespository;
import com.quiz.writer.WriterDB;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    public static String JOB_NAME = "job";
    public static String STEP_NAME = "step2.7";

    @Autowired
    public PreguntasDAORespository preguntasDAORespository;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;


    // IMPORT READER
    @Bean
    public FlatFileItemReader<PreguntasDAO> reader() {
        return ReaderCSV.reader();
    }

    // IMPORT WRITER
    @Bean
    public JdbcBatchItemWriter<PreguntasDAO> writer(DataSource dataSource){
        return WriterDB.writer(dataSource);
    }
    


    // DEFINING STEP
    @Bean
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME)
                .<PreguntasDAO, PreguntasDAO>chunk(10)
                .reader(reader())
                .writer(writer(dataSource))
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



}




