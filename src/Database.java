import console.ConsoleWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private static Database database;

    private ConsoleWriter consoleWriter;

    private ArrayList<String> inputStrings = new ArrayList<String>();

    private String[] inputStandard = {"hi", "hello", "hoi", "yes", "no", "what", "idk", "randomText", "secret"};


    private Database() {
        this.consoleWriter = new ConsoleWriter();
        this.inputStrings.addAll(Arrays.asList(inputStandard));
    }

    public static Database getInstance() {
        if(Database.database == null) {
            Database.database = new Database();
        }

        return Database.database;
    }

    public void checkIfAvailable(String input) {
        boolean available = false;

        if(inputStrings.contains(input)) {
            consoleWriter.writeLine("yes");
            if(input.equals("secret")) {
                consoleWriter.writeLine("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            }
            available = true;
        }

        if(!available) {
            consoleWriter.writeLine("no");
        }
    }

    public void addWordToArray(String input) {
        inputStrings.add(input);
        consoleWriter.writeLine("Did it save successfully?");
        this.checkIfAvailable(input);
    }
}
