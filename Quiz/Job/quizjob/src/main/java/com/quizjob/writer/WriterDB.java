package com.quizjob.writer;

import java.util.List;


import org.springframework.batch.item.ItemWriter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WriterDB<T> implements ItemWriter<T> {

    private String url;
    private RestTemplate restTemplate;

    public WriterDB(String url) {
        super();
        this.url = url;
        this.restTemplate = new RestTemplate();
    }


    @Override
    public void write(List<? extends T> items) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        for (T item : items) {
            HttpEntity<T> request = new HttpEntity<>(item, headers);
            restTemplate.postForEntity(url, request, Void.class);
        }
    }

}


       