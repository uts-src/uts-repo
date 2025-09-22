package paqueteA;

class Caninos extends Animal{
    protected String raza;

    public Caninos(String nombre, float peso, String raza){
        super(nombre,peso);
        this.raza = raza;
    }
}
