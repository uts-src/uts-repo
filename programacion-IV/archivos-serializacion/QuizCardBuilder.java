import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder{
  private ArrayList<QuizCard> cardList = new ArrayList<>();
  private JTextArea question;
  private JTextArea answer;
  private JFrame frame;

  public static void main(String[] args) {
    new QuizCardBuilder().go();
  }

  public void go() {
    frame = new JFrame("Quiz Card Builder");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

    question = createTextArea(bigFont);
    JScrollPane qScroller = createScroller(question);

    answer = createTextArea(bigFont);
    JScrollPane aScroller = createScroller(answer);

    mainPanel.add(new JLabel("Question:"));
    mainPanel.add(qScroller);

    mainPanel.add(new JLabel("Answer:"));
    mainPanel.add(aScroller);

    JButton nextButton = new JButton("Next Card");
    nextButton.addActionListener(e -> nextCard());
    mainPanel.add(nextButton);

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");

    JMenuItem newMenuItem = new JMenuItem("Nuevo");
    newMenuItem.addActionListener(e -> clearAll());

    JMenuItem saveMenuItem = new JMenuItem("Guardar Archivo");
    saveMenuItem.addActionListener(e -> saveCard());

    JMenuItem saveBinarioItem = new JMenuItem("Guardar Archivo Binario");
    saveBinarioItem.addActionListener(e -> saveSerializeCard());

    fileMenu.add(newMenuItem);
    fileMenu.add(saveMenuItem);
    fileMenu.add(saveBinarioItem);
    menuBar.add(fileMenu);
    frame.setJMenuBar(menuBar);

    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 600);
    frame.setVisible(true);
  }

  private JScrollPane createScroller(JTextArea textArea) {
    JScrollPane scroller = new JScrollPane(textArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    return scroller;
  }

  private JTextArea createTextArea(Font font) {
    JTextArea textArea = new JTextArea(6, 20);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(font);
    return textArea;
  }

  private void nextCard() {
    QuizCard card = new QuizCard(question.getText(), answer.getText());
    cardList.add(card);
    clearCard();
  }

  private void saveCard() {
    JFileChooser fileSave = preSaveCard();
    saveFile(fileSave.getSelectedFile());
  }

  private void saveSerializeCard() {
    JFileChooser fileSave = preSaveCard();
    saveSerializeFile(fileSave.getSelectedFile());
  }

  private JFileChooser preSaveCard() {
    QuizCard card = new QuizCard(question.getText(), answer.getText());
    cardList.add(card);

    JFileChooser fileSave = new JFileChooser();
    fileSave.showSaveDialog(frame);

    return fileSave;
  }

  private void clearAll() {
    cardList.clear();
    clearCard();
  }

  private void clearCard() {
    question.setText("");
    answer.setText("");
    question.requestFocus();
  }

  private void saveFile(File file) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      for (QuizCard card : cardList) {
        writer.write(card.getQuestion() + "/");
        writer.write(card.getAnswer() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
  }

  private void saveSerializeFile(File file){
    try {
      FileOutputStream f = new FileOutputStream(file); //flujo(stream) de Bytes a un archivo.
      ByteArrayOutputStream bos = new ByteArrayOutputStream(); // Almacena un flujo(stream) de bytes.
      ObjectOutputStream o = new ObjectOutputStream(bos);// donde almacenar el flujo de bytes del objeto/objetos.
      o.writeObject(cardList); // serializar objetos en un flujo de bytes.
      o.close();

      byte[] serializedBytes = bos.toByteArray(); //flujo(stream) de Bytes a un array de bytes
      
      f.write(serializedBytes); //escribir el array de bytes al archivo
      f.close();
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
  }
  
}