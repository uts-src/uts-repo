package paqueteA;

// 1. Eliminar el modificador public de la clase animal y discutir que ocurre.
// 2. Agregar el nuevamente el modificador public y el modificador abstract a la calse animal y discutir que ocurre.
// 3. Eliminar el modificador abstract y agregar el modificador final a la clase animal y discutir que ocurre.
// 4. Colocar solo el modificador public a la clase Animal.
// 5. Cambiar el modificador public a private y luego a protected y luego sin modificador 
//      de los atributos nombre_animal y peso_kg, discutir que ocurre.
public class Animal {
    private int edad_meses = 0;
    public String nombre_animal;
    public float peso_kg;

    public Animal(String nombre, float peso){
        nombre_animal = nombre;
        this.peso_kg = peso;
    }

    @Override
    public String toString(){
        return "edad: "+edad_meses+ " nombre: "+nombre_animal+ " peso: "+peso_kg;
    }

    public int getEdad() {
        return edad_meses;
    }

    public void vivir_meses(int meses){
        if(meses >= 0 && meses <= 12){
            edad_meses += meses;
        }
        else{
            System.out.println("los números de meses deben estar entre cero y doce");
        }
    }
}
