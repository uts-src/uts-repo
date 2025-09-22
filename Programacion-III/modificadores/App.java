import paqueteA.Animal;
import paqueteA.ArrayDeAnimalesA;
import paqueteA.Perro;
import paqueteB.ArrayDeAnimalesB;
import paqueteB.Mono;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Animal: ");
        Animal ani = new Animal("Pikachu",2.0f);
        ani.nombre_animal = "Pikachu-2";
        ani.peso_kg = 5.0f;
        ani.vivir_meses(3);
        System.out.println(ani.toString()); 

        System.out.print("Perro: ");
        Perro firu = new Perro();
        firu.nombre_animal = "flofi-3";
        firu.peso_kg = 10.0f;
        firu.vivir_meses(10);
        System.out.println(firu.toString());

        System.out.println("ArrayDeAnimalesA: ");
        ArrayDeAnimalesA array_ani_A = new ArrayDeAnimalesA();
        array_ani_A.CrearArrayAnimal();

        System.out.print("Mono: ");
        Mono mono = new Mono();
        mono.nombre_animal = "mono-1";
        mono.peso_kg = 10.0f;
        mono.toString();
        mono.vivir_meses(6);
        System.out.println(mono.toString());

        System.out.println("ArrayDeAnimalesB: ");
        ArrayDeAnimalesB array_ani_B = new ArrayDeAnimalesB();
        array_ani_B.CrearArrayAnimal();
    }
}
