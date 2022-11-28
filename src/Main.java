import java.awt.geom.NoninvertibleTransformException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        // adding new String[]{strings here} as 2nd param enables to add more words to lead to a positive answer
        BooleanAdapter booleanAdapter = new BooleanAdapter(reader, new String[]{"pepe", "yeet"});

        // ask questions
        String q1 = "Do you like eating vegetables?";

        String good = "You are a healthy person!";
        String bad = "Maybe you should try to eat some carrots";

        // ask question to user
        writer.write(q1);

        // read response
        //Boolean ans1 = reader.readLine().equals("Yep");
        // boolean answer = booleanAdapter.checkAnswer()

        //TODO
        // the reader should accept the following values as true:
        // "true", "yes", "oh yeah", "great", "sure", "love to", "of course", "always", "never done otherwise"

        // if (answer)
        if (booleanAdapter.checkAnswer()) {
            writer.write(good);
        } else {
            writer.write(bad);
        }

        // allow user to read our response
        reader.readLine();
    }
}
