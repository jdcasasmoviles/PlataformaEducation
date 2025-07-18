package com.mycompany.plataformaeducation.model;

public class Resultado {

        private String resultado;
        private String descripcion;
        private double porcentaje;
        private int puntuacion;
        private int totalPreguntas;

        public Resultado(String resultado, String descripcion,double porcentaje,int puntuacion,int totalPreguntas) {
            this.resultado = resultado;
            this.descripcion = descripcion;
            this.porcentaje =porcentaje;
            this.puntuacion =puntuacion;
            this.totalPreguntas =totalPreguntas;
        }
        
    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the porcentaje
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the puntuacion
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * @param puntuacion the puntuacion to set
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * @return the totalPreguntas
     */
    public int getTotalPreguntas() {
        return totalPreguntas;
    }

    /**
     * @param totalPreguntas the totalPreguntas to set
     */
    public void setTotalPreguntas(int totalPreguntas) {
        this.totalPreguntas = totalPreguntas;
    }        
}
