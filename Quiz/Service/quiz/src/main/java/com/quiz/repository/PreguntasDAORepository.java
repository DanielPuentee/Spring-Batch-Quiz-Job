package com.quiz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.model.PreguntasDAO;

@Repository
public interface PreguntasDAORepository extends JpaRepository<PreguntasDAO, Integer> {
    
    @Query("SELECT p FROM PreguntasDAO p WHERE LOWER(p.pregunta) LIKE %:pregunta%")
    List<PreguntasDAO> findByPregunta(@Param("pregunta") String pregunta  );

}

    

