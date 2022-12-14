package com.quiz.config;

import com.quiz.model.PreguntasDAO;
//import com.quiz.config.Reader;
//import com.quiz.config.Writer;

import javax.sql.DataSource;

//import org.junit.runners.Parameterized.BeforeParam;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.context.annotation.*;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;
    //@Autowired
    //public Writer writer;

    // IMPORTING OTHER CLASSES
    @Bean
    public FlatFileItemReader<PreguntasDAO> reader() {
        //public Reader(Resource resource) {
            return new FlatFileItemReaderBuilder<PreguntasDAO>()
                    .name("preguntasItemReader")
                    .resource(new ClassPathResource("jpa_batch.csv"))
                    //.resource(new FileSystemResource("/home/dani/bbva/1_restapi/SpringBatch/quiz/src/main/resources/jpa_batch.csv"))                 
                    .delimited()
                    .delimiter(";")
                    .names(new String[]{"id", "pregunta", "todas_respuesta", "respuesta", "respuesta_letra"})
                    .fieldSetMapper(new BeanWrapperFieldSetMapper<PreguntasDAO>() {{
                        setTargetType(PreguntasDAO.class);
                    }})
                    .build();
        }
    @Bean
    public JdbcBatchItemWriter<PreguntasDAO> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PreguntasDAO>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO jpa_batch (id, pregunta, todas_respuesta, respuesta, respuesta_letra) VALUES (:id, :pregunta, :todas_respuesta, :respuesta, :respuesta_letra)")
                .dataSource(dataSource)
                .build();
    }
    // END IMPORTING OTHER CLASSES
    
    // DEFINING JOB
    @Bean
    public Job importPreguntasJob(Step step1) {
        return jobBuilderFactory.get("importPreguntasJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<PreguntasDAO> writer) {

        return stepBuilderFactory.get("step1")
                .<PreguntasDAO, PreguntasDAO> chunk(10)
                .reader(reader())
                .writer(writer)
                .build();
    }
    // END DEFINING JOB



}




