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

    GamingEnvironment gamingEnvironment;

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
        this.gamingEnvironment = new GamingProxy(new GamingSetup());
    }

    public void startGamingSetup() {
        gamingEnvironment.startSetup("Forza 5");
        consoleWriter.writeLine("\n");
    }

    public void stopGamingSetup() {
        gamingEnvironment.stopSetup("Forza 5");
        consoleWriter.writeLine("\n");
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

    public void startDemo() {
        consoleWriter.writeLine("Starting up movie environment \n");
        getReadyForMovie();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        consoleWriter.writeLine("\n");
                        consoleWriter.writeLine("Shutting off movie environment");
                        consoleWriter.writeLine("\n");
                        finishedMovie();

                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        consoleWriter.writeLine("\n");
                                        consoleWriter.writeLine("Starting Music environment");
                                        consoleWriter.writeLine("\n");
                                        listenToMusic();
                                        consoleWriter.writeLine("\n");

                                        new java.util.Timer().schedule(
                                                new java.util.TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        startGamingSetup();
                                                        consoleWriter.writeLine("\n");

                                                        new java.util.Timer().schedule(
                                                                new java.util.TimerTask() {
                                                                    @Override
                                                                    public void run() {
                                                                        stopGamingSetup();
                                                                        consoleWriter.writeLine("\n");
                                                                    }
                                                                },
                                                                20000
                                                        );
                                                    }
                                                },
                                                5000
                                        );
                                    }
                                },
                                2000
                        );
                    }
                },
                2000
        );
    }
}
