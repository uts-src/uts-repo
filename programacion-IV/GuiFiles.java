import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

public class GuiFiles {
    private JFrame frame;
    private JComboBox<String> combo;
    private JFileChooser busqueda;
    private JTextField nombre_campo;
    private JTextField edad_campo;
    private JTextField ciudad_campo;
    private ArrayList<String> registros = new ArrayList<String>();

    public static void main(String[] args) {
        new GuiFiles().start();
    }

    private void start() {
        frame = new JFrame("Titulo Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(layout);
        frame.add(panel);

        // Ajustes adicionales
        Border border = BorderFactory.createEmptyBorder(4, 4, 4, 4);
        frame.getRootPane().setBorder(border);
        Font fuente_general = new Font("Serif", Font.BOLD, 12);
        UIManager.put("Label.font", fuente_general);
        UIManager.put("Button.font", fuente_general);
        // JFrame.setDefaultLookAndFeelDecorated(false);
        frame.setResizable(false);

        // Ajustes GridBagConstraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // etiqueta central de la App.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel titulo = new JLabel("MI APP");
        titulo.setFont(new Font("Serif", Font.PLAIN, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, gbc);
        gbc.gridwidth = 1;

        // Nombre etiqueta
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel nombre_label = new JLabel("Nombre :");
        panel.add(nombre_label, gbc);

        // Nombre campo
        gbc.gridx = 1;
        gbc.gridy = 1;
        nombre_campo = new JTextField(10);
        panel.add(nombre_campo, gbc);

        // Edad etiqueta
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel edad_label = new JLabel("Edad :");
        panel.add(edad_label, gbc);

        // Edad campo
        gbc.gridx = 1;
        gbc.gridy = 2;
        edad_campo = new JTextField(10);
        panel.add(edad_campo, gbc);

        // Ciudad etiqueta
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel ciudad_label = new JLabel("Ciudad :");
        panel.add(ciudad_label, gbc);

        // Ciudad campo
        gbc.gridx = 1;
        gbc.gridy = 3;
        ciudad_campo = new JTextField(10);
        panel.add(ciudad_campo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton agregar = new JButton("Agregar");
        panel.add(agregar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        combo = new JComboBox<String>();
        panel.add(combo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        JButton guardar_texto = new JButton("Guardar texto");
        panel.add(guardar_texto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        JButton cargar_texto = new JButton("Cargar texto");
        panel.add(cargar_texto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JButton guardar_serializado = new JButton("Guardar serializado");
        panel.add(guardar_serializado, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        JButton cargar_serializado = new JButton("Cargar serializado");
        panel.add(cargar_serializado, gbc);

        busqueda = new JFileChooser();

        // Eventos:
        agregar.addActionListener(e -> {
            agregarACombo();
        });
        guardar_texto.addActionListener(e -> {
            iniciarGuardarArchivoTexto();
        });
        guardar_serializado.addActionListener(e -> {
            iniciarGuardarArchivoSerializado();
        });
        cargar_texto.addActionListener(e -> {
            iniciarCargarArchivoTexto();
        });
        cargar_serializado.addActionListener(e -> {
            iniciarCargarArchivoSerializado();
        });

        // frame.setSize(300,300);
        frame.setVisible(true);
        frame.pack();
    }

    private void agregarACombo() {
        String nombre = nombre_campo.getText();
        String edad = edad_campo.getText();
        String ciudad = ciudad_campo.getText();
        if (!(nombre.equals("") || edad.equals("") || ciudad.equals(""))) {
            combo.addItem(nombre + " / " + edad + " / " + ciudad);
            nombre_campo.setText("");
            edad_campo.setText("");
            ciudad_campo.setText("");
        }
    }

    private void iniciarGuardarArchivoTexto() {
        guardarDatosArchivoTexto(retornarArchivoParaGuardar());
    }

    private void iniciarCargarArchivoTexto() {
        cargarDatosArchivoTexto(retornarArchivoParaCargar());
    }

    private void iniciarGuardarArchivoSerializado() {
        guardarDatosArchivoSerializado(retornarArchivoParaGuardar());
    }

    private void iniciarCargarArchivoSerializado() {
        cargarDatosArchivoSerializado(retornarArchivoParaCargar());
    }

    private File retornarArchivoParaGuardar() {
        int resultado = busqueda.showSaveDialog(frame);
        File archivo_seleccionado = null;
        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivo_seleccionado = busqueda.getSelectedFile();
        }
        return archivo_seleccionado;
    }

    private File retornarArchivoParaCargar() {
        int resultado = busqueda.showOpenDialog(frame);
        File archivo_seleccionado = null;
        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivo_seleccionado = busqueda.getSelectedFile();
        }
        return archivo_seleccionado;
    }

    private void guardarDatosArchivoTexto(File archivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < combo.getItemCount(); i++) {
                writer.write(combo.getItemAt(i) + "\n");
            }
            writer.close();
            combo.removeAllItems();
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }

    private void cargarDatosArchivoTexto(File archivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            combo.removeAllItems();
            while ((line = reader.readLine()) != null) {
                combo.addItem(line);
            }
            reader.close();
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    private void guardarDatosArchivoSerializado(File archivo) {
        try {
            FileOutputStream f = new FileOutputStream(archivo); // objeto usado para escribir un flujo de Bytes a un archivo.
            ByteArrayOutputStream bos = new ByteArrayOutputStream(); // Almacena un flujo de bytes.
            ObjectOutputStream o = new ObjectOutputStream(bos);// se usa para obtener un flujo de bytes de un objeto
                                                                // y en este caso los almacena en un ByteArrayOutputStream (bos)
            for (int i = 0; i < combo.getItemCount(); i++) {
                registros.add(combo.getItemAt(i));
            }
            combo.removeAllItems();
            o.writeObject(registros); // serializa el objeto(registros) en un flujo de bytes y los almacena en el ByteArrayOutputStream.
            o.close();
            registros.clear();

            byte[] serializedBytes = bos.toByteArray(); // bytes almacenados en el ByteArrayOutputStream a un array de bytes(serializedBytes)

            f.write(serializedBytes); // escribir el array de bytes al archivo
            f.close();
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo serializar los objetos: " + e.getMessage());
        }
    }

    private void cargarDatosArchivoSerializado(File archivo) {
        try {
            FileInputStream fi = new FileInputStream(archivo); // permite obtener un flujo de Bytes desde un
                                                                // archivo.
            ByteArrayInputStream bis = new ByteArrayInputStream(fi.readAllBytes());// se leen los bytes del archivo y se almacenan
                                                                                   // en un ByteArrayInputStream (bis)
            fi.close();
            ObjectInputStream oi = new ObjectInputStream(bis);// se lee un stream de bytes desde un ByteArrayInputStream(bis)
                                                            // para deserializar un objeto usando un ObjectInputStream(oi).

            ArrayList<?> datos_tipo_objeto =  (ArrayList<?>) oi.readObject(); // deserialización del objeto.
            combo.removeAllItems();
            datos_tipo_objeto.forEach(registro->combo.addItem((String)registro));

            oi.close();

        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            System.out.println("No se pudieron cargar los datos serializados" + e.getMessage());
        }
    }
}