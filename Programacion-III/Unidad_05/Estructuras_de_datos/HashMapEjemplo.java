import java.util.HashMap;

public class HashMapEjemplo {

    public static void main(String[] args) {
        
        //Se crea un Mapa
        HashMap <String,Integer> Personajes_nivel_vida = new HashMap<>();
        //Agregar 4 elementos(clave,valor) al mapa
        Personajes_nivel_vida.put("Guerrero", 1000);
        Personajes_nivel_vida.put("Mago", 700);
        Personajes_nivel_vida.put("Elfo", 1500);
        Personajes_nivel_vida.put("Gigante", 900);
        
        // Imprimir el mapa
        System.out.println(Personajes_nivel_vida);

        //Obtener el valor de una clave del mapa e imprimirlo
        System.out.println(Personajes_nivel_vida.get("Elfo"));

        //Iterar un HashMap
        for (String clave : Personajes_nivel_vida.keySet()) {
            System.out.println(Personajes_nivel_vida.get(clave));
        }

        //Remover un elemento del mapa
        Personajes_nivel_vida.remove("Mago");
        System.out.println("Eliminado el mago");
        for (String clave : Personajes_nivel_vida.keySet()) {
            System.out.println(Personajes_nivel_vida.get(clave));
        }

        //Eliminar todos los elementos del mapa
        Personajes_nivel_vida.clear();
        System.out.println("Eliminado todos los elementos del mapa");
        for (String clave : Personajes_nivel_vida.keySet()) {
            System.out.println(Personajes_nivel_vida.get(clave));
        }

        //Un mapa que almacena objetos de tipo persona.
        HashMap <String,Persona> cargos = new HashMap<>();
        cargos.put("jefe", new Persona("Pepito", 42));
        cargos.put("Supervisor", new Persona("Angela", 35));
        cargos.put("Obrero", new Persona("Marco", 29));

        // Imprimir el mapa
        System.out.println(cargos);

        //Obtener el valor de una clave del mapa e imprimirlo
        System.out.println(cargos.get("Obrero").nombre);

    }
    //Documentacion del HashMap: https://devdocs.io/openjdk~21/java.base/java/util/hashmap
}