abstract class FiguraGeometricaPlana {
    static private int preID = 0;
    private int id;
    public FiguraGeometricaPlana() {id= ++preID;}
    protected int getId(){return id;}
    protected abstract double area();
}
class Triangulo extends FiguraGeometricaPlana{
    private double base;
    private double altura;

    Triangulo(double base,double altura){
        super(); //en este caso puede omitirse el uso de super()
        this.base = base;
        this.altura = altura;
    }

    public double area() {return (base*altura)/2;}
}

public class App {
    public static void main(String[] args) {
        //Error, no se puede instanciar una clase abstracta:
        //FiguraGeometricaPlana f = new FiguraGeometricaPlana("hola");
        Triangulo t1 = new Triangulo(3,5);
        System.out.println("Area: "+t1.area());
        System.out.println("ID: "+t1.getId());

        Triangulo t2 = new Triangulo(7,5);
        System.out.println("Area: "+t2.area());
        System.out.println("ID: "+t2.getId());
    }
}