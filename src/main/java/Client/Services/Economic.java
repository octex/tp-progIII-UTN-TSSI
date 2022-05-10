package Client.Services;

public class Economic extends Service {
    @Override
    public void setCleaningPerMonth(int cleaningPerMonth) {
        super.setCleaningPerMonth(cleaningPerMonth);
    }

    public Economic()
      {
            super(5000,10000);
        }


    
}