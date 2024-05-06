package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controlador.ArrayRefugio;
import Modelo.Refugio;
import java.awt.*;

public class AgregarRefugio extends JFrame implements ActionListener {
private JButton Agregar, Continuar;
private JLabel La1, La2, La3, La4;
private JTextField TextNombre, TextLugar, TextCapacidad;
public static String NOM, LUG, CAP;
public AgregarRefugio(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Agregar = new JButton("Agregar");
    Agregar.addActionListener(this); 
    Agregar.setBounds(420, 350, 100, 30);
    Agregar.setBackground(new Color(225, 197, 91)); 
    Agregar.setForeground(Color.BLACK);
    add(Agregar);

    Continuar = new JButton("Continuar");
    Continuar.addActionListener(this); 
    Continuar.setBounds(540, 350, 100, 30);
    Continuar.setBackground(new Color(225, 197, 91)); 
    Continuar.setForeground(Color.BLACK);
    add(Continuar);

    La1 = new JLabel("<html>Nombre</html>");
     La1.setBounds(20, 100, 100, 40);
     Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     La1.setForeground(Color.BLACK);
     La1.setFont(fuent);
     add(La1);

     La2 = new JLabel("<html>Ubicacion</html>");
     La2.setBounds(20, 150, 100, 40);
     Font fuente = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     La2.setForeground(Color.BLACK);
     La2.setFont(fuente);
     add(La2);

     La3 = new JLabel("<html>Capacidad</html>");
     La3.setBounds(20, 200, 100, 40);
     Font fuentee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     La3.setForeground(Color.BLACK);
     La3.setFont(fuentee);
     add(La3);

    TextNombre = new JTextField("");
    TextNombre.setBounds(130, 105, 120, 30);
    TextNombre.setBackground(new Color(210, 240, 236)); 
    TextNombre.setBorder(null);
    add(TextNombre);

    TextLugar = new JTextField("");
    TextLugar.setBounds(130, 155, 120, 30);
    TextLugar.setBackground(new Color(210, 240, 236)); 
    TextLugar.setBorder(null);
    add(TextLugar);

    TextCapacidad = new JTextField("");
    TextCapacidad.setBounds(130, 205, 120, 30);
    TextCapacidad.setBackground(new Color(210, 240, 236)); 
    TextCapacidad.setBorder(null);
    add(TextCapacidad);

    La4 = new JLabel("<html>Registrar tu Refugio</html>");
     La4.setBounds(200, 20, 400, 50);
     Font fue = new Font("Courier New", Font.BOLD, 20); // Tipo de fuente, estilo y tamaño
     La4.setForeground(Color.BLACK);
     La4.setFont(fue);
     add(La4);

}//Fin del constructor

public static void main(String[] Ars){//Creamos el JFrame 
    AgregarRefugio llamar = new AgregarRefugio();
    llamar.setBounds(0,0,670,450);
    llamar.setVisible(true);
    llamar.setLocationRelativeTo(null);
    llamar.getContentPane().setBackground(new Color(178, 217, 227));//Color

    }//Fin del main

@Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == Agregar){
        //Accion del boton de Agregar
     NOM = TextNombre.getText();
     LUG = TextLugar.getText();
     CAP = TextCapacidad.getText();
     
     
    ArrayRefugio.refugio.add(new Refugio(NOM, LUG, CAP));//Guardamos los elementos en el ArrayList que se obtuvieron desde los JTextField en la interfaz grafica
     
    TextNombre.setText("");
    TextLugar.setText("");
    TextCapacidad.setText("");
       
     JOptionPane.showMessageDialog(null, "El refugio se ha agregado exitosamente");
     }//Fin if

     if (e.getSource() == Continuar){
        Menu2 llamar = new Menu2();
        llamar.setBounds(0,0,670,450);
        dispose();
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(Color.WHITE);//Color    
    

     }

}//Fin de las acciones

}//Fin de la clase
