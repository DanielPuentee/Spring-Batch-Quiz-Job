package com.quiz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jpa_prueba")
public class PreguntasDAO implements Serializable {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "pregunta")
    public String pregunta;
 
    @Column(name = "todas_respuestas")
    public String todas_respuestas;
 
    @Column(name = "respuesta")
    public String respuesta;
 
    @Column(name = "respuesta_letra")
    public String respuesta_letra;


    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTodasLasRespuestas() {
        return todas_respuestas;
    }

    public void setTodasLasRespuestas(String todas_respuestas) {
        this.todas_respuestas = todas_respuestas;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuestaLetras() {
        return respuesta_letra;
    }

    public void setRespuestaLetras(String respuesta_letra) {
        this.respuesta_letra = respuesta_letra;
    }
    
}
