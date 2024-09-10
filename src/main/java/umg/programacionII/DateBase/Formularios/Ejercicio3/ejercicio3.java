package umg.programacionII.DateBase.Formularios.Ejercicio3;

import javax.swing.*;
import java.awt.*;

public class ejercicio3 extends JFrame {
    private JLabel lblTitulo3;
    private JPanel jFormEjercicio3;
    private JButton buttonCrear3;
    private JButton buttonBuscar3;
    private JButton buttonActualizar3;
    private JButton buttonEliminar3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ejercicio3");
        frame.setContentPane(new ejercicio3().jFormEjercicio3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }

    public ejercicio3() {//constructor para modificar el Form del ejercicio 3
        // Establecer el layout del panel a null para posicionar manualmente los componentes
        jFormEjercicio3.setLayout(null);

        // Cambiar la posición y tamaño del lblTitulo
        lblTitulo3.setBounds(145,20,200,50);

        // Cambiar el tamaño de la fuente del lblTitulo
        lblTitulo3.setFont(new Font("Arial", Font.BOLD, 20));

        // Ajustar la posición y el tamaño de los botones

        buttonCrear3.setBounds(50, 100, 100, 30);
        buttonBuscar3.setBounds(160, 100, 100, 30);
        buttonActualizar3.setBounds(270, 100, 100, 30);
        buttonEliminar3.setBounds(50, 150, 100, 30);

        // Configuramos el contenido del JFrame con el panel jFormEjercicio1
        setContentPane(jFormEjercicio3);
        setTitle("Ejercicio2");
        setSize(400, 300); // Establecer tamaño
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para cerrar sólo esta ventana
        setLocationRelativeTo(null); // Centrar la ventana

    }
}
