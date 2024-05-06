package Vista;

    import javax.swing.*;

    public class Mostrar extends JFrame {
        
        public Mostar() {
            // Configurar la ventana
            setTitle("Registro completo del refugio");
            setSize(300, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            // Agregar la lista a un JScrollPane para permitir el desplazamiento si hay muchos datos
            JScrollPane scrollPane = new JScrollPane;
            
            // Agregar el JScrollPane a la ventana
            add(scrollPane);
            
            // Hacer visible la ventana
            setVisible(true);
        }
        
        public static void main(String[] args) {
            // Crear y mostrar la interfaz
            new Mostrar();
        }
    }

