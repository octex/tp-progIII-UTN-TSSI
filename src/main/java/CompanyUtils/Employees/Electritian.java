package CompanyUtils.Employees;

import Order.Order;
import Order.Repairs.Repair;

import java.util.Objects;

public class Electritian implements Specialist {

    float salary;
    String name;

    public Electritian(float salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public void repair() {

    }
    @Override
    public boolean canHandle(Repair repair) {
        return Objects.equals(repair.getType(), "Electrical");
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
