package com.quizjob.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.ClassPathResource;

import com.quizjob.model.PreguntasDAO;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class ReaderCSV {
    
    public static FlatFileItemReader<PreguntasDAO> reader() {

        FlatFileItemReader<PreguntasDAO> reader = new FlatFileItemReader<PreguntasDAO>();
        reader.setResource(new ClassPathResource("jpa_batch.csv"));
        reader.setName("CSV-Reader");
        reader.setLineMapper(lineMapper());
        return reader;
        }

    public static LineMapper<PreguntasDAO> lineMapper() {

        DefaultLineMapper<PreguntasDAO> defaultLineMapper = new DefaultLineMapper<PreguntasDAO>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(";");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id", "pregunta", "todas_respuesta", "respuesta", "respuesta_letra"});
        BeanWrapperFieldSetMapper<PreguntasDAO> fieldSetMapper = new BeanWrapperFieldSetMapper<PreguntasDAO>();
        fieldSetMapper.setTargetType(PreguntasDAO.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
}
