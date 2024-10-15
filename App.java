import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;


public class App {
    private static boolean pressed = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.getContentPane().setLayout(layout);
        // frame.getContentPane().setBackground(Color.red);

        gbc.weighty = 0.2;
        gbc.weightx = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;
        gbc.gridy=0;
        JButton button = new JButton("Boton1");
        frame.getContentPane().add(button,gbc);

        gbc.weightx = 0.8;
        gbc.gridx=1;
        gbc.gridy=0;
        JButton button2 = new JButton("Boton2");
        frame.getContentPane().add(button2,gbc);

        gbc.weighty = 0.8;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=2;
        JButton button3 = new JButton("Boton3");
        frame.getContentPane().add(button3,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        JLabel etiqueta = new JLabel("Texto");
        etiqueta.setForeground(Color.blue);
        etiqueta.setFont(new Font("Serif", Font.PLAIN, 18));
        etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.pink);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(etiqueta,gbc);


        // añadir un ChangeListener para monitorear los cambios en el botón
        button.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                // System.out.println("Button presionado: "+model.isPressed());
                if (pressed){
                    System.out.println("Button liberado");
                }
                pressed = model.isPressed();
            }
        });

        button2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
                button2.setText("Coordenadas: ("+e.getX()+", "+e.getY() +")");
             }
        });

        button3.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_B) {
                    System.out.println("tecla presionada : "+ e.getKeyChar());
                    etiqueta.setText("nuevo texto");
                }
        
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog(frame, "Hola", true);
                d.setResizable(false);
                d.getContentPane().setBackground(Color.red);
                d.setSize(300,300);
                d.setLocationRelativeTo(frame);
                d.setVisible(true);
            }
        });

        frame.pack();
        // frame.setSize(300, 300);

        frame.setVisible(true);
    }

}
