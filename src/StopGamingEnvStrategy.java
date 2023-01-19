import console.ConsoleWriter;

public class StopGamingEnvStrategy implements Strategy{
    @Override
    public void execute() {
        GamingEnvironment gamingEnvironment = new GamingProxy(new GamingSetup());
        ConsoleWriter consoleWriter = new ConsoleWriter();

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        gamingEnvironment.stopSetup("Forza 5");
                        consoleWriter.writeLine("\n");
                    }
                },
                20000
        );
    }
}
