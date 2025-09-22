package paqueteB;
import paqueteA.Animal;

public class ArrayDeAnimalesB {
    public void CrearArrayAnimal(){
        Animal animales[] = {new Animal("michi",2),new Animal("michi2",3)};
        animales[0].nombre_animal = "filiberto";
        animales[0].peso_kg = 5;

        animales[1].nombre_animal = "Paco";
        animales[1].peso_kg = 4.0f;

        System.out.println(animales[0].toString()); 
        System.out.println(animales[1].toString());
    }
}
