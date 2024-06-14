package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener {
   private JPanel Panel1;
   private JButton Agregar;
   private JLabel Label1, Label2, Label3, Label4, Label5, Label6, Label7, Label8;
   private ImageIcon imagen;
   private Icon icono;

public Menu(){     
    //Creacion de los elementos de la intefaz grafica
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

     Agregar = new JButton("Continuar");
     Agregar.setBounds(210, 210, 430,35);  
     Agregar.setHorizontalAlignment(SwingConstants.LEFT);
     Agregar.setBackground(new Color(39, 244, 225));
     Agregar.setBorderPainted(false);
     Agregar.addActionListener(this); 
     add(Agregar);

     Label1 = new JLabel("<html>Bienvenidos <center> al <br>Programa <br>de <br>Centros <br>de <br>Refugios <br>Rodriguez</html>");
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
     + "Este programa te va a ayudar a administrar de la mejor manera posible tu refugio. Mediante las acciones de agregar, actualizar, mostrar y eliminar a las personas, el programa te beneficiará en el manejo muy organizado del refugio para las personas sin hogar. </div></html>");
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

    Label5 = new JLabel();//En este Label se inserta la imagen de fondo
    Label5.setBounds(200, 0, 30, 30);  
    this.Pintar(this.Label5, "imagenes\\instagram.png");
    add(Label5);

    Label6 = new JLabel("Refugio_Rodriguez");
    Label6.setBounds(185, 0, 200, 30);
    Label6.setForeground(Color.BLACK);
    Label6.setHorizontalAlignment(SwingConstants.CENTER);
    add(Label6);

    Label7 = new JLabel();//En este Label se inserta la imagen de fondo
    Label7.setBounds(370, 0, 30, 30);  
    this.Pintar(this.Label7, "imagenes\\whatsapp.jpeg");
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
    Menu llamar = new Menu();
    llamar.setBounds(0,0,670,450);
    llamar.setVisible(true);
    llamar.setLocationRelativeTo(null);
    llamar.getContentPane().setBackground(Color.WHITE);//Color    

    }//Fin del main

@Override
public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == Agregar){
        Login llamar = new Login();
        dispose();
        llamar.setBounds(0,0,670,450);
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(new Color(178, 217, 227));//Color
}//Fin if

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
