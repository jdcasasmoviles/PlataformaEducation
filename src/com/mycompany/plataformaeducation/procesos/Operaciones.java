/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plataformaeducation.procesos;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.plataformaeducation.model.Pregunta;
import com.mycompany.plataformaeducation.model.Estudiante;
import com.mycompany.plataformaeducation.model.Resultado;
import com.mycompany.plataformaeducation.view.DialogoModal;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Operaciones {

    public static void analizarDesempeno(Estudiante estudiante,JTextArea txtResultados) {
        String resultado="\n=== ANALIZANDO DESEMPEÑO ===";
        resultado=resultado+"\nHistorial académico de " + estudiante.getNombre() + ":";
        System.out.println("\n=== ANALIZANDO DESEMPEÑO ===");
        System.out.println("Historial académico de " + estudiante.getNombre() + ":");
        
        for (Map.Entry<String, Integer> entry : estudiante.getHistorial().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + "%");
             resultado=resultado+"\n- " + entry.getKey() + ": " + entry.getValue() + "%";
        }
        
        double promedio = estudiante.getHistorial().values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        
        System.out.printf("Promedio general: %.1f%%\n", promedio);
        resultado=resultado+"\nPromedio general: "+promedio;
        estudiante.setDesempenoGeneral(promedio);
        txtResultados.setText(resultado);  
         txtResultados.setEditable(false);
      
    }

    public static void detectarEstiloAprendizaje(Estudiante estudiante,JTextField txtEstiloAprender) {
        System.out.println("\n=== DETECTANDO ESTILO DE APRENDIZAJE ===");
        // Simulamos una detección basada en el desempeño
        String estilo;
        if (estudiante.getDesempenoGeneral() > 80) {
            estilo = "Visual";
        } else if (estudiante.getDesempenoGeneral() > 60) {
            estilo = "Auditivo";
        } else {
            estilo = "Kinestésico";
        }
        
        System.out.println("Estilo de aprendizaje detectado: " + estilo);
        estudiante.setEstiloAprendizaje(estilo);
        txtEstiloAprender.setText(estilo);
    }

    public static List<Pregunta> seleccionarContenido(Estudiante estudiante) {
        System.out.println("\n=== SELECCIONANDO CONTENIDO ADECUADO ===");
        System.out.println("Para " + estudiante.getNombre() + " (Nivel: " + estudiante.getNivel() + 
                          ", Estilo: " + estudiante.getEstiloAprendizaje() + ")");
        
        // Simulamos la selección de preguntas basadas en el nivel y estilo
        List<Pregunta> actividad = new ArrayList<>();
        
        if (estudiante.getNivel().trim().equals("Nivel Básico")) {
            actividad.add(new Pregunta("¿Cuánto es 2 + 2? De la respuesta en valor numerico", "4", "Aritmética básica"));
            actividad.add(new Pregunta("¿Qué forma tiene una pelota de fútbol?", "Esfera", "Geometría básica"));
        } 
        else if (estudiante.getNivel().trim().equals("Nivel Intermedio")) {
            actividad.add(new Pregunta("Resuelve para x: 2x + 5 = 15 De la respuesta en valor numerico", "5", "Álgebra básica"));
            actividad.add(new Pregunta("¿Cuál es la capital de Peru?", "Lima", "Geografía"));
            actividad.add(new Pregunta("¿Qué gas necesitan las plantas para la fotosíntesis?", "CO2", "Ciencias"));
       } else {
            actividad.add(new Pregunta("Resuelve para x: 3x - 5 = 6x - 23 . De la respuesta en valor numerico", "6", "Álgebra básica"));
            actividad.add(new Pregunta("¿Cuál es la capital de Ecuador?", "Quito", "Geografía"));
            actividad.add(new Pregunta("¿Qué tipo de animal es una rana?", "Anfibio", "Ciencias"));
            actividad.add(new Pregunta("Resuelve para x: 2x + 5 = 15", "5", "Álgebra básica"));
            actividad.add(new Pregunta("¿Cuál es el continente más grande del mundo?", "Asia", "Geografía"));
            actividad.add(new Pregunta("¿Cuál es el cuarto planeta?", "Marte", "Ciencias"));
   
        }
        
        System.out.println("Actividad personalizada creada con " + actividad.size() + " preguntas.");
        return actividad;
    }

    public static AtomicInteger presentarActividad(List<Pregunta> actividad) {
        System.out.println("\n=== ACTIVIDAD DE APRENDIZAJE ===");
      // En tu clase principal:
      AtomicInteger puntuacion = new AtomicInteger(0);  // Usamos AtomicInteger para manejo thread-safe

       // Donde inicias el cuestionario:
       iniciarCuestionario(actividad, puntuacion, 0); 
       return puntuacion;
    }
        
        
    static void iniciarCuestionario(List<Pregunta> actividad, AtomicInteger puntuacion, int i) {
    if (i >= actividad.size()) {
        JOptionPane.showMessageDialog(null, "Cuestionario completado! Puntuación: " + puntuacion.get());
        return;
    }

    Pregunta pregunta = actividad.get(i);
    System.out.println("\nPregunta " + (i + 1) + ": " + pregunta.getTexto());
    
    DialogoModal preguntaModal = new DialogoModal(pregunta, i);
    
    // Configura el listener para el botón
    preguntaModal.setClicListener(() -> {
        // Procesar respuesta después del clic
         System.out.println("Procesar respuesta después del clic");
        String respuesta = preguntaModal.getTxtRespuesta().getText().trim();
        
        if (respuesta.equalsIgnoreCase(pregunta.getRespuestaCorrecta())) {
            System.out.println("¡Correcto!");
            JOptionPane.showMessageDialog(null, "¡Correcto!", "BUENA", JOptionPane.INFORMATION_MESSAGE);
            puntuacion.incrementAndGet();  // Incrementa la puntuación atómicamente
        } else {
            System.out.println("Incorrecto. La respuesta correcta es: " + pregunta.getRespuestaCorrecta());
            JOptionPane.showMessageDialog(null, 
                "Incorrecto. La respuesta correcta es: " + pregunta.getRespuestaCorrecta(), 
                "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        
        preguntaModal.dispose();  // Cierra el modal actual
        iniciarCuestionario(actividad, puntuacion, i + 1);  // Llama recursivamente para la siguiente pregunta
    });
    
    preguntaModal.setVisible(true);
}

    public static Resultado evaluarResultados(Estudiante estudiante, int puntuacion, int totalPreguntas) {
        System.out.println("\n=== EVALUACIÓN DE RESULTADOS ===");
        double porcentaje = (double) puntuacion / totalPreguntas * 100;
        System.out.printf("Puntuación obtenida: %.1f%% (%d/%d)\n", porcentaje, puntuacion, totalPreguntas);
        
        String descripcion="";
        String resultado="";
        if (porcentaje >= 70) {
            System.out.println("¡Felicidades! Puedes avanzar al siguiente nivel.");
            descripcion="¡Felicidades!";
            // Simulamos el avance de nivel
            String nuevoNivel = "Nivel " + 
                (estudiante.getNivel().contains("Básico") ? "Intermedio" : 
                 estudiante.getNivel().contains("Intermedio") ? "Avanzado" : "Experto");
            estudiante.setNivel(nuevoNivel);
            System.out.println("Nuevo nivel: " + nuevoNivel);
            resultado="Nuevo " + nuevoNivel;
        } else {
            System.out.println("Puntuación insuficiente. Iniciando refuerzo de contenido...");
            descripcion="Puntuación insuficiente.";
            // Simulamos contenido de refuerzo
            System.out.println("Mostrando material adicional sobre los temas con dificultad...");
            resultado="Necesita contenido de refuerzo.";
            estudiante.setNivel("Básico");
            // En una implementación real, aquí se seleccionaría contenido específico
        }
        estudiante.setDesempenoGeneral(porcentaje);
        return new Resultado(resultado,  descripcion, porcentaje, puntuacion, totalPreguntas);
    }

    public static void guardarProgreso(Estudiante estudiante) {
        System.out.println("\n=== GUARDANDO PROGRESO ===");
        // En una implementación real, esto guardaría en una base de datos
        System.out.println("Progreso de " + estudiante.getNombre() + " guardado exitosamente.");
        JOptionPane.showMessageDialog(null,"Progreso de "+estudiante.getNombre() + " Guardado exitosamente.","=== GUARDANDO PROGRESO ===", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void generarReporte(Estudiante estudiante) {
        System.out.println("\n=== REPORTE PARA EL DOCENTE ===");
        System.out.println("Nombre del estudiante: " + estudiante.getNombre());
        System.out.println("Nivel actual: " + estudiante.getNivel());
        System.out.println("Estilo de aprendizaje: " + estudiante.getEstiloAprendizaje());
        System.out.printf("Desempeño general: %.1f%%\n", estudiante.getDesempenoGeneral());
        System.out.println("Recomendaciones: Continuar con el plan de estudios actual");
    }

}