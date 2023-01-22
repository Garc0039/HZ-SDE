import console.ConsoleWriter;

public abstract class GameAI {
    protected ConsoleWriter consoleWriter;
    public GameAI() {
        consoleWriter = new ConsoleWriter();
        Gameloop();
    }

    public void Gameloop() {
        gatherMaterials();
        buildEnvironment();
        buildDefense();
        attack();
    }

    public abstract void gatherMaterials();
    public abstract void buildEnvironment();
    public abstract void attack();
    public abstract void buildDefense();
}
