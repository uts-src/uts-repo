interface Mascota {
    String SALUDO_INICIAL = "Holaaa!!";

    void saludarHumano(String nombre_persona);
}

// CLASE ANIMAL
abstract class Animal {

    protected String especie;

    Animal(String especie) {
        this.especie = especie;
    }

    public abstract void alimentarse();
}

// CLASE CANINO
abstract class Canino extends Animal {

    Canino(String especie) {
        super(especie);
    }

    public abstract void unirseAManada();
}

// CLASE FELINO
abstract class Felino extends Animal {

    Felino(String especie) {
        super(especie);
    }

    public abstract void acechar();
}

// CLASE PERRO
class Perro extends Canino implements Mascota {

    Perro() {
        super("Perro");
    }

    @Override
    public void alimentarse() {
        System.out.println("hola soy un perro alimentandose");
    }

    @Override
    public void saludarHumano(String nombre_persona) {
        System.out.println(Mascota.SALUDO_INICIAL + " " + especie + " saluda a " + nombre_persona);
    }

    @Override
    public void unirseAManada() {
        System.out.println("Perro se une a manada");
    }

    public void jugarConPelota() {
        System.out.println("perro juega con pelota");
    }

}

// CLASE GATO
class Gato extends Felino implements Mascota {

    Gato() {
        super("Gato");
    }

    @Override
    public void alimentarse() {
        System.out.println("hola soy un gato alimentandose");
    }

    @Override
    public void saludarHumano(String nombre_persona) {
        System.out.println(Mascota.SALUDO_INICIAL + " " + especie + " saluda a " + nombre_persona);
    }

    @Override
    public void acechar() {
        System.out.println("Gato acecha");
    }

    public void cazarRaton() {
        System.out.println("gato caza un ratón");
    }
}

//CLASE PERROROBOT
class PerroRobot implements Mascota {
    protected String nombre;

    PerroRobot(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void saludarHumano(String nombre_persona) {
        System.out.println(Mascota.SALUDO_INICIAL + " " + nombre + " saluda a " + nombre_persona);

    }

}

//Clase que inicia la ejecución del programa
public class Polimorfismo_E_Interfaces {

    public static void main(String[] args) {

        Animal[] animales = new Animal[2];
        animales[0] = new Perro();
        animales[1] = new Gato();

        for (Animal animal : animales) {
            //se aplica polimorfismo usando la clase base Animal
            animal.alimentarse();
        }

        Mascota[] mascotas = new Mascota[3];
        mascotas[0] = new Perro();
        mascotas[1] = new Gato();
        mascotas[2] = new PerroRobot("Firulais 3000");

        System.out.println("----------");
        for (Mascota mascota : mascotas) {
            //se aplica polimorfismo usando la interfaz Mascota
            mascota.saludarHumano("Pepe");
        }
    }
}
