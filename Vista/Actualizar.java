package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Actualizar extends JFrame implements ActionListener{

    private JButton Salir, Buscar, Actualizar;
    private JComboBox<String> comboBox;
    private JLabel La1, La2, La3;
    public JPanel Panel;
    private JTextField TextActualizar, TextCama;
    public int Seleccion;
    private JTextArea resultadoTextArea;
    public static void main(String[] Ars) {// Creamos el JFrame
        Actualizar llamar = new Actualizar();
        llamar.setBounds(0, 0, 670, 450);
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(new Color(178, 217, 227));// Color

    }// Fin del main

public Actualizar(){

    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

        Salir = new JButton("Salir");
        Salir.addActionListener(this);
        Salir.setBounds(420, 350, 100, 30);
        Salir.setBackground(new Color(225, 197, 91));
        Salir.setForeground(Color.BLACK);
        add(Salir);

        Actualizar = new JButton("Actualizar");
        Actualizar.addActionListener(this);
        Actualizar.setBounds(170, 350, 100, 30);
        Actualizar.setBackground(new Color(225, 197, 91));
        Actualizar.setForeground(Color.BLACK);
        add(Actualizar);

        resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setBounds(110, 250, 430, 60);
        add(resultadoTextArea);

        Buscar = new JButton("Buscar");
        Buscar.addActionListener(this);
        Buscar.setBounds(330, 30, 100, 30);
        Buscar.setBackground(new Color(225, 197, 91));
        Buscar.setForeground(Color.BLACK);
        add(Buscar);

        String[] items = { "Nombre", "Edad", "Tiempo", "Cama"}; //Creacion del ComboBox
        comboBox = new JComboBox<>(items);
        comboBox.setBounds(160, 90, 120, 30);
        add(comboBox);

        La1 = new JLabel("<html>Dato a modificar</html>");
        La1.setBounds(50, 90, 100, 40);
        Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La1.setForeground(Color.BLACK);
        La1.setFont(fuent);
        add(La1);

        TextActualizar = new JTextField("");
        TextActualizar.setBounds(160, 150, 120, 30);
        TextActualizar.setBackground(new Color(210, 240, 236));
        TextActualizar.setBorder(null);
        add(TextActualizar);

        TextCama = new JTextField("");
        TextCama.setBounds(160, 30, 120, 30);
        TextCama.setBackground(new Color(210, 240, 236));
        TextCama.setBorder(null);
        add(TextCama);

        La2 = new JLabel("<html>Nuevo dato</html>");
        La2.setBounds(50, 150, 100, 40);
        La2.setForeground(Color.BLACK);
        La2.setFont(fuent);
        add(La2);

        La3 = new JLabel("<html>Cama a actualizar</html>");
        La3.setBounds(50, 30, 100, 40);
        La3.setForeground(Color.BLACK);
        La3.setFont(fuent);
        add(La3);
        
}//Fin del constructor

    @Override
    public void actionPerformed(ActionEvent e) {
      
        if (e.getSource() == Salir) {//Accion del boton de salir
            Menu2 llamar = new Menu2();
            llamar.setBounds(0, 0, 670, 450);
            llamar.setVisible(true);
            dispose();
            llamar.setLocationRelativeTo(null);
            llamar.getContentPane().setBackground(Color.WHITE);// Color

        }

        if(e.getSource() == Buscar){
            String cama = TextCama.getText();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String SQL = "SELECT Nombre, Edad, Tiempo, Cama, Sexo FROM indigente WHERE Cama = ?";

        try {
            // Establecer la conexión
            Class.forName("com.mysql.jdbc.Driver"); // Asegúrate de usar el controlador correcto
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");

            pstmt = (PreparedStatement) con.prepareStatement(SQL);
            pstmt.setString(1, cama);
            rs = pstmt.executeQuery();

            resultadoTextArea.setText("");

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                String tiempo = rs.getString("Tiempo");
                String sexo = rs.getString("Sexo");

                resultadoTextArea.append("   Nombre: " + nombre + " | ");
                resultadoTextArea.append("Edad: " + edad + " | ");
                resultadoTextArea.append("Tiempo en calle: " + tiempo + " | ");
                resultadoTextArea.append("Cama: " + cama + " | ");
                resultadoTextArea.append("Sexo: " + sexo + " ");

            }

            if (resultadoTextArea.getText().isEmpty()) {
                resultadoTextArea.setText("      No se encontró ninguna persona con el número de cama especificado.");
            }

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador JDBC.");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        }//Fin buscar

        if(e.getSource() == Actualizar){
            Seleccion = comboBox.getSelectedIndex();
            if(Seleccion == 0){
                String DatoNuevo = TextActualizar.getText();
                String cama = TextCama.getText();       
                Connection con = null;
                PreparedStatement pstmt = null;
                
                try {
                    // Establecer la conexión
                    Class.forName("com.mysql.jdbc.Driver"); 
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
                    

                    String SQL = "UPDATE indigente SET Nombre = ? WHERE Cama = ?";
                    pstmt = (PreparedStatement) con.prepareStatement(SQL);
                    pstmt.setString(1, DatoNuevo);
                    pstmt.setString(2, cama);

                    int exito = pstmt.executeUpdate();
                    
                    if (exito > 0) {
                        JOptionPane.showMessageDialog(null, "El nombre se ha actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el número de cama especificado.");
                    }
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador");
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
                } finally {

                    try {
                        if (pstmt != null) pstmt.close();
                        if (con != null) con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if(Seleccion ==1){
                String DatoNuevo = TextActualizar.getText();
                String cama = TextCama.getText();       
                Connection con = null;
                PreparedStatement pstmt = null;
                
                try {
                    // Establecer la conexión
                    Class.forName("com.mysql.jdbc.Driver"); 
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
                    

                    String SQL = "UPDATE indigente SET Edad = ? WHERE Cama = ?";
                    pstmt = (PreparedStatement) con.prepareStatement(SQL);
                    pstmt.setString(1, DatoNuevo);
                    pstmt.setString(2, cama);

                    int exito = pstmt.executeUpdate();
                    
                    if (exito > 0) {
                        JOptionPane.showMessageDialog(null, "La edad se ha actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el número de cama especificado.");
                    }
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador");
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
                } finally {

                    try {
                        if (pstmt != null) pstmt.close();
                        if (con != null) con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if(Seleccion ==2){
                String DatoNuevo = TextActualizar.getText();
                String cama = TextCama.getText();       
                Connection con = null;
                PreparedStatement pstmt = null;
                
                try {
                    // Establecer la conexión
                    Class.forName("com.mysql.jdbc.Driver"); 
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
                    

                    String SQL = "UPDATE indigente SET Tiempo = ? WHERE Cama = ?";
                    pstmt = (PreparedStatement) con.prepareStatement(SQL);
                    pstmt.setString(1, DatoNuevo);
                    pstmt.setString(2, cama);
                    int exito = pstmt.executeUpdate();
                    
                    if (exito > 0) {
                        JOptionPane.showMessageDialog(null, "El tiempo se ha actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el número de cama especificado.");
                    }
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador");
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
                } finally {

                    try {
                        if (pstmt != null) pstmt.close();
                        if (con != null) con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if(Seleccion ==3){
                String DatoNuevo = TextActualizar.getText();
                String cama = TextCama.getText();       
                Connection con = null;
                PreparedStatement pstmt = null;
                
                try {
                    // Establecer la conexión
                    Class.forName("com.mysql.jdbc.Driver"); 
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
                    

                    String SQL = "UPDATE indigente SET Cama = ? WHERE Cama = ?";
                    pstmt = (PreparedStatement) con.prepareStatement(SQL);
                    pstmt.setString(1, DatoNuevo);
                    pstmt.setString(2, cama);

                    int exito = pstmt.executeUpdate();
                    
                    if (exito > 0) {
                        JOptionPane.showMessageDialog(null, "La Cama se ha actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el número de cama especificado.");
                    }
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador");
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
                } finally {

                    try {
                        if (pstmt != null) pstmt.close();
                        if (con != null) con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

    }//Fin acciones

}//Fin de la clase
