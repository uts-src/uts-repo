import javax.swing.JComboBox;

public class GetComboItem {
  public static void main(String[] argv) throws Exception {
    String[] items = { "item1", "item2", "item3" };
    JComboBox<String> cb = new JComboBox<String>(items);

    // Obtener la cantidad de elementos del combobox
    int num = cb.getItemCount();

    // Bucle que recorre todos los elementos del combobox
    // y los imprime en la terminal.
    for (int i = 0; i < num; i++) {
      String item = cb.getItemAt(i);
      System.out.println(item);
    }
  }
}