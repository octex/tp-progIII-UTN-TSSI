package Robots;

import CompanyUtils.Company;

public class CommunicationModuleEmisor {

    private Company company;

    public void readyMessage(boolean isReady){
        company.reciveMessage(isReady);
    }
    
}
