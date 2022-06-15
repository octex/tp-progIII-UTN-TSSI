package Order;

public abstract class Repair
{
    protected int complexity;
    protected float cost;

    public Repair(int complexity)
    {
        this.complexity = complexity;
    }

    public int getComplexity() { return complexity; }

    public float getCost() { return cost; }

}
