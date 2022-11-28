import java.util.ArrayList;
import java.util.Arrays;

public class BooleanAdapter{
    private String[] answers = {"true", "yes", "oh yeah", "great", "sure", "love to", "of course", "always", "never done otherwise"};
    private ArrayList<String> answerList = new ArrayList<String>();
    private ConsoleReader consoleReader;

    public BooleanAdapter(ConsoleReader consoleReader, String[] additionalAnswers) {
        answerList.addAll(Arrays.asList(answers));
        answerList.addAll(Arrays.asList(additionalAnswers));
        this.consoleReader = consoleReader;
    }

    public BooleanAdapter(ConsoleReader consoleReader) {
        answerList.addAll(Arrays.asList(answers));
        this.consoleReader = consoleReader;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public boolean checkAnswer() {
        // this line reads the cmd and stores the written value by the user
        String line = consoleReader.readLine();
        // this line checks if the line var is inside the list of all possible answers
        return answerList.contains(line);
    }
}
