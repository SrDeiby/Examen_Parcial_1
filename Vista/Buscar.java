package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;

public class Buscar extends JFrame  implements ActionListener {
	private JLabel 	Label4, Label6, Label5,Label8, Label9, Label10;
	private JTextField Co;

	public Buscar(){
	//Creacion de los elementos de la intefaz grafica
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);	

	    Label4 = new JLabel("Nombre: ");
	    Label4.setBounds(20, 100, 100, 30);	
        Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        Label4.setForeground(Color.BLACK);
        Label4.setFont(fuent);   
	    add(Label4);
	    
	    Label5 = new JLabel("Codigo: ");
	    Label5.setBounds(20, 140, 100, 30);
        Font fuente = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        Label5.setForeground(Color.BLACK);	 
        Label5.setFont(fuente);  
	    add(Label5);
	     
	    Label6 = new JLabel("Ubicacion: ");
	    Label6.setBounds(20, 180, 100, 30);	
        Font fuentee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        Label6.setFont(fuentee);
        Label6.setForeground(Color.BLACK);
	    add(Label6);
	    
	    Label8 = new JLabel(" ");
	    Label8.setBounds(100, 100, 100, 30);	   
	    add(Label8);
	    
	    Label9 = new JLabel(" ");
	    Label9.setBounds(100, 140, 100, 30);	   
	    add(Label9);
	    
	    Label10 = new JLabel(" ");
	    Label10.setBounds(100, 180, 100, 30);	   
	    add(Label10);

        Co = new JTextField("");
        Co.setBounds(100, 40, 120, 30);
        Co.setBackground(new Color(210, 240, 236)); 
        Co.setBorder(null);
        add(Co);
    
        Label5 = new JLabel("<html>Codigo</html>");
        Label5.setBounds(20, 35, 100, 40);
        Font fuenteee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        Label5.setForeground(Color.BLACK);
        Label5.setFont(fuenteee);
        add(Label5);

    }// del abstracto
    public static void main(String[] Ars){
        Buscar llamar = new Buscar();
        llamar.setBounds(0,0,670,450);
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(new Color(178, 217, 227));//Color
	    }//Fin del main

        @Override
public void actionPerformed(ActionEvent e) {

}//Fin de las acciones

}//Fin de la clase