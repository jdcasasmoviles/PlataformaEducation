/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plataformaeducation.view;
import javax.swing.*;
import java.awt.*;
import com.mycompany.plataformaeducation.model.Pregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoModal extends JDialog {
    private JTextField txtRespuesta;
    private Runnable clicListener;
    private JButton btnResponder;

    public DialogoModal(Pregunta pregunta, int indice) {
        // Configuración básica del diálogo
        setTitle("Pregunta " + (indice + 1));
        setLayout(new BorderLayout(10, 10));
        setSize(500, 300);
        setLocationRelativeTo(null); // Centrar en pantalla
        setModal(true); // IMPORTANTE: Diálogo modal
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel principal con padding
        JPanel contentPanel = new JPanel(new BorderLayout(10, 20));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel para la pregunta
        JPanel preguntaPanel = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Pregunta " + (indice + 1) + ":");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        preguntaPanel.add(lblTitulo, BorderLayout.NORTH);
        
        JTextArea txtPregunta = new JTextArea(pregunta.getTexto());
        txtPregunta.setWrapStyleWord(true);
        txtPregunta.setLineWrap(true);
        txtPregunta.setEditable(false);
        txtPregunta.setBackground(getBackground());
        txtPregunta.setFont(new Font("Arial", Font.PLAIN, 14));
        preguntaPanel.add(new JScrollPane(txtPregunta), BorderLayout.CENTER);
        
        contentPanel.add(preguntaPanel, BorderLayout.NORTH);
        
        // Panel para la respuesta
        JPanel respuestaPanel = new JPanel(new BorderLayout(5, 5));
        respuestaPanel.add(new JLabel("Tu respuesta:"), BorderLayout.NORTH);
        
        txtRespuesta = new JTextField();
        txtRespuesta.setFont(new Font("Arial", Font.PLAIN, 14));
        respuestaPanel.add(txtRespuesta, BorderLayout.CENTER);
        
        contentPanel.add(respuestaPanel, BorderLayout.CENTER);
        
        // Panel para el botón
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnResponder = new JButton("Responder");
        btnResponder.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(btnResponder);
        
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(contentPanel);
        
        // Configurar eventos
        initEvents();
    }

    private void initEvents() {
        btnResponder.addActionListener(e -> {
            if (clicListener != null) {
                clicListener.run();
            }
        });
        
        // Permitir responder con Enter
        txtRespuesta.addActionListener(e -> {
            if (clicListener != null) {
                clicListener.run();
            }
        });
    }

    public void setClicListener(Runnable listener) {
        this.clicListener = listener;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }
}