class Animal {
    protected String actividades_basicas = "comer, reproducirse";
    protected float peso_kg;
    protected int edad;
    public Animal(float peso,int edad) {peso_kg = peso; this.edad = edad;}
    public String mostrar_datos() {return "Peso: "+peso_kg+"\n"+"Edad: "+edad;}
}

class Perro extends Animal{
    protected String actividades_basicas = "ladrar, jugar";
    protected String nombre;
    public Perro(float peso,int edad,String nombre){super(peso, edad);this.nombre = nombre;}
    @Override
    public String mostrar_datos(){
        String datos_animal = super.mostrar_datos();
        return datos_animal+"\nnombre: "+nombre+"\nactividades: "+super.actividades_basicas+", "+actividades_basicas;
    }
}

public class PalabraReservadaSuper {
    public static void main(String[] args) {
        Animal a1 = new Animal(24.3f, 25); System.out.println("DATOS ANIMAL:");
        System.out.println(a1.mostrar_datos()); Perro p1 = new Perro(15.3f, 10, "Rocky");
        System.out.println("\nDATOS PERRO:"); System.out.println(p1.mostrar_datos());
    }
}
