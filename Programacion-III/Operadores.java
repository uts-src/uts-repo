public class Operadores {
    public static void main(String[] args) {

        // Concatenación
        String nombre = "pepe";
        System.out.println("Hola mi nombre es " + nombre);

        // una suma
        int a = 2;
        int b = 3;
        int suma = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + suma);

        // hallar el modulo
        int r = 7;
        int s = 2;
        int modulo = r % s;
        System.out.println("El módulo de " + r + " dividido por " + s + " es: " + modulo);

        // dividir dos números
        int m = 7;
        int n = 2;
        int div = m / n;
        float div_f = m / n;
        float div_f2 = (float) m / n; // aqui se hace la conversión de tipo
        System.out.println("El cociente entre " + m + " y " + n + " es: " + div);
        System.out.println("El cociente entre " + m + " y " + n + " es: " + div_f);
        System.out.println("El cociente entre " + m + " y " + n + " es: " + div_f2);

        // operadores de comparación
        int n1 = 5;
        int n2 = 7;
        boolean igual = (n1 == n2); // Comprueba si n1 es igual a n2.
        boolean noIgual = (n1 != n2); // Comprueba si n1 es diferente a n2.
        boolean mayorQue = (n1 > n2); // Comprueba si n1 es mayor que n2.
        boolean menorIgual = (n1 <= n2); // Comprueba si n1 es menor o igual que n2.
        System.out.println(igual);
        System.out.println(noIgual);
        System.out.println(mayorQue);
        System.out.println(menorIgual);

        // operadores de igualdad
        String s1 = new String("hola!");
        String s2 = new String("hola!");

        System.out.println("(s1 == s2): " + (s1 == s2));
        System.out.println("(s1.equals(s2)): " + (s1.equals(s2)));

        String s3 = "saludos";
        String s4 = "saludos";
        System.out.println("s_3 == s_4: " + (s3 == s4));

        // operadores lógicos
        int a1 = 5;
        int b1 = -1;
        System.out.println(a1 > b1 && b1 < 0); // true
        System.out.println(b1 > 0 || a1 > b1); // true
        System.out.println(!(b1 > 0)); // true
    }
}