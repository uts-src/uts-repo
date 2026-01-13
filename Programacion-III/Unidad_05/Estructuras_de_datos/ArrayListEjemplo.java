import java.util.ArrayList;

public class ArrayListEjemplo {

    public static void main(String[] args) {
    
        //ARRAYLIST
        System.out.print("--------------");
        System.out.println("\nARRAYLIST");
        ArrayList<String> textos = new ArrayList<>(); //Se crea e inicializa el ArrayList, que va almacenar
                                                      // cadenas de texto. Observar que no se indica un tamaño
                                                      // para el ArrayList
        textos.add("Adios");// se agrega el primer elemento al arrayList en el indice 0
        textos.add("a");   // se agrega el segundo elemento al arrayList en el indice 1
        textos.add("todos"); // se agrega el tercer elemento al arrayList en el indice 2

        System.out.println("\nUsando un bucle for each: ");
        textos.forEach((elemento)->{
            System.out.println(elemento);
        });

        System.out.println("\nUsando un bucle for: "); // se recorren e imprimen cada uno de los elementos
        for (int index = 0; index < textos.size() ; index++) {  // del ArrayList
            if (textos.get(index).equals("Adios")) {
                textos.set(index, "Hola"); // se cambia el valor del elemento especificado en el indice. 
            }
            System.out.println(textos.get(index));
        }

        System.err.println();
        textos.addFirst("Quiero decirles"); // se agrega un elemento al inicio del ArrayList
        textos.addLast("Feliz Navidad");  // se agrega un elemento al final del ArrayList
        textos.add(4, "mis amigos");  // se agrega un elemento en el indice 4 del ArrayList

        textos.forEach((elemento)->{
            System.out.println(elemento);
        });

        textos.removeFirst(); // se remueve el primer elemento del arraylist
        textos.removeLast();  // se remueve el ultimo elemento del arraylist
        textos.remove("todos"); // se remueve el elemento "todos" del arraylist
        textos.remove(1); // se remueve el elemento en el indice 1 del arraylist

        System.err.println();
        textos.forEach((elemento)->{
            System.out.println(elemento);
        });

        textos.clear(); // remueve todos los elementos del arrayList

        if (textos.isEmpty()) { // el método isEmpty(), retorna true si el arrayList esta Vacio 
            System.out.println("\nEl ArrayList esta vacio");
        }

        System.out.println("--------------");
        ArrayList<Persona> personas = new ArrayList<>(); //Se crea un arrayList que almacenará objetos de tipo Persona
        personas.add(new Persona("Pepe",25)); // Se Crea un objeto Persona y se agrega como primer elemento del
                                                       // ArrayList
        personas.add(new Persona("Rosa",44)); // Segundo Objeto Persona creado y agregado al ArrayList
        personas.add(new Persona("Esteban",30)); // Tercer Objeto Persona creado y agregado al ArrayList

        System.out.println("Imprimiendo datos de un ArrayList que contiene Objetos de tipo Persona:");
        personas.forEach(persona->{
            System.out.println(persona.nombre+" "+persona.edad); // imprimir los objetos Persona del ArrayList
        });
    }
    //Documentacion del ArrayList: https://devdocs.io/openjdk~21/java.base/java/util/arraylist
}