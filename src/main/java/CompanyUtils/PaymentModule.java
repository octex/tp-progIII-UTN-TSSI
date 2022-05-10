package CompanyUtils;
import org.mockito.Mockito.*;

import Client.Client;

public interface PaymentModule {

    public float getDebt(Client client);

}
