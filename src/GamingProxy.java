import console.ConsoleWriter;

public class GamingProxy implements GamingEnvironment{
    private GamingEnvironment gamingEnvironment;
    private ConsoleWriter consoleWriter;

    public GamingProxy(GamingEnvironment gamingEnvironment) {
        this.gamingEnvironment = gamingEnvironment;
        this.consoleWriter = new ConsoleWriter();

    }

    @Override
    public void startSetup(String game) {
        gamingEnvironment.startSetup(game);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("Successfully started your gaming environment!");
                        consoleWriter.writeLine("\n");
                    }
                },
                7000
        );

    }

    @Override
    public void stopSetup(String game) {
        gamingEnvironment.stopSetup(game);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("Successfully shut off your gaming environment!");
                        System.exit(1);
                    }
                },
                25000
        );
    }
}
