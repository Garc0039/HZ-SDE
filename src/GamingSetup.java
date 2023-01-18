import console.ConsoleWriter;

public class GamingSetup implements GamingEnvironment{
    GamingSetupBuilder builder;
    ConsoleWriter consoleWriter;

    public GamingSetup() {
        this.builder = new GamingSetupBuilder();
        this.consoleWriter = new ConsoleWriter();
    }

    @Override
    public void startSetup(String game) {
        builder.booting();
        builder.pluggingInMouse();
        builder.openingSteam();

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        builder.runningGame(game);
                    }
                },
                6000
        );
    }

    @Override
    public void stopSetup(String game) {
        builder.stoppingGame(game);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        builder.closingSteam();

                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        builder.shuttingOff();
                                        consoleWriter.writeLine("\n");
                                    }
                                },
                                12000
                        );
                    }
                },
                10000
        );
    }
}
