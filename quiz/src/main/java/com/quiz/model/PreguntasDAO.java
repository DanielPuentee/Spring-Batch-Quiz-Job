package com.quiz.model;


public class PreguntasDAO {

    public int id;
    public String pregunta;
    public String todas_respuestas;
    public String respuesta;
    public String respuesta_letra;

    public PreguntasDAO() {
        super();
    }

    public PreguntasDAO(int id, String pregunta, String todas_respuestas, String respuesta, String respuesta_letra) {
        super();
        this.id = id;
        this.pregunta = pregunta;
        this.todas_respuestas = todas_respuestas;
        this.respuesta = respuesta;
        this.respuesta_letra = respuesta_letra;
    }
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
