abstract class FiguraGeometrica {
    protected String saludo_geometrico;
    public FiguraGeometrica(String texto) {saludo_geometrico = texto;}
    protected void saludo() {System.out.println(saludo_geometrico);}
    protected abstract double area();
}
class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    Triangulo(double base,double altura){
        super("hola");
        this.base = base;
        this.altura = altura;
    }
    
    public double area() {return (base*altura)/2;}
}
public class App {
    public static void main(String[] args) {
        //Error, no se puede instanciar una clase abstracta:
        //FiguraGeometrica f = new FiguraGeometrica("hola");
        Triangulo t1 = new Triangulo(3,5);
        System.out.println(t1.area());
        System.out.println(t1.saludo_geometrico);
    }
}