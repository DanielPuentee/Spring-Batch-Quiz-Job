package com.quizjob.writer;
import com.quizjob.model.PreguntasDAO;
import com.quizjob.repo.PreguntasDAORespository;


import com.google.gson.Gson;

// import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

/* import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.io.*;
import java.net.*;
import javax.sql.DataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap; */

public class WriterDB extends JdbcBatchItemWriter<PreguntasDAO> {

    @Autowired
    public PreguntasDAORespository preguntasDAORespository;

    

    private static void postMethod() throws Exception {

        PreguntasDAO preguntasDAO = new PreguntasDAO();
        
        // URL url = new URL("http://localhost:8080/");
        String url = "http://localhost:8080/";

        Gson gson = new Gson();
        String json = gson.toJson(preguntasDAO);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        client.execute(httpPost);
    }

    public static JdbcBatchItemWriter<PreguntasDAO> writer() throws Exception {
        JdbcBatchItemWriter<PreguntasDAO> writer = new JdbcBatchItemWriter<PreguntasDAO>();
        postMethod();
        return writer;

    }
}


        /* AAAA String id = preguntasDAO.getId();
        String pregunta = preguntasDAO.getPregunta();
        String todas_respuestas = preguntasDAO.getTodas_respuestas();
        String respuesta = preguntasDAO.getRespuesta();
        String respuesta_letra = preguntasDAO.getRespuesta_letra();

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        
        CloseableHttpResponse response = client.execute(httpPut);
        String jsonString = objectMapper.writeValueAsString(jsonMap);

        String jsonInputString = "{\"key\":\"value\"}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode); */

        /* BBBBB BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    } */


/*  
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
*/