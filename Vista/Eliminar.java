package Vista;

import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

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
             // Acción del botón de Eliminar
        String CAMA = txtNumeroCama.getText();

        Connection con = null;
        PreparedStatement pstmt = null;

        String SQL = "DELETE FROM indigente WHERE Cama = ?";

        try {
            // Establecer la conexión
            Class.forName("com.mysql.jdbc.Driver"); // Asegúrate de usar el controlador correcto
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
            con.setAutoCommit(true);

            // Preparar la consulta
            pstmt = (PreparedStatement) con.prepareStatement(SQL);
            pstmt.setString(1, CAMA);

            // Ejecutar la consulta
            int exito = pstmt.executeUpdate();

            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "La persona se ha eliminado exitosamente de la base de datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el número de cama especificado");
            }

            // Limpiar el campo de texto
            txtNumeroCama.setText("");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador JDBC.");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
        } finally {
            // Cerrar los recursos
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }}
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


    public static void main(String[] args) {
        // Crear y mostrar la ventana
        new Eliminar();
    }
}