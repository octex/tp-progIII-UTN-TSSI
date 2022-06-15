package Order.Repairs;

public class GasRepair extends Repair
{
    public GasRepair(int complexity)
    {
        super(complexity);
        priceChart.put(RepairPriceType.BASIC, 1000f);
        priceChart.put(RepairPriceType.MEDIUM, 3530f);
        priceChart.put(RepairPriceType.COMPLEX, 6389f);
    }
}
