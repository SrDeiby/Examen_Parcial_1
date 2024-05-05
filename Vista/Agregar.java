package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Agregar extends JFrame implements ActionListener {
private JButton Aceptar, Salir;
private JLabel La1, La2, La3;
private JTextField TextNombre, TextLugar, TextCapacidad;

public Agregar(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Aceptar = new JButton("Aceptar");
    Aceptar.setBounds(540, 350, 100, 30);
    Aceptar.setBackground(new Color(225, 197, 91)); 
    Aceptar.setForeground(Color.BLACK);
    add(Aceptar);

    Salir = new JButton("Salir");
    Salir.setBounds(420, 350, 100, 30);
    Salir.setBackground(new Color(225, 197, 91)); 
    Salir.setForeground(Color.BLACK);
    add(Salir);

    La1 = new JLabel("<html>Nombre</html>");
     La1.setBounds(20, 20, 100, 40);
     Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     La1.setForeground(Color.BLACK);
     La1.setFont(fuent);
     add(La1);

     La2 = new JLabel("<html>Lugar</html>");
     La2.setBounds(20, 70, 100, 40);
     Font fuente = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     La2.setForeground(Color.BLACK);
     La2.setFont(fuente);
     add(La2);

     La3 = new JLabel("<html>Capacidad</html>");
     La3.setBounds(20, 120, 100, 40);
     Font fuentee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
     La3.setForeground(Color.BLACK);
     La3.setFont(fuentee);
     add(La3);

    TextNombre = new JTextField("");
    TextNombre.setBounds(130, 25, 120, 30);
    TextNombre.setBackground(new Color(210, 240, 236)); 
    TextNombre.setForeground(Color.decode("#333333")); // Color de texto gris oscuro 
    TextNombre.setBorder(null);
    add(TextNombre);

    TextLugar = new JTextField("");
    TextLugar.setBounds(130, 75, 120, 30);
    TextLugar.setBackground(new Color(210, 240, 236)); 
    TextLugar.setForeground(Color.decode("#333333")); // Color de texto gris oscuro 
    TextLugar.setBorder(null);
    add(TextLugar);

    TextCapacidad = new JTextField("");
    TextCapacidad.setBounds(130, 125, 120, 30);
    TextCapacidad.setBackground(new Color(210, 240, 236)); 
    TextCapacidad.setForeground(Color.decode("#333333")); // Color de texto gris oscuro 
    TextCapacidad.setBorder(null);
    add(TextCapacidad);

}//Fin del constructor

public static void main(String[] Ars){//Creamos el JFrame 
    Agregar llamar = new Agregar();
    llamar.setBounds(0,0,670,450);
    llamar.setVisible(true);
    llamar.setLocationRelativeTo(null);
    llamar.getContentPane().setBackground(new Color(178, 217, 227));//Color

    }//Fin del main

@Override
public void actionPerformed(ActionEvent e) {

}//Fin de las acciones

}//Fin de la clase
