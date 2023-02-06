package com.quiz.controller;
import com.quiz.model.PreguntasDAO;
import com.quiz.service.PreguntasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@RestController
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = com.quiz.service.PreguntasService.class)
@RequestMapping
public class PreguntasController {

    
    @GetMapping("/patata")
    String home() {
        return "Hello World PATATA!";
    }
    
    @Autowired
    private PreguntasService preguntasService;


    @GetMapping("/preguntas")
    public List<PreguntasDAO> findAll() {
        return preguntasService.findAll();
    }

    @PostMapping
    public PreguntasDAO create(@RequestBody PreguntasDAO preguntasDAO) {
        return preguntasService.create(preguntasDAO);
    }

    @PutMapping
    public PreguntasDAO update(@RequestBody PreguntasDAO preguntasDAO) {
        return preguntasService.update(preguntasDAO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        preguntasService.delete(id);
    }

    @GetMapping("preguntas/{pregunta}")
    public List<PreguntasDAO> findByPregunta(@PathVariable String pregunta) {
        return preguntasService.findByPregunta(pregunta);
    }
}




