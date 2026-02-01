import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;
import java.util.Scanner;
import java.util.ArrayList;

public class LeerEscribirArchivos {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Escribe tu nombre : ");
        String data = input.nextLine()+"\n";

        LeerEscribirArchivos archivos = new LeerEscribirArchivos();
        String rutaArchivo = "archivo.txt";
        OpenOption options[] = { 
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        };

        //Bloque try catch porque los metodos:guardarArchivo(),leerArchivo()
        //y borrarArchivo() podrian lanzar errores.
        try {
            archivos.guardarArchivo(rutaArchivo, data, options);
            ArrayList<String> lineas = archivos.leerArchivo(rutaArchivo);

            System.out.println("\nLeyendo archivo");
            lineas.forEach(linea -> {
                System.out.println(linea);
            });

            System.out.println("desea borrar el archivo? si(s)");
            if (input.nextLine().equals("s")) {
                archivos.borrarArchivo(rutaArchivo);
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
            if (e.getClass().equals(NoSuchFileException.class)) {
                System.out.println("El archivo: "+e.getMessage()+" no existe..");
            }
        }finally{
            input.close();
        }
    }

    private void guardarArchivo(String rutaArchivo, String data, OpenOption[] options) throws IOException {
        Path myPath = Paths.get(rutaArchivo);
        try (BufferedWriter writer = Files.newBufferedWriter(myPath, options)) {
            writer.write(data);
        }
    }

    private ArrayList<String> leerArchivo(String rutaArchivo) throws IOException {
        Path ruta = Paths.get(rutaArchivo);
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineas.add(line);
            }
            reader.close();
        }
        return lineas;
    }

    private boolean borrarArchivo(String rutaArchivo) throws IOException {
        Path ruta = Paths.get(rutaArchivo);
        boolean exito = Files.deleteIfExists(ruta);
        return exito;
    }
}
