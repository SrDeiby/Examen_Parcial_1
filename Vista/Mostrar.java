package Vista;

import javax.swing.*;
import Controlador.ArrayIndigente;
import Modelo.Indigente;

import java.awt.*;


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
            sb.append("Nombre: ").append(indigente.getNombre()).append("\n");
            sb.append("Edad: ").append(indigente.getEdad()).append("\n");
            sb.append("Tiempo: ").append(indigente.getTiempo()).append("\n");
            sb.append("Número de cama: ").append(indigente.getNumeroCama()).append("\n");
            sb.append("Sexo: ").append(indigente.getOpcion()).append("\n");
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