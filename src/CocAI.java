public class CocAI extends GameAI {
    public CocAI() {
        super();
    }

    @Override
    public void gatherMaterials() {
        consoleWriter.writeLine("Gathering Elixir and Gold");
    }

    @Override
    public void buildEnvironment() {
        consoleWriter.writeLine("Building Baracs and Hall");
    }

    @Override
    public void attack() {
        consoleWriter.writeLine("Using the elixir to train Barbars and sending them off to attack!");
    }

    @Override
    public void buildDefense() {
        consoleWriter.writeLine("Using the gold to upgrade our magic towers!");
    }
}
