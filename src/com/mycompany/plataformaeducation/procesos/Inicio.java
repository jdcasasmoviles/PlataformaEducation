/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plataformaeducation.procesos;

import com.mycompany.plataformaeducation.model.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author UsuarioPC
 */
public class Inicio {
    
        // Base de datos simulada de usuarios
    public static Map<String, String> usuarios = new HashMap<>();
    // Datos simulados de estudiantes
    public static Map<String, Estudiante> estudiantes = new HashMap<>();
    
        // Métodos de implementación
    public  static void inicializarDatos() {
        // Usuarios y contraseñas
        usuarios.put("alumno1", "admin");
        usuarios.put("alumno2", "bajo");
        usuarios.put("alumno3", "alto");
        
        // Datos de estudiantes 
        estudiantes.put("alumno1", new Estudiante("alumno1", "Nivel Intermedio", new ArrayList<>()));
        estudiantes.put("alumno2", new Estudiante("alumno2", "Nivel Básico", new ArrayList<>()));
         estudiantes.put("alumno3", new Estudiante("alumno2", "Nivel Avanzado", new ArrayList<>()));
        
        // Agregar historiales académicos de ejemplo
        estudiantes.get("alumno1").agregarResultado("Matemáticas", 75);
        estudiantes.get("alumno1").agregarResultado("Ciencias", 65);
        estudiantes.get("alumno2").agregarResultado("Matemáticas", 35);
        estudiantes.get("alumno2").agregarResultado("Ciencias", 45);
        estudiantes.get("alumno3").agregarResultado("Matemáticas", 95);
        estudiantes.get("alumno3").agregarResultado("Ciencias", 85);
    }
    
     public static boolean autenticarUsuario(String usuario, String contrasena) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasena);
    }
}
