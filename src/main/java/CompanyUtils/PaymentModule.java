package CompanyUtils;
import static org.mockito.Mockito.mock;
import Client.Client;

public interface PaymentModule {

    public float getDebt(Client client);
}
