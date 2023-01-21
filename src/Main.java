public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();

        //facade.getReadyForMovie();
        //facade.finishedMovie();
        //facade.listenToMusic();
        //facade.doneListeningToMusic();
        //facade.listenToRadio();
        //facade.doneListenToRadio();

        facade.singleton();
    }
}
