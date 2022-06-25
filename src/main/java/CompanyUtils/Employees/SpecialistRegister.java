package CompanyUtils.Employees;

import java.util.ArrayList;

public class SpecialistRegister {

    public static ArrayList<Specialist> getSpecialists() {
        return specialists;
    }

    public static void setSingle_instance(SpecialistRegister single_instance) {
        SpecialistRegister.single_instance = single_instance;
    }

    static ArrayList<Specialist> specialists= new ArrayList<Specialist>();
    private static SpecialistRegister single_instance = null;

    public static SpecialistRegister getInstance() {
        if (single_instance == null)
            single_instance = new SpecialistRegister();

        return single_instance;

    }

    public static void addSpecialist(Specialist specialist){
        specialists.add(specialist);
    }


    public static void setSpecialists(ArrayList<Specialist> specialists) {
        SpecialistRegister.specialists = specialists;
    }

    public static SpecialistRegister getSingle_instance() {
        return single_instance;
    }
}

