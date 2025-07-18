/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plataformaeducation.model;

/**
 *
 * @author UsuarioPC
 */
public class Pregunta {
     private String texto;
        private String respuestaCorrecta;
        private String tema;

        public Pregunta(String texto, String respuestaCorrecta, String tema) {
            this.texto = texto;
            this.respuestaCorrecta = respuestaCorrecta;
            this.tema = tema;
        }

        // Getters
        public String getTexto() { return texto; }
        public String getRespuestaCorrecta() { return respuestaCorrecta; }
        public String getTema() { return tema; }
}
