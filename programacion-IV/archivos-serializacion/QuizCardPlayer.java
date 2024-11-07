import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardPlayer {
  private ArrayList<QuizCard> cardList;
  private int currentCardIndex;
  private QuizCard currentCard;
  private JTextArea display;
  private JFrame frame;
  private JButton nextButton;
  private boolean isShowAnswer;

  public static void main(String[] args) {
    QuizCardPlayer reader = new QuizCardPlayer();
    reader.go();
  }


  public void go() {
    frame = new JFrame("Quiz Card Player");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

    display = new JTextArea(10, 20);
    display.setFont(bigFont);
    display.setLineWrap(true);
    display.setEditable(false);

    JScrollPane scroller = new JScrollPane(display);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    mainPanel.add(scroller);

    nextButton = new JButton("Mostrar preguntas");
    nextButton.addActionListener(e -> nextCard());
    mainPanel.add(nextButton);

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Archivos");

    JMenuItem loadMenuItem = new JMenuItem("Cargar archivo de texto");
    JMenuItem loadBinaryMenuItem = new JMenuItem("Cargar archivo Binario");
    loadMenuItem.addActionListener(e -> open());
    loadBinaryMenuItem.addActionListener(e -> openBinary());

    fileMenu.add(loadMenuItem);
    fileMenu.add(loadBinaryMenuItem);
    menuBar.add(fileMenu);
    frame.setJMenuBar(menuBar);

    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  private void nextCard() {
    if (isShowAnswer) {
      // show the answer because they’ve seen the question
      display.setText(currentCard.getAnswer());
      nextButton.setText("Next Card");
      isShowAnswer = false;
    } else {
      // show the next question
      if (currentCardIndex < cardList.size()) {
        showNextCard();
      } else {
        // there are no more cards!
        display.setText("That was last card");
        nextButton.setEnabled(false);
      }
    }
  }

  private void open() {
    JFileChooser fileOpen = new JFileChooser();
    fileOpen.showOpenDialog(frame);
    loadFile(fileOpen.getSelectedFile());
  }

  private void openBinary(){
    JFileChooser fileOpen = new JFileChooser();
    fileOpen.showOpenDialog(frame);
    loadBinaryFile(fileOpen.getSelectedFile());
  }

  @SuppressWarnings("unchecked")
  private void loadBinaryFile(File file){
    cardList = new ArrayList<>();
    try {
      FileInputStream fi = new FileInputStream(file); //permite operar con un flujo(stream) de Bytes desde un archivo.
      ByteArrayInputStream bis = new ByteArrayInputStream(fi.readAllBytes());// lee un array de bytes para crear y almacenar un flujo(stream) de bytes 
      fi.close();
      ObjectInputStream oi = new ObjectInputStream(bis);// lee un stream de bytes para deserializar un objeto.

      cardList = (ArrayList<QuizCard>) oi.readObject(); //creacion del objeto.

      oi.close();
      
      
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
  }

  private void loadFile(File file) {
    cardList = new ArrayList<>();
    currentCardIndex = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        makeCard(line);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
    // now time to start by showing the first card
    showNextCard();
  }

  private void makeCard(String lineToParse) {
    String[] result = lineToParse.split("/");
    QuizCard card = new QuizCard(result[0], result[1]);
    cardList.add(card);
    System.out.println("made a card");
  }

  private void showNextCard() {
    currentCard = cardList.get(currentCardIndex);
    currentCardIndex++;
    display.setText(currentCard.getQuestion());
    nextButton.setText("Show Answer");
    isShowAnswer = true;
  }
}