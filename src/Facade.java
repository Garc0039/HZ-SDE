import console.ConsoleReader;
import console.ConsoleWriter;

public class Facade {
    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer cdPlayer;
    Projector projector;
    TheaterLights theaterLights;
    Screen screen;
    PopcornPopper popcornPopper;
    ConsoleWriter consoleWriter;

    ConsoleReader consoleReader;

    Strategy strategy;
    public Facade() {
        this.amp = new Amplifier("Top-O-Line Amplifier");
        this.tuner = new Tuner("Top-O-Line AM/FM Tuner", amp, 69.420);
        this.dvdPlayer = new DvdPlayer("Top-O-Line DVD Player", amp, "Mike Oxmol in Isaac Desnut");
        this.cdPlayer = new CdPlayer("Top-O-Line CD Player", amp, "Mike Oxmol ft. Mike Oxlong - Hugh Jass");
        this.projector = new Projector("Top-O-Line Projector", dvdPlayer);
        this.theaterLights = new TheaterLights("Theater Ceiling Lights");
        this.screen = new Screen("Theater Screen");
        this.popcornPopper = new PopcornPopper("Popcorn Popper");
        this.consoleWriter = new ConsoleWriter();
        this.consoleReader = new ConsoleReader();
    }

    public void setStrategyAndRun(Strategy strategy) {
        this.strategy = strategy;
        this.strategy.execute();
    }

    public Facade(Amplifier amplifier, Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer, Projector projector, TheaterLights theaterLights, Screen screen, PopcornPopper popcornPopper) {
        this.amp = amplifier;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.theaterLights = theaterLights;
        this.screen = screen;
        this.popcornPopper = popcornPopper;
    }

    public void getReadyForMovie() {
        popcornPopper.on();
        popcornPopper.pop();
        theaterLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvdPlayer);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play();
    }

    public void finishedMovie() {
        popcornPopper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amp.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }

    public void listenToMusic() {
        theaterLights.on();
        amp.on();
        amp.setVolume(5);
        amp.setCd(cdPlayer);
        amp.setStereoSound();
        cdPlayer.on();
        cdPlayer.play();
    }

    public void doneListeningToMusic() {
        amp.off();
        amp.setCd(cdPlayer);
        cdPlayer.eject();
        cdPlayer.off();
    }

    public void listenToRadio() {
        tuner.on();
        tuner.setFrequency();
        amp.on();
        amp.setVolume(5);
        amp.setTuner(tuner);
    }

    public void doneListenToRadio() {
        tuner.off();
        amp.off();
    }

    public void delayedFinishedMovie() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("\n");
                        consoleWriter.writeLine("Shutting off movie environment");
                        consoleWriter.writeLine("\n");
                        finishedMovie();
                    }
                },
                2000
        );
    }

    public void delayedListeningToMusicAndQGame() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("\n");
                        consoleWriter.writeLine("Starting Music environment");
                        consoleWriter.writeLine("\n");
                        listenToMusic();
                        consoleWriter.writeLine("\n");
                        consoleWriter.writeLine("If you want to play Forza 5 type start.");
                    }
                },
                3000
        );
    }
    public void startDemo() {
        consoleWriter.writeLine("Starting up movie environment \n");
        getReadyForMovie();
        delayedFinishedMovie();
        delayedListeningToMusicAndQGame();

        String startInput = consoleReader.readLine();

        while(!startInput.equals("start")) {
            consoleWriter.writeLine("You must type start, in order to keep the demo running");
            startInput = consoleReader.readLine();
        }

        if(startInput.equals("start")) {
            setStrategyAndRun(new StartGamingEnvStrategy());

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            consoleWriter.writeLine("If you want to stop playing Forza 5 type stop.");
                        }
                    },
                    18000
            );

            String stopInput = consoleReader.readLine();

            while(!stopInput.equals("stop")) {
                consoleWriter.writeLine("You must type stop, in order to keep the demo running");
                stopInput = consoleReader.readLine();
            }

            if(stopInput.equals("stop")) {
                setStrategyAndRun(new StopGamingEnvStrategy());
            }
        }
    }

    public void singleton() {
        Database database = Database.getInstance();
        String input;

        while(true) {
            consoleWriter.writeLine("Welcome to our dictionary!");
            consoleWriter.writeLine("Would you like to add or check words? If you change your mind please type .swtich! If you want to stop type .finish!");
            input = consoleReader.readLine();
            if(input.equals("add")) {
                consoleWriter.writeLine("What word would you like to save to our database?");
                input = consoleReader.readLine();
                if(input.equals(".finish")){
                    break;
                }
                if(input.equals(".switch")) {
                    consoleWriter.writeLine("What word would you like to check in our database?");
                    input = consoleReader.readLine();
                    if(input.equals(".finish")){
                        break;
                    }
                    database.checkIfAvailable(input);
                    continue;
                }
                database.addWordToArray(input);
            }
            if(input.equals("check")) {
                consoleWriter.writeLine("What word would you like to check in our database?");
                input = consoleReader.readLine();
                if(input.equals(".finish")){
                    break;
                }
                if(input.equals(".switch")) {
                    consoleWriter.writeLine("What word would you like to add to our database?");
                    input = consoleReader.readLine();
                    if(input.equals(".finish")){
                        break;
                    }
                    database.addWordToArray(input);
                    continue;
                }
                database.checkIfAvailable(input);
            }
            if(input.equals(".finish")){
                break;
            }
        }
    }
}
