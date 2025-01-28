import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(); 
        ArrayList<String> nombres = new ArrayList<>();

        numeros.add(30);
        numeros.add(10);
        numeros.add(20);
        numeros.add(50);
        numeros.add(50);
        numeros.add(40);

        nombres.add("Pepe");
        nombres.add("Pepe");
        nombres.add("Alberto");
        nombres.add("Sofia");
        nombres.add("Lucia");
        nombres.add("Camila");
        nombres.add("Luis");
        nombres.add("Xavier");

        // Streams con datos númericos:
        System.out.println("----Streams con datos númericos: ");
        
        // Stream<Integer> numeros_stream = numeros.stream();
        // int suma_total = numeros_stream.reduce(0,Integer::sum);
        // System.out.println(suma_total);

        int suma_total = numeros.stream().reduce(0,Integer::sum);
        System.out.println("suma_total :"+ suma_total);

        System.out.print("\nnumeros ordenados de menor a mayor : ");
        numeros.stream().sorted().forEach(n -> System.out.print(n + " "));

        System.out.print("\nnumeros ordenados de mayor a menor: ");
        numeros.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n+" "));

        System.out.print("\nnumeros multiplicados por 2: \n");
        numeros.stream().map(n -> n *2).forEach(System.out::println);

        System.out.print("numeros filtrados: \n");
        numeros.stream().filter(n -> n> 40).forEach(System.out::println);

        System.out.print("numeros no repetidos: \n");
        numeros.stream().distinct().forEach(n -> System.out.print(n+" "));


        // Streams con datos tipo texto:
        System.out.println("\n\n----Streams con datos tipo texto");

        String concatenados = nombres.stream().reduce("",String::concat);
        System.out.println("texto concatenado :"+ concatenados);

        System.out.print("\nnombres ordenados naturalmente: ");
        nombres.stream().sorted(Comparator.naturalOrder()).forEach(n -> System.out.print(n + " "));

        System.out.print("\n\nnombres ordenados inversamente: ");
        nombres.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n+" "));

        System.out.print("\n\nnombres en mayusculas: \n");
        nombres.stream().map(n -> n.toUpperCase()).forEach(System.out::println);

        System.out.print("\nnombres filtrados: \n");
        nombres.stream().filter(n -> n.startsWith("L")).forEach(System.out::println);

        System.out.print("\nnumeros no repetidos: \n");
        nombres.stream().distinct().forEach(n -> System.out.print(n+" "));
        
        
        System.out.println();
    }
}