package umg.programacionII.DateBase.Formularios.Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class ejercicio2 extends JFrame {
    private JLabel lblTitulo2;
    private JPanel jFormEjercicio2;
    private JButton buttonCrear2;
    private JButton buttonBuscar2;
    private JButton buttonActualizar2;
    private JButton buttonEliminar2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ejercicio2");
        frame.setContentPane(new ejercicio2().jFormEjercicio2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }

    public ejercicio2() {//constructor para las modificaciones del ejercicio 2
        // Establecer el layout del panel a null para posicionar manualmente los componentes
        jFormEjercicio2.setLayout(null);

        // Cambiar la posición y tamaño del lblTitulo
        lblTitulo2.setBounds(145,20,200,50);

        // Cambiar el tamaño de la fuente del lblTitulo
        lblTitulo2.setFont(new Font("Arial", Font.BOLD, 20));

        // Ajustar la posición y el tamaño de los botones

        buttonCrear2.setBounds(50, 100, 100, 30);
        buttonBuscar2.setBounds(160, 100, 100, 30);
        buttonActualizar2.setBounds(270, 100, 100, 30);
        buttonEliminar2.setBounds(50, 150, 100, 30);


        // Configuramos el contenido del JFrame con el panel jFormEjercicio1
        setContentPane(jFormEjercicio2);
        setTitle("Ejercicio2");
        setSize(400, 300); // Establecer tamaño
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para cerrar sólo esta ventana
        setLocationRelativeTo(null); // Centrar la ventana





    }
}
