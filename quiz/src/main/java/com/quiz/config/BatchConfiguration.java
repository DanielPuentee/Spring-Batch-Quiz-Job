package com.quiz.config;

import com.quiz.model.PreguntasDAO;

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
    
    
    // DEFINING JOB
    @Bean
    public Job importPreguntasJob(Step step) {
        return jobBuilderFactory.get("job")
                .flow(step)
                .end()
                .build();
    }

    // DEFINING STEP
    @Bean
    public Step step() {

        return stepBuilderFactory.get("step2.2")
                .<PreguntasDAO, PreguntasDAO>chunk(10)
                .reader(reader())
                .writer(writer(dataSource))
                .build();
    // END DEFINING JOB
    }



}




