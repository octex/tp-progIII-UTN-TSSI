package Order.FactoryCleanType;

public class ComplexCleanCreator extends CleanCreator{
    public ComplexCleanCreator() {
    }

    @Override
    public CleanType createClean() {
        return new ComplexClean();
    }
}
