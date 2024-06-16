package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener {
private JButton Continuar;
private JLabel La1, La2, La3,LabelIma;
private JTextField TextUsuario;
private JPasswordField Contra;
public static String NOM, LUG, CAP;
private ImageIcon imagen;
private Icon icono;

public Login(){
    
    //Creacion de los elementos de la intefaz grafica
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    La1 = new JLabel("Inicio sesión");
    La1.setBounds(210, 90, 200, 30);
    La1.setForeground(Color.WHITE);
    Font fuen = new Font("Courier New", Font.BOLD, 16); // Tipo de fuente, estilo y tamaño
    La1.setFont(fuen);
    La1.setHorizontalAlignment(SwingConstants.CENTER);
    add(La1);

    La2 = new JLabel("Usuario");
    La2.setBounds(165, 120, 200, 30);
    La2.setForeground(Color.WHITE);
    Font fuente = new Font("Courier New", Font.BOLD, 9); // Tipo de fuente, estilo y tamaño
    La2.setFont(fuente);
    La2.setHorizontalAlignment(SwingConstants.CENTER);
    add(La2);

    La3 = new JLabel("Contraseña");
    La3.setBounds(172, 170, 200, 30);
    La3.setForeground(Color.WHITE);
    Font fuentee = new Font("Courier New", Font.BOLD, 9); // Tipo de fuente, estilo y tamaño
    La3.setFont(fuentee);
    La3.setHorizontalAlignment(SwingConstants.CENTER);
    add(La3);

    Continuar = new JButton("Iniciar sesión");
    Continuar.addActionListener(this); 
    Continuar.setBounds(245, 260, 160, 30);
    Continuar.setBackground(new Color(255, 3, 3)); 
    Continuar.setForeground(Color.WHITE);
    Continuar.setBorder(null);
    Continuar.setFocusPainted(false);
    add(Continuar);

    TextUsuario = new JTextField(" ");
    TextUsuario.setBounds(245, 140, 160, 30);
    TextUsuario.setBackground(new Color(42, 38, 38));
    TextUsuario.setForeground(Color.WHITE);
    TextUsuario.setBorder(null);
    add(TextUsuario);

    Contra = new JPasswordField("");
    Contra.setBounds(245, 190, 160, 30);
    Contra.setBackground(new Color(42, 38, 38));
    Contra.setForeground(Color.WHITE);
    Contra.setBorder(null);
    add(Contra);

    LabelIma = new JLabel();//En este Label se inserta la imagen de fondo
    LabelIma.setBounds(0, 0, 670, 450);  
    this.Pintar(this.LabelIma, "imagenes\\Refugio (3).jpg");
    add(LabelIma);

}//Fin del constructor

public static void main(String[] Ars){//Creamos el JFrame 
    Login llamar = new Login();
    llamar.setBounds(0,0,670,450);
    llamar.setVisible(true);
    llamar.setLocationRelativeTo(null);
    llamar.getContentPane().setBackground(new Color(178, 217, 227));//Color

    }//Fin del main

@Override
public void actionPerformed(ActionEvent e) {

     if (e.getSource() == Continuar){
        char[] password = Contra.getPassword();
        // Convert char array to String (not recommended)
        String contra = new String(password);
        String usuario = TextUsuario.getText();

if("Deiby_R04".equals(usuario) || "1234".equals(contra)){

        Menu2 llamar = new Menu2();
        llamar.setBounds(0,0,670,450);
        dispose();
        llamar.setVisible(true);
        llamar.setLocationRelativeTo(null);
        llamar.getContentPane().setBackground(Color.WHITE);//Color    
}else{
    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
}

     }

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
