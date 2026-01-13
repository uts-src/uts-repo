import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class LeerEscribirArchivos {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Escribe tu nombre : ");
        String data = input.nextLine();

        LeerEscribirArchivos archivos = new LeerEscribirArchivos();
        String rutaArchivo = "archivo.txt";
        archivos.guardarArchivo(rutaArchivo, data);
        System.out.println("\nLeyendo archivo");
        archivos.leerArchivo(rutaArchivo);
        
        System.out.println("desea borrar el archivo? si(s)");
        if (input.nextLine().equals("s")) {
            archivos.borrarArchivo(rutaArchivo);    
        }
        input.close();
    }

    private void guardarArchivo(String rutaArchivo, String data) {
        Path myPath = Paths.get(rutaArchivo);
        try (BufferedWriter writer = Files.newBufferedWriter(myPath, StandardOpenOption.APPEND,
                StandardOpenOption.CREATE)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leerArchivo(String rutaArchivo) {
        Path ruta = Paths.get(rutaArchivo);
        try (BufferedReader reader = Files.newBufferedReader(ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean borrarArchivo(String rutaArchivo){
        Path ruta = Paths.get(rutaArchivo);
        boolean exito = false;
        try {
          exito = Files.deleteIfExists(ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exito;
    }
}
