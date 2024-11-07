import java.io.Serializable;

public class QuizCard implements Serializable{
  private final String question;
  private final String answer;

  public QuizCard(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}
