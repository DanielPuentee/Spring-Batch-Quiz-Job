CREATE DATABASE IF NOT EXISTS quiz01;

USE quiz01;

CREATE TABLE jpa_prueba (

id int NOT NULL,

pregunta varchar(1600) NOT NULL,

todas_respuestas varchar(1600) NOT NULL,

respuesta varchar(1600) NOT NULL,

respuesta_letra varchar(1600) NOT NULL

);

INSERT INTO jpa_prueba (id, pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (1, '1+1', 'a) 2, b) 3, c) 5, d) 6', '##################', 'a');  
INSERT INTO jpa_prueba (id, pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (2, '1+3', 'a) 6, b) 2, c) 4, d) 5', '##################', 'c');  
INSERT INTO jpa_prueba (id, pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (683, 'Cuantos corazones tienes un pulpo', 'a) 6, b) 2, c) 3, d) 5', '##################', 'd');  

