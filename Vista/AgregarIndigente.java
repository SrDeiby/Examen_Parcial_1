package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controlador.ArrayIndigente;
import Modelo.Indigente;
import java.awt.*;

public class AgregarIndigente extends JFrame implements ActionListener{

    private JButton Agregar, Salir;
    private JLabel La1, La2, La3;
    private JTextField TextNombre, TextEdad, TextTiempo;
    public static String NOM, EDAD, TIEMPO;
    
    public AgregarIndigente(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        Agregar = new JButton("Agregar");
        Agregar.setBounds(540, 350, 100, 30);
        Agregar.setBackground(new Color(225, 197, 91)); 
        Agregar.setForeground(Color.BLACK);
        add(Agregar);
    
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
    
         La2 = new JLabel("<html>Edad</html>");
         La2.setBounds(20, 70, 100, 40);
         Font fuente = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
         La2.setForeground(Color.BLACK);
         La2.setFont(fuente);
         add(La2);
    
         La3 = new JLabel("<html>Tiempo</html>");
         La3.setBounds(20, 120, 100, 40);
         Font fuentee = new Font("Courier New", Font.BOLD, 15); // Tipo de fuente, estilo y tamaño
         La3.setForeground(Color.BLACK);
         La3.setFont(fuentee);
         add(La3);
    
        TextNombre = new JTextField("");
        TextNombre.setBounds(130, 25, 120, 30);
        TextNombre.setBackground(new Color(210, 240, 236)); 
        TextNombre.setBorder(null);
        add(TextNombre);
    
        TextEdad = new JTextField("");
        TextEdad.setBounds(130, 75, 120, 30);
        TextEdad.setBackground(new Color(210, 240, 236)); 
        TextEdad.setBorder(null);
        add(TextEdad);
    
        TextTiempo = new JTextField("");
        TextTiempo.setBounds(130, 125, 120, 30);
        TextTiempo.setBackground(new Color(210, 240, 236)); 
        TextTiempo.setBorder(null);
        add(TextTiempo);

String[] elementos = {"Opción 1", "Opción 2", "Opción 3"};  
JComboBox<String> comboBox = new JComboBox<>(elementos);
comboBox.setBounds(140, 250, 100, 40);
comboBox.setBackground(new Color(210, 240, 236)); 
add(comboBox);
    
    }//Fin del constructor
    
    public static void main(String[] Ars){//Creamos el JFrame 
        AgregarIndigente llamar = new AgregarIndigente();
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
         EDAD = TextEdad.getText();
         TIEMPO = TextTiempo.getText();
         
         
        ArrayIndigente.indigente.add(new Indigente(NOM, EDAD, TIEMPO));//Guardamos los elementos en el ArrayList que se obtuvieron desde los JTextField en la interfaz grafica
         
        TextNombre.setText("");
        TextEdad.setText("");
        TextTiempo.setText("");
           
         JOptionPane.showMessageDialog(null, "La persona se ha agregado exitosamente");
         }//Fin if
    
    }//Fin de las acciones
    
    }//Fin de la clase