package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Agregar extends JFrame implements ActionListener {
private JButton Aceptar, Salir;

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
