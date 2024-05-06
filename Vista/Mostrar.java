package Vista;

import javax.swing.*;
import Controlador.ArrayIndigente;
import Modelo.Indigente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Mostrar extends JFrame {
    
    public Mostrar() {
        // Configurar la ventana
        setTitle("Registro completo del refugio");
        setSize(670, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Crear un StringBuilder para almacenar los datos de todos los indigentes
        StringBuilder sb = new StringBuilder();
        
        // Recorrer la lista de indigentes y agregar sus datos al StringBuilder
        for (Indigente indigente : ArrayIndigente.indigente) {
            sb.append("\n"); // Añadir una línea en blanco
            sb.append("Nombre: ").append(indigente.getNombre()).append("\n");
            sb.append("Edad: ").append(indigente.getEdad()).append("\n");
            sb.append("Tiempo: ").append(indigente.getTiempo()).append("\n");
            sb.append("Número de cama: ").append(indigente.getNumeroCama()).append("\n");
            sb.append("Sexo: ").append(indigente.getOpcion()).append("\n");
            sb.append("Servicio médico adicional: ").append(indigente.determinarServicioMedico()).append("\n");
            sb.append("_________________________________________");
            sb.append("\n"); // Añadir una línea en blanco entre cada indigente
        }
        
        // Crear un JTextArea para mostrar los datos
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false); // Hacer el JTextArea no editable
        
        // Agregar el JTextArea a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Agregar el JScrollPane a la ventana
        add(scrollPane, BorderLayout.CENTER);
         // Crear botón "Salir"
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(225, 197, 91)); 
        // Agregar acción al botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual (Mostrar)
                Menu2 menu = new Menu2();
                menu.setBounds(0,0,670,450);
                menu.setLocationRelativeTo(null); // Centra la ventana Menu2 en la pantalla
                menu.setVisible(true); // Muestra la ventana del Menu2
            }
        });

        // Agregar el botón "Salir" al panel sur de la ventana
        add(btnSalir, BorderLayout.SOUTH);
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Crear y mostrar la interfaz
        new Mostrar();
    }

    
}