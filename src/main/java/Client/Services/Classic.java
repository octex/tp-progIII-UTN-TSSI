package Client.Services;

public class Classic extends Service {

    @Override
    public void setOrderingPerMonth(int orderingPerMonth) {
        super.setOrderingPerMonth(3);
    }

    public Classic(){
    super(3000,3000);
    }
    
}