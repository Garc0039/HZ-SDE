import console.ConsoleWriter;

public interface Builder {
    default void booting() {
        new ConsoleWriter().writeLine("Booting your device");
    };

    default void shuttingOff() {
        new ConsoleWriter().writeLine("Booting your device");
    };
}
