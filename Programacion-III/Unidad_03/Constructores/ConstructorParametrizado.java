class Persona {
    private String nombre;
    private int edad;

    // Constructor explicito con parámetros:
    public Persona(String nombre, int edad) {
        this.nombre = nombre + " de Gómez";
        boolean edad_validad = setEdad(edad);
        if (!edad_validad) {
            throw new IllegalArgumentException("la edad debe estar entre 1 y 100");
        }
    }

    public boolean setEdad(int edad) {
        if (edad > 0 && edad <= 100) { this.edad = edad; return true;}
        else {return false;}
    }
}

public class ConstructorParametrizado {
    public static void main(String[] args) {
        Persona p1 = new Persona("Luisa", 6);
        Persona p2 = new Persona();//Error el constructor por defecto ya no está disponible.
    }
}
