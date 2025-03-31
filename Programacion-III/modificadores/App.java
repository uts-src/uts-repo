import paqueteA.Animal;
import paqueteA.Gato;
import paqueteA.Perro;
import paqueteB.Lagarto;
import paqueteB.Mono;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Animal: ");
        Animal ani = new Animal();
        ani.atr_publico = 1000;
        ani.mostrar();

        System.out.print("Perro: ");
        Perro firu = new Perro();
        firu.atr_publico = 5000;
        firu.setAtributos();
        firu.mostrar();

        System.out.print("Gato: ");
        Gato michi = new Gato();
        michi.usarAnimal();

        System.out.print("Mono: ");
        Mono mono = new Mono();
        mono.atr_publico = 5000;
        mono.setAtributos();
        mono.mostrar();

        System.out.print("Lagarto: ");
        Lagarto lagarto = new Lagarto();
        lagarto.usarAnimal();
    }
}
