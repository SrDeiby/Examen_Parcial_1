package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Autores extends JFrame {

    private JButton Salir;
    private JLabel La1, La2, LabelIma, LabelIma2;
    private ImageIcon imagen;
    private Icon icono;

public Autores(){
       setBounds(0, 0, 670, 450);
       setBackground(new Color(77, 151, 75));
       setLayout(null);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       JPanel PanelCredito = new JPanel();
       setContentPane(PanelCredito);
       getContentPane();
       PanelCredito.setLayout(null);
       PanelCredito.setBackground(Color.WHITE);

       LabelIma = new JLabel();//En este Label se inserta la imagen de Angeles
       LabelIma.setBounds(125, 20, 90, 120);  
       this.Pintar(this.LabelIma, "Imagenes\\Angeles.jpg");
       add(LabelIma);

       LabelIma2 = new JLabel();//En este Label se inserta la imagen de Deiby
       LabelIma2.setBounds(390, 20, 90, 120);  
       this.Pintar(this.LabelIma2, "Imagenes\\Yo.jpg");
       add(LabelIma2);

        La1 = new JLabel("<html>Ángeles Gabriela <br> Rodríguez Badilla</html>");
        La1.setBounds(100, 150, 300, 40);
        Font fuent = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
        La1.setForeground(Color.BLACK);
        La1.setFont(fuent);
        add(La1);

        La2 = new JLabel("<html>Deiby Adrián <br> Ruiz Rodríguez</html>");
        La2.setBounds(380, 150, 300, 40);
        La2.setForeground(Color.BLACK);
        La2.setFont(fuent);
        add(La2);

     Salir = new JButton("Salir");
     Salir.setBounds(540, 370, 100,30);
     Salir.setBackground(new Color(39, 244, 225));
     Salir.setBorderPainted(false);
       Salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Menu2 llamar = new Menu2();
            llamar.setBounds(0,0,670,450);
            llamar.setVisible(true);
            llamar.setLocationRelativeTo(null);
            llamar.getContentPane().setBackground(Color.WHITE);//Color   
            dispose();
        }
    });
       PanelCredito.add(Salir);

    }//Fin constructor
    
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
