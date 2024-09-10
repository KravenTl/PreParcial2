package umg.programacionII.DateBase.Formularios.Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejercicio1 extends JFrame {
    private JLabel lblTitulo1;
    private JPanel jFormEjercicio1;
    private JButton buttonCrear1;
    private JButton buttonBuscar1;
    private JButton buttonActualizar1;
    private JButton buttonEliminar1;
    private JButton buttonRegresaralMenu;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ejercicio1");
        frame.setContentPane(new ejercicio1().jFormEjercicio1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);//tamaño de la ventana
        frame.setVisible(true);
    }

    public ejercicio1() {//contructor para modificar el ejericio 1

        // Establecer el layout del panel a null para posicionar manualmente los componentes
        jFormEjercicio1.setLayout(null);

        // Cambiar la posición y tamaño del lblTitulo
        lblTitulo1.setBounds(145,20,200,50);

        // Cambiar el tamaño de la fuente del lblTitulo
        lblTitulo1.setFont(new Font("Arial", Font.BOLD, 20));

        // Ajustar la posición y el tamaño de los botones

        buttonCrear1.setBounds(50, 100, 100, 30);
        buttonBuscar1.setBounds(160, 100, 100, 30);
        buttonActualizar1.setBounds(270, 100, 100, 30);
        buttonEliminar1.setBounds(50, 150, 100, 30);
        buttonRegresaralMenu.setBounds(160, 150, 100, 30);

        // Configuramos el contenido del JFrame con el panel jFormEjercicio1
        setContentPane(jFormEjercicio1);
        setTitle("Ejercicio 1");
        setSize(400, 300); // Establecer tamaño
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para cerrar sólo esta ventana
        setLocationRelativeTo(null); // Centrar la ventana


        buttonCrear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
