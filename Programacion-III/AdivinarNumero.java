import java.util.Scanner;

public class AdivinarNumero {
    private int numero_intentos = 3;
    private int numero_random;
    private int valor_minimo = 1;
    private int valor_maximo = 10;
    private int numero_usuario = 0;

    public static void main(String[] args) {
        AdivinarNumero juego = new AdivinarNumero();
        juego.start();
    }

    public void start() {
        numero_random = (int) (Math.random() * valor_maximo) + valor_minimo;
        System.out.println("Adivina el número entre " + valor_minimo + " y " + valor_maximo);
        Scanner input = new Scanner(System.in);

        do {
            mensaje();
            numero_usuario = Integer.parseInt(input.nextLine());

            if (numero_random < numero_usuario) {
                System.out.println("El numero random es menor");
                numero_intentos--;

            } else if (numero_random > numero_usuario) {
                System.out.println("El numero random es mayor");
                numero_intentos--;
            }

        } while (numero_usuario != numero_random && numero_intentos > 0);

        if (numero_random == numero_usuario) {
            System.out.println("Adivinaste correctamente");
        }else{
            System.out.println("Perdiste");
        }

        input.close();
    }

    public void mensaje() {
        System.out.println("Tienes " + numero_intentos + " intentos para adivinar");
        System.out.print("¿cual es el numero?: ");

    }

}
