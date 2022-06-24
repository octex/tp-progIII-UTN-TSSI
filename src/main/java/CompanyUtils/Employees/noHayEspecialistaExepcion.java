package CompanyUtils.Employees;

public class noHayEspecialistaExepcion extends Exception{

    private final String message;

    public noHayEspecialistaExepcion(String message) {
        this.message = message;
    }
}
