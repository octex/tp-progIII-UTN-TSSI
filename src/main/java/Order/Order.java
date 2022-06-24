package Order;

import Client.Client;
import Client.Location;
import CompanyUtils.Employees.Specialist;
import Order.FactoryCleanType.CleanData;
import Order.FactoryCleanType.CleanType;
import Order.Repairs.Repair;
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
    private ArrayList<Specialist> specialistsAssigned;
    private ArrayList<Repair> repairsNeeded;
    private CleanData cleanData;


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



    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    public ArrayList<Specialist> getSpecialistsAssigned() {
        return specialistsAssigned;
    }

    public void setSpecialistsAssigned(ArrayList<Specialist> specialistsAssigned) {
        this.specialistsAssigned = specialistsAssigned;
    }

    public ArrayList<Repair> getRepairsNeeded() {
        return repairsNeeded;
    }
    public void setRepairsNeeded(ArrayList<Repair> repairsNeeded) {
        this.repairsNeeded = repairsNeeded;
    }
}
