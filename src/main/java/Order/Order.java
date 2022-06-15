package Order;

import Client.Client;
import Client.Location;
import CompanyUtils.Employees.Specialist;
import Order.FactoryCleanType.CleanData;
import Order.FactoryCleanType.CleanType;
import Robots.Robot;

import java.util.ArrayList;

public class Order {
    
    private CleanType cleanType;
    private Location location;
    private boolean wantsPolish;
    private boolean wantsOrder;
    private String surface;
    private Client client;
    private ArrayList<Robot> robots;

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    private Specialist specialist;
    private Repair repair;
    private CleanData cleanData;

    public Order(Client client, CleanType cleanType, Location location, boolean wantsOrder, String surface){
        this.client = client;
        this.cleanType = cleanType;
        this.location = location;
        this.wantsOrder = wantsOrder;
        this.surface=surface;
    }
    public void setCleanData(CleanData cleanData) {
        this.cleanData = cleanData;
    }

    public CleanData getCleanData() {
        return cleanData;
    }

    public boolean doesWantPolish() {
        return wantsPolish;
    }

    public void setWantPolish(boolean wantsPolish) {
        this.wantsPolish = wantsPolish;
    }

    public CleanType getCleanType() {
        return cleanType;
    }

    public Location getLocation() {
        return location;
    }

    public boolean doesWantOrder() {
        return wantsOrder;
    }

    public void setWantsOrder(boolean wantsOrder) {
        this.wantsOrder = wantsOrder;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Client getClient() {
        return client;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setWantsPolish(boolean wantsPolish) {
        this.wantsPolish = wantsPolish;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public ArrayList<Robot> getRobots() { return robots; }


    public Repair getReparacion() { return repair; }
}
