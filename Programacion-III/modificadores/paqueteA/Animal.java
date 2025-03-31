package paqueteA;

public class Animal {
    private int atr_privado = 10;
    public int atr_publico = 20;
    protected int atr_protegido = 30;

    public void mostrar(){
        System.out.println("atr_privado: "+atr_privado+
        " atr_publico: "+atr_publico+
        " atr_protegido: "+atr_protegido);
    } 
}
