import java.util.Scanner;

public class Errores {

    public static void main(String[] args) {
        int valor_max = Integer.MAX_VALUE;
        int valor_min = Integer.MIN_VALUE;
        System.out.println("valor Integer MAXIMO: " + valor_max);
        System.out.println("valor Integer MINIMO: " + valor_min);
        int valor_nuevo = valor_max + 1;
        System.out.println("valor_nuevo: " + valor_nuevo);

        // ERRORES DE OVERFLOW
        try {
            Math.addExact(valor_max, 1);
            Math.subtractExact(valor_min, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage()); System.out.println(e.getClass());
        }

        // ERRORES DE DIVISIÓN POR CERO
        int numero = 100;
        try {
            int numero_2 = numero / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage()); System.out.println(e.getClass());
        }

        // ERRORES CONVERSIÓN DE DATOS
        String texto = "jojo";
        try {
            int numero3 = Integer.parseInt(texto);
            System.out.println(numero3);
        } catch (Exception e) {
            System.out.println(e.getMessage()); System.out.println(e.getClass());
        }

        // CAPTURANDO UN ERROR ESPECÍFICO CON CATCH DE RESPALDO.
        // IDEPENDIENTEMENTE SI SE PRODUCE O NO EL ERROR, FINALLY SE EJECUTA.
        try {
            // int numero3 = Integer.parseInt("pepe");
            // int resultado = 25/0;
            // Scanner input = new Scanner(System.in);
            // int numero_ingresado = input.nextInt();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // input.close();
        }
    }
}