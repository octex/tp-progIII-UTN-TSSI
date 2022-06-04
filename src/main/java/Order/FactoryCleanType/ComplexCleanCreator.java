package Order.FactoryCleanType;

public class ComplexCleanCreator extends CleanCreator{
    public ComplexCleanCreator() {
    }

    @Override
    public CleanInterface createClean() {
        return new ComplexClean();
    }
}
