package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import Modelo.Indigente;
import Modelo.IndigenteFemenino;
import Modelo.IndigenteMasculino;
import java.awt.*;

public class AgregarIndigente extends JFrame implements ActionListener {

    private JButton Agregar, Salir;
    private JLabel La1, La2, La3, La4, La5, La6;
    private JTextField TextNombree, TextEdad, TextTiempo, TextCama;
    public static String NOM, EDAD, TIEMPO, CAMA, selectedOption;
    private JComboBox<String> comboBox;
    public AgregarIndigente() {
        //Creacion de los elementos de la intefaz grafica
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Agregar = new JButton("Agregar");
        Agregar.addActionListener(this);
        Agregar.setBounds(540, 350, 100, 30);
        Agregar.setBackground(new Color(225, 197, 91));
        Agregar.setForeground(Color.BLACK);
        add(Agregar);

        Salir = new JButton("Salir");
        Salir.addActionListener(this);
        Salir.setBounds(420, 350, 100, 30);
        Salir.setBackground(new Color(225, 197, 91));
        Salir.setForeground(Color.BLACK);
        add(Salir);

        La1 = new JLabel("<html>Nombre</html>");
        La1.setBounds(20, 100, 100, 40);
        Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La1.setForeground(Color.BLACK);
        La1.setFont(fuent);
        add(La1);

        La2 = new JLabel("<html>Edad</html>");
        La2.setBounds(20, 150, 100, 40);
        Font fuente = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La2.setForeground(Color.BLACK);
        La2.setFont(fuente);
        add(La2);

        La3 = new JLabel("<html>Tiempo(sin hogar)</html>");
        La3.setBounds(20, 200, 100, 40);
        Font fuentee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La3.setForeground(Color.BLACK);
        La3.setFont(fuentee);
        add(La3);

        La4 = new JLabel("<html>Cama</html>");
        La4.setBounds(20, 250, 100, 40);
        Font fuenteeee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La4.setForeground(Color.BLACK);
        La4.setFont(fuenteeee);
        add(La4);

        La6 = new JLabel("<html>Sexo</html>");
        La6.setBounds(330, 170, 100, 40);
        Font fuenteeeee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La6.setForeground(Color.BLACK);
        La6.setFont(fuenteeeee);
        add(La6);

        TextNombree = new JTextField("");
        TextNombree.setBounds(130, 105, 120, 30);
        TextNombree.setBackground(new Color(210, 240, 236));
        TextNombree.setBorder(null);
        add(TextNombree);

        TextEdad = new JTextField("");
        TextEdad.setBounds(130, 155, 120, 30);
        TextEdad.setBackground(new Color(210, 240, 236));
        TextEdad.setBorder(null);
        add(TextEdad);

        TextTiempo = new JTextField("");
        TextTiempo.setBounds(130, 205, 120, 30);
        TextTiempo.setBackground(new Color(210, 240, 236));
        TextTiempo.setBorder(null);
        add(TextTiempo);

        TextCama = new JTextField("");
        TextCama.setBounds(130, 255, 120, 30);
        TextCama.setBackground(new Color(210, 240, 236));
        TextCama.setBorder(null);
        add(TextCama);

        La5 = new JLabel("<html>Registro de personas a tu refugio</html>");
        La5.setBounds(130, 20, 400, 50);
        Font fue = new Font("Courier New", Font.BOLD, 20); // Tipo de fuente, estilo y tamaño
        La5.setForeground(Color.BLACK);
        La5.setFont(fue);
        add(La5);

        String[] items = { "Masculino", "Femenino" }; //Creacion del ComboBox
        comboBox = new JComboBox<>(items);
        comboBox.setBounds(385, 175, 150, 30);
        add(comboBox);

    }// Fin del constructor

    public static void main(String[] Ars) {// Creamos el JFrame
        AgregarIndigente llamar = new AgregarIndigente();
        llamar.setBounds(0, 0, 670, 450);
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(new Color(178, 217, 227));// Color

    }// Fin del main

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == Agregar) {
            // Accion del boton de Agregar
            NOM = TextNombree.getText();
            EDAD = TextEdad.getText();
            TIEMPO = TextTiempo.getText();
            CAMA = TextCama.getText();
            selectedOption = comboBox.getSelectedItem().toString();
           
            boolean camaDuplicada = false;

    if (camaDuplicada) {//Codigo que nos permite que no se repitan las camas
        JOptionPane.showMessageDialog(null, "El número de cama ya está en uso. Intente otro número.");
    } else {

        
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String SQL = "INSERT INTO indigente (Nombre, Edad, Tiempo, Cama, Sexo) VALUES (?, ?, ?, ?, ?)";
            
            try {
                // Establecer la conexión
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
                con.setAutoCommit(true);
                
                // Preparar la consulta
                pstmt = con.prepareStatement(SQL);
                pstmt.setString(1, NOM);
                pstmt.setString(2, EDAD);
                pstmt.setString(3, TIEMPO);
                pstmt.setString(4, CAMA);
                pstmt.setString(5, selectedOption);
                
                // Ejecutar la consulta
                int exito = pstmt.executeUpdate();
                
                if (exito > 0) {
                    JOptionPane.showMessageDialog(null, "La persona se ha agregado exitosamente a la base de datos");
                }
                
                JOptionPane.showMessageDialog(null, "La persona se ha agregado exitosamente");
                
                // Limpiar los campos de texto
                TextNombree.setText("");
                TextEdad.setText("");
                TextTiempo.setText("");
                TextCama.setText("");
            } catch (Exception ew) {
                ew.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            } finally {
                // Cerrar los recursos
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (con != null) con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
    }
        } // Fin if

        if (e.getSource() == Salir) {//Accion del boton de salir
            Menu2 llamar = new Menu2();
            llamar.setBounds(0, 0, 670, 450);
            llamar.setVisible(true);
            dispose();
            llamar.setLocationRelativeTo(null);
            llamar.getContentPane().setBackground(Color.WHITE);// Color

        }
    }// Fin de las acciones

}// Fin de la clase