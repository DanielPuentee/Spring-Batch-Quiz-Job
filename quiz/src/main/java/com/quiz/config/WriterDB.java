package com.quiz.config;
import com.quiz.model.PreguntasDAO;


import javax.sql.DataSource;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;

public class WriterDB extends JdbcBatchItemWriter<PreguntasDAO> {

    @Autowired
    public DataSource dataSource;

    public static JdbcBatchItemWriter<PreguntasDAO> writer(DataSource dataSource){
        JdbcBatchItemWriter<PreguntasDAO> writer = new JdbcBatchItemWriter<PreguntasDAO>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO jpa_batch (id, pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (:id, :pregunta, :todas_respuestas, :respuesta, :respuesta_letra)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PreguntasDAO>());
        return writer;

    }
}
