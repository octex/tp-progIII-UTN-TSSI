package Order.FactoryCleanType;

public class ComplexCleanCreator extends CleanCreator{
    public ComplexCleanCreator() {
    }

    @Override
    public Clean createClean() {
        return new ComplexClean();
    }
}
