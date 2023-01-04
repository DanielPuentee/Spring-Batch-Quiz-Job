package com.quizjob.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizjob.model.PreguntasDAO;

@Repository
public interface PreguntasDAORespository extends JpaRepository<PreguntasDAO, String> {
    
    public static String QUERY_INSERT = "INSERT INTO jpa_batch (id, pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (:id, :pregunta, :todas_respuestas, :respuesta, :respuesta_letra)";

}