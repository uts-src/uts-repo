/**
 * estructuras
 */
public class Estructuras {
    public static void main(String[] args) {

        /*
         * Estructura secuencial:
         * el código se ejecuta linea a linea de arriba hacia abajo
         */
        int a = 15;
        int b = 70;
        int suma = a + b;
        System.out.println("la suma es : " + suma);

        /*
         * Estructura condicional (if):
         * el código dentro del bloque if se ejecuta si la condición a evaluar
         * es verdadera
         */
        boolean valor_booleano = true;
        if (valor_booleano) {
            System.out.println("if");
        }

        /*
         * Estructura condicional (if-else):
         * el código dentro del bloque if se ejecuta si la condición a evaluar
         * es verdadera, de lo contrario se ejecuta el código dentro del bloque else
         */
        boolean valor_booleano2 = false;
        if (valor_booleano2) {
            System.out.println("if");
        } else {
            System.out.println("else");
        }

        /*
         * Estructura condicional (if-elseif-else):
         * el código dentro del bloque if se ejecuta si la condición a evaluar
         * es verdadera, de lo contrario se evalua si la condición para el bloque else if
         * es verdadera, si esto es asi se ejecuta el código en dicho bloque. Si la condición
         * en el bloque else if es falsa entonces se ejecuta el bloque else.
         */
        int numero = 3;
        if (numero > 5) {
            System.out.println("if (if-elseif-else)");
        }else if (numero > 3) {
            System.out.println("else if");
        } 
         else {
            System.out.println("else (if-elseif-else)");
        }

        /*
         * Estructura de control iterativa (for):
         * el código dentro del bucle for se ejecutara tantas veces como se indique
         * en su sección de control (i < veces).
         */
        int veces = 5;
        for (int i = 0; i < veces; i++) {
            System.out.println("bucle for: " + i);
        }

        /*
         * Estructura de control iterativa (for) usando break y continue:
         * break : sale del bucle
         * continue : salta hacia la próxima iteración
         */
        int veces2 = 7;
        for (int i = 0; i < veces2; i++) {
            if (i == 2) {
                continue;
            }
            System.out.println("usando break y continue: " + i);
            if (i == 5) {
                break;
            }
        }

        /*
         * Estructura de control iterativa (while):
         * el código dentro del bucle while se ejecutara tantas veces siempre y cuando
         * la condición evaluada sea verdadera.
         */
        int num = 0;
        while (num < 3) {
            num++;
            System.out.println("bucle while: " + num);
        }

        /*
         * estructura de control iterativa (do-while): 
         * siempre y cuando la condición en el while sea verdadera se ejecutara el bloque de
         * código en el do{}, con excepción de la primera iteración, la cual
         * siempre ejecuta el bloque de código en el do{}.
         */
        int contador = 4;
        do {
            System.out.println("bucle do-while: "+ contador);
            contador--;
        } while (contador > 2);

    }

}