package CompanyUtils;

public class PaymentModuleMock
{
    public PaymentModuleMock()
    {

    }

    public float GetNoDebt()
    {
        return 0.0f;
    }

    public float GetDebt()
    {
        return 133.33f;
    }

    public float GetExcededDebtForClassic()
    {
        return 2000.1f;
    }

    public boolean IsPlatinumExceded()
    {
        return true;
    }
}
