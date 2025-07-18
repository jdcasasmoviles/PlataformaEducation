/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plataformaeducation.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author UsuarioPC
 */
public class Estudiante {
     private String nombre;
        private String nivel;
        private Map<String, Integer> historial;
        private String estiloAprendizaje;
        private double desempenoGeneral;

        public Estudiante(String nombre, String nivel, List<String> materias) {
            this.nombre = nombre;
            this.nivel = nivel;
            this.historial = new HashMap<>();
        }
        
        public Estudiante() {
        }

        public void agregarResultado(String materia, int puntuacion) {
            historial.put(materia, puntuacion);
        }

        // Getters y setters
        public String getNombre() { return nombre; }
        public String getNivel() { return nivel; }
        public Map<String, Integer> getHistorial() { return historial; }
        public String getEstiloAprendizaje() { return estiloAprendizaje; }
        public double getDesempenoGeneral() { return desempenoGeneral; }
        public void setEstiloAprendizaje(String estilo) { this.estiloAprendizaje = estilo; }
        public void setDesempenoGeneral(double desempeno) { this.desempenoGeneral = desempeno; }
        public void setNivel(String nivel) { this.nivel = nivel; }
}
