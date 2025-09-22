package paqueteA;

public class ArrayDeAnimalesA {
    public void CrearArrayAnimal(){
        Animal animales[] = {new Animal("michi",2),new Animal("michi2",3)};
        animales[0].nombre_animal = "filiberto";
        animales[0].peso_kg = 5.0f;

        animales[1].nombre_animal = "Paco";
        animales[1].peso_kg = 4;

        System.out.println(animales[0].toString()); 
        System.out.println(animales[1].toString());
    }
}
