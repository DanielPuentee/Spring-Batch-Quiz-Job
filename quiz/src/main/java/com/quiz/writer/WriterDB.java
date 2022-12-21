package com.quiz.writer;
import com.quiz.model.PreguntasDAO;
import com.quiz.repo.PreguntasDAORespository;

import javax.sql.DataSource;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;

public class WriterDB extends JdbcBatchItemWriter<PreguntasDAO> {

    @Autowired
    public PreguntasDAORespository preguntasDAORespository;

    @Autowired
    public DataSource dataSource;


    public static JdbcBatchItemWriter<PreguntasDAO> writer(DataSource dataSource){
        JdbcBatchItemWriter<PreguntasDAO> writer = new JdbcBatchItemWriter<PreguntasDAO>();
        writer.setDataSource(dataSource);
        writer.setSql(PreguntasDAORespository.QUERY_INSERT);
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PreguntasDAO>());
        return writer;

    }
}
