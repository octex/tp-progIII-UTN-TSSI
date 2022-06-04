package Order.FactoryCleanType;

public class SimpleCleanCreator extends CleanCreator{

    @Override
    public CleanInterface createClean() {
        return new SimpleClean();
    }
}
