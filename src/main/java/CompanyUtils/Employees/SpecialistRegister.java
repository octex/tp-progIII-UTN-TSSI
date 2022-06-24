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
            loadSpecialists();
        return single_instance;

    }

    public static void loadSpecialists(){

        Specialist empleado1Gas = new Gasist(1000,"Octavio Gurnik");
        Specialist empleado2Gas = new Gasist(1000,"Maximo Magaldi");
        Specialist empleado3Gas = new Gasist(1000,"Bruno Mirocznyk");
        Specialist empleado1Electricidad = new Electritian(1000,"Octavio Gurnik");
        Specialist empleado2Electricidad = new Electritian(1000,"Maximo Magaldi");
        Specialist empleado3Electricidad = new Electritian(1000,"Bruno Mirocznyk");

        specialists.add(empleado1Electricidad);
        specialists.add(empleado2Electricidad);
        specialists.add(empleado3Electricidad);
        specialists.add(empleado1Gas);
        specialists.add(empleado2Gas);
        specialists.add(empleado3Gas);
    }


}

