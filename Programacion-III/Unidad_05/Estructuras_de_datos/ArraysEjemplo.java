public class ArraysEjemplo {

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

    }

}
