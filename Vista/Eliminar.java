package Vista;

import javax.swing.*;
import Controlador.ArrayIndigente;
import Modelo.Indigente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar extends JFrame {

    public Eliminar() {
        // Configurar la ventana
        setTitle("Eliminar Indigente");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Crear y configurar los componentes
        JLabel lblNumeroCama = new JLabel("Número de Cama:");
        JTextField txtNumeroCama = new JTextField();
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(225, 197, 91)); 
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(225, 197, 91)); 
        // Configurar el panel para los campos de entrada y el botón
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(2, 2));
        panelDatos.add(lblNumeroCama);
        panelDatos.add(txtNumeroCama);

        // Configurar el panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        // Agregar los paneles a la ventana
        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción del botón "Eliminar"
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroCama = txtNumeroCama.getText();
                // Lógica para eliminar el indigente con el número de cama ingresado
                boolean eliminado = eliminarIndigente(numeroCama);
                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con ese número de cama");
                }
            }
        });

        // Acción del botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu2 llamar = new Menu2();
                llamar.setBounds(0,0,670,450);
                llamar.setVisible(true);
                llamar.setLocationRelativeTo(null);
                llamar.getContentPane().setBackground(Color.WHITE);//Color 
                dispose(); // Cierra la ventana actual
            }
        });

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para eliminar el indigente con el número de cama especificado
    private boolean eliminarIndigente(String numeroCama) {
        for (Indigente indigente : ArrayIndigente.indigente) {
            if (indigente.getNumeroCama().equals(numeroCama)) {
                ArrayIndigente.indigente.remove(indigente);
                return true; // Se encontró y eliminó al indigente
            }
        }
        return false; // No se encontró al indigente
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        new Eliminar();
    }
}