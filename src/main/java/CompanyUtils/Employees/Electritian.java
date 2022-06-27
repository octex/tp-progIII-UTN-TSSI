package CompanyUtils.Employees;

public class Electritian implements Specialist {

    float salary;
    String name;

    public float getSalary() {
        return salary;
    }

    @Override
    public void repair() {

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
