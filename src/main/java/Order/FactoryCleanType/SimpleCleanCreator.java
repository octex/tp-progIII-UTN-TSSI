package Order.FactoryCleanType;

public class SimpleCleanCreator extends CleanCreator{

    @Override
    public Clean createClean() {
        return new SimpleClean();
    }
}
