import console.ConsoleWriter;

public class GamingSetupBuilder implements Builder{
    ConsoleWriter consoleWriter;

    public GamingSetupBuilder() {
        this.consoleWriter = new ConsoleWriter();
    }

    @Override
    public void booting() {
        consoleWriter.writeLine("Starting PC");
        consoleWriter.writeLine("\n");
    }

    @Override
    public void shuttingOff() {
        consoleWriter.writeLine("Shutting off PC");
        consoleWriter.writeLine("\n");
    }

    public void pluggingInMouse() {
        consoleWriter.writeLine("Plugging in mouse");
        consoleWriter.writeLine("\n");
    }

    public void openingSteam() {
        consoleWriter.writeLine("Starting Steam");
        consoleWriter.writeLine("\n");

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("Finally running Steam!");
                        consoleWriter.writeLine("\n");
                    }
                },
                5000
        );
    }

    public void runningGame(String game) {
        consoleWriter.writeLine("Running " + game + " at 360p 4000FPS");
        consoleWriter.writeLine("\n");
    }

    public void stoppingGame(String game) {
        consoleWriter.writeLine("Shutting off " + game);
        consoleWriter.writeLine("\n");
    }

    public void closingSteam() {
        consoleWriter.writeLine("Stopping Steam");

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("\n");
                        consoleWriter.writeLine("Updating Steam");
                        consoleWriter.writeLine("\n");

                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        consoleWriter.writeLine("Updated successfully");
                                    }
                                },
                                5000
                        );
                    }
                },
                5000
        );
    }
}
