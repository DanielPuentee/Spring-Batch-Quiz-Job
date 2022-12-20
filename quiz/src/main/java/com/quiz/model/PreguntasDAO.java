package com.quiz.model;


public class PreguntasDAO {

    public String id;
    public String pregunta;
    public String todas_respuestas;
    public String respuesta;
    public String respuesta_letra;

    public PreguntasDAO() {
        super();
    }

    public PreguntasDAO(String id, String pregunta, String todas_respuestas, String respuesta, String respuesta_letra) {
        super();
        this.id = id;
        this.pregunta = pregunta;
        this.todas_respuestas = todas_respuestas;
        this.respuesta = respuesta;
        this.respuesta_letra = respuesta_letra;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTodas_respuestas() {
        return todas_respuestas;
    }

    public void setTodas_respuestas(String todas_respuestas) {
        this.todas_respuestas = todas_respuestas;
    }
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta_letra() {
        return respuesta_letra;
    }

    public void setRespuesta_letra(String respuesta_letra) {
        this.respuesta_letra = respuesta_letra;
    }
    
}
