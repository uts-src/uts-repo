import java.util.ArrayList;

public class EstructurasDeDatos {

    public static void main(String[] args) {
        //ARRAY
        System.out.println("ARRAY");
        int numeros[]; // declaración del Array que guardara numeros enteros
        numeros = new int[5]; // Inicialización del Array, tiene capacidad de almacenar 5 elementos
        numeros[0] = 10; //Se accede al primer elemento del Array(índice 0) y se le asigna el valor de 10;
        numeros[1] = 20; //Se accede al segundo elemento del Array(índice 1) y se le asigna el valor de 20;
        numeros[2] = 30; //Se accede al tercer elemento del Array(índice 2) y se le asigna el valor de 30;
        numeros[3] = 40; //Se accede al cuarto elemento del Array(índice 3) y se le asigna el valor de 40;
        numeros[4] = 50; //Se accede al quinto elemento del Array(índice 4) y se le asigna el valor de 50;
        //numeros[5] = 60; //Esto producira un error: Se asigna un valor al sexto elemento del Array, pero
                        // resulta que el array solo tiene capacidad de almacenar 5 elementos.
        
        for (int i = 0; i < numeros.length; i++) { // se recorre el array desde el indice 0, hasta el ultimo 
            if (i == 3) {                          // elemento, y se imprimen los valores de cada elemento.
                numeros[i] = 1000;                 // al elemento que se encuentra en el indice 3 se le cambia su
            }                                      // valor.
            System.out.println(numeros[i]);
        }

        System.out.println("\nUsando un bucle for each: "); //usando un bucle FOR EACH

        for (int i : numeros) {
            System.out.println(i+500); // Se imprimen las sumas de los valores de cada elemento del array
        }                              // sumados con 500.

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