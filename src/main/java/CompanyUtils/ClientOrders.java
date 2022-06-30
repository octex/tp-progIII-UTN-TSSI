package CompanyUtils;

import Client.Client;
import Order.Order;

import java.util.ArrayList;

public class ClientOrders {
    Client client;
    ArrayList<Order> clientOrders;

    public ClientOrders(){


    }

    public ClientOrders(Client client, ArrayList<Order> clientOrders) {
        this.client = client;
        this.clientOrders = clientOrders;
    }

    float calculateClientTotal(){

        float sum = 0;
        for(int i = 0; i < clientOrders.size(); i++){
            sum += clientOrders.get(i).getOrderPrice();

    }
        return sum;

    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Order> getClientOrders() {
        return clientOrders;
    }
    public ClientOrders getRegistry(){
        return this;
    }

    public void setClientOrders(ArrayList<Order> clientOrders) {
        this.clientOrders = clientOrders;
    }
}
