package CompanyUtils;

import java.util.ArrayList;

public class CompanyRegistry {
    ArrayList<ClientOrders> clientsAgenda= new ArrayList<ClientOrders>();
    Integer numberOfSimplex=0;
    Integer numberOfComplex=0;


    public ArrayList<ClientOrders> getClientsAgenda() {
        return clientsAgenda;
    }

    public void setClientsAgeda(ArrayList<ClientOrders> clientsAgenda) {
        this.clientsAgenda = clientsAgenda;
    }

    public Integer getNumberOfSimplex() {
        return numberOfSimplex;
    }

    public void setNumberOfSimplex(Integer numberOfSimplex) {
        this.numberOfSimplex = numberOfSimplex;
    }

    public Integer getNumberOfComplex() {
        return numberOfComplex;
    }

    public void increaseNumberOfComplex(){
        this.numberOfComplex++;
    }
    public void increasNumberOfSimplex(){
        this.numberOfSimplex++;
    }
    public void setNumberOfComplex(Integer numberOfComplex) {
        this.numberOfComplex = numberOfComplex;
    }
}
