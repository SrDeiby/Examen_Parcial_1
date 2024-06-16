package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import java.awt.*;

public class Menu2 extends JFrame implements ActionListener {
   private JPanel Panel1;
   private JButton Agregar, Buscar, Eliminar, Mostrar, Salir, Autores;
   private JLabel Label1, Label2, Label3, Label4, Label5, Label6, Label7, Label8;
   private ImageIcon imagen;
   private Icon icono;

    public Menu2(){     
    //Creacion de los elementos de la intefaz grafica
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

     Buscar = new JButton("Actualizar");
     Buscar.setBounds(210, 250, 430,35);
     Buscar.setHorizontalAlignment(SwingConstants.LEFT);  
     Buscar.setBackground(new Color(39, 244, 225));
     Buscar.setBorderPainted(false);
     Buscar.addActionListener(this); 
     add(Buscar);

     Mostrar = new JButton("Mostrar");
     Mostrar.setBounds(210, 290, 430,35);
     Mostrar.setHorizontalAlignment(SwingConstants.LEFT);
     Mostrar.setBackground(new Color(39, 244, 225));
     Mostrar.setBorderPainted(false);  
     Mostrar.addActionListener(this); 
     add(Mostrar);

     Agregar = new JButton("Agregar");
     Agregar.setBounds(210, 210, 430,35);  
     Agregar.setHorizontalAlignment(SwingConstants.LEFT);
     Agregar.setBackground(new Color(39, 244, 225));
     Agregar.setBorderPainted(false);
     Agregar.addActionListener(this); 
     add(Agregar);

     Eliminar = new JButton("Eliminar");
     Eliminar.setBounds(210, 330, 430,35);
     Eliminar.setHorizontalAlignment(SwingConstants.LEFT);  
     Eliminar.setBackground(new Color(39, 244, 225));
     Eliminar.setBorderPainted(false);
     Eliminar.addActionListener(this); 
     add(Eliminar);

     Salir = new JButton("Salir");
     Salir.setBounds(540, 370, 100,30);
     Salir.setHorizontalAlignment(SwingConstants.LEFT);  
     Salir.setBackground(new Color(39, 244, 225));
     Salir.setBorderPainted(false);
     Salir.addActionListener(this); 
     add(Salir);

     Autores = new JButton("Derechos");
     Autores.setBounds(430, 370, 100,30);
     Autores.setHorizontalAlignment(SwingConstants.LEFT);  
     Autores.setBackground(new Color(39, 244, 225));
     Autores.setBorderPainted(false);
     Autores.addActionListener(this); 
     add(Autores);

     Label1 = new JLabel("<html>Gracias por <center> elegir a <br>Programa <br>de <br>Centros <br>de <br>Refugios <br>Rodriguez</html>");
     Label1.setBounds(0, 40, 200, 300);
     Font fuente = new Font("Courier New", Font.BOLD, 26); // Tipo de fuente, estilo y tamaño
     Label1.setForeground(Color.WHITE);
     Label1.setHorizontalAlignment(SwingConstants.CENTER);
     Label1.setFont(fuente);
     add(Label1);

     Label2 = new JLabel("<html>Programa de centros de refugios Rodriguez</html>");
     Label2.setBounds(165, -110, 450, 400);
     Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     Label2.setForeground(Color.BLACK);
     Label2.setHorizontalAlignment(SwingConstants.CENTER);
     Label2.setFont(fuent);
     add(Label2);

     Label3 = new JLabel("<html><div style='text-align: justify;'> "
     + "A continuacion se te presentan las acciones de agregar, buscar, mostrar y eliminar a las personas, el programa te beneficiará en el manejo muy organizado del refugio para las personas sin hogar. </div></html>");
     Label3.setBounds(205, -60, 450, 400);
     Font fuen = new Font("Courier New", Font.BOLD, 12); // Tipo de fuente, estilo y tamaño
     Label3.setForeground(new Color(70, 111, 106 ));
     Label3.setHorizontalAlignment(SwingConstants.CENTER);
     Label3.setFont(fuen);
     add(Label3);

     Label4 = new JLabel("Refugio_Rodriguez@gmail.com");
     Label4.setBounds(-5, 345, 200, 100);
     Label4.setForeground(Color.WHITE);
     Label4.setHorizontalAlignment(SwingConstants.CENTER);
     add(Label4);

    Label5 = new JLabel();//En este Label se inserta la imagen de instagram
    Label5.setBounds(200, 0, 30, 30);  
    this.Pintar(this.Label5, "imagenes\\insta.jpeg");
    add(Label5);

    Label6 = new JLabel("Refugio_Rodriguez");
    Label6.setBounds(185, 0, 200, 30);
    Label6.setForeground(Color.BLACK);
    Label6.setHorizontalAlignment(SwingConstants.CENTER);
    add(Label6);

    Label7 = new JLabel();//En este Label se inserta la imagen de whatsappp
    Label7.setBounds(370, 0, 30, 30);  
    this.Pintar(this.Label7, "imagenes\\Whatsappp.jpg");
    add(Label7);

    Label8 = new JLabel("61827027");
    Label8.setBounds(330, 0, 200, 30);
    Label8.setForeground(Color.BLACK);
    Label8.setHorizontalAlignment(SwingConstants.CENTER);
    add(Label8);

     Panel1 = new JPanel();
     Panel1.setBounds(0, 0, 200, 450);
     Panel1.setBackground(new Color(114, 47, 169));
     add(Panel1);
}//Fin del metodo constructor

public static void main(String[] Ars){//Creamos el JFrame 
    Menu2 llamar = new Menu2();
    llamar.setBounds(0,0,670,450);
    llamar.setVisible(true);
    llamar.setLocationRelativeTo(null);
    llamar.getContentPane().setBackground(Color.WHITE);//Color    
    }//Fin del main


@Override
public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == Agregar){

        AgregarIndigente llamar = new AgregarIndigente();
        llamar.setBounds(0,0,670,450);
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(new Color(178, 217, 227));//Color
    dispose();
}//Fin if

if (e.getSource() == Buscar){
    Actualizar llamar = new Actualizar();
    llamar.setBounds(0, 0, 670, 450);
    llamar.setVisible(true);
    llamar.setLocationRelativeTo(null);
    llamar.getContentPane().setBackground(new Color(178, 217, 227));// Color

}//Fin ir a llamar

if (e.getSource() == Salir){
dispose();
}//Fin ir a llamar

if (e.getSource() == Autores){
JOptionPane.showMessageDialog(null, "Creadores del sistema: \n- Deiby Adrián Ruiz Rodríguez \n- Ángeles Gabriela Rodríguez Badilla");

}//Fin ir a llamar

if (e.getSource() == Mostrar){
 Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String SQL = "SELECT Nombre, Edad, Tiempo, Cama, Sexo FROM indigente";
        
        try {
            // Establecer la conexión
            Class.forName("com.mysql.jdbc.Driver"); 
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Refugio?verifyServerCertificate=false&useSSL=true", "root", "Deiby_R04");
   
            pstmt = (PreparedStatement) con.prepareStatement(SQL);

            rs = pstmt.executeQuery();
        
            ResultSetMetaData resul = (ResultSetMetaData) rs.getMetaData();
            int columnCount = resul.getColumnCount();

            DefaultTableModel tableModel = new DefaultTableModel();
            
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(resul.getColumnName(i));
            }
            
            // Añadir las filas al modelo de la tabla
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }
            
            // Crear la tabla con el modelo y mostrarla en un JScrollPane
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            
            // Mostrar la tabla en un JOptionPane
            JOptionPane.showMessageDialog(null, scrollPane, "Datos del Refugio", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador JDBC.");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + sqle.getMessage());
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
}//fin ir a mostrar

if (e.getSource() == Eliminar){
        Eliminar eliminar = new Eliminar(); 
        eliminar.setVisible(true); 
        dispose(); 
}//fin ir a eliminar

}//Fin de las acciones

private void Pintar (JLabel lbl, String ruta) { //Este metodo se utiliza para ponerle imagenes de fondo a los Labels
	this.imagen = new ImageIcon(ruta);
	this.icono = new ImageIcon(
			this.imagen.getImage().getScaledInstance(
					lbl.getWidth(),
					lbl.getHeight(),
					Image.SCALE_DEFAULT)
			);	
	lbl.setIcon(this.icono);
	this.repaint();
	}//Fin del metodo Pintar

}//Fin de la clase
