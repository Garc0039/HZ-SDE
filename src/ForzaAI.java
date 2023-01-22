public class ForzaAI extends GameAI {

    public ForzaAI() {
        super();
    }

    @Override
    public void gatherMaterials() {
        consoleWriter.writeLine("Gathering coins through races!");
    }

    @Override
    public void buildEnvironment() {
        consoleWriter.writeLine("Buying the castle on the mountains..");
    }

    @Override
    public void attack() {
        consoleWriter.writeLine("Taking out the R34 V-Spec 2 to win some races against the enemy in the hood.");
    }

    @Override
    public void buildDefense() {
        consoleWriter.writeLine("Working on the R34 V-Spec 2 since we totaled it last time we raced it, yikes man...");
    }
}
