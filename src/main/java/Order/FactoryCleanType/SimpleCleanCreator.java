package Order.FactoryCleanType;

public class SimpleCleanCreator extends CleanCreator{

    @Override
    public CleanType createClean() {
        return new SimpleClean();
    }
}
