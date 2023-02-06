package com.quiz.service;

import java.util.List;

import com.quiz.model.PreguntasDAO;


public interface IPreguntasService {

    PreguntasDAO create(PreguntasDAO preguntasDAO);
    PreguntasDAO update(PreguntasDAO preguntasDAO);
    List<PreguntasDAO> findAll();
    void delete(Integer id);
    List<PreguntasDAO> findByPregunta(String pregunta);
}