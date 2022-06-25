package SpecialistAssigner;

import CompanyUtils.Company;
import CompanyUtils.Employees.*;
import CompanyUtils.PriceUtils.PriceCalculator;
import Order.FactoryCleanType.CleanData;
import Order.FactoryCleanType.CleanTypeSelector;
import Order.FactoryCleanType.ComplexClean;
import Order.FactoryCleanType.SimpleClean;
import Order.Order;
import Order.Repairs.ElectricalRepair;
import Order.Repairs.GasRepair;
import Order.Repairs.Repair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import CompanyUtils.Company;
import CompanyUtils.PriceUtils.PriceCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;
import java.util.HashSet;

public class SpecialistTest {

    private SpecialistRegister specialistRegister = SpecialistRegister.getInstance();
    private SpecialistAssigner specialistAssigner = new SpecialistAssigner();
    private ArrayList<Repair> repairList = new ArrayList<Repair>();
    private Order order= new Order();
    private Specialist electritian= new Electritian(5,"Bruno");
    private Specialist gasist= new Gasist(5,"Bruno");
    @BeforeEach
    void setUp() throws ParseException {


    }


    @Test
    void getElectricianOk(){

        SpecialistRegister.addSpecialist(electritian);
        repairList.add(new ElectricalRepair(5));
        order.setRepairsNeeded(repairList);
        specialistAssigner.iterateOrder(order);

       assertEquals(order.getSpecialistsAssigned().get(0).getClass(),electritian.getClass());
    }

    @Test
    void getGasistOk(){

        SpecialistRegister.addSpecialist(gasist);
        repairList.add(new GasRepair(5));
        order.setRepairsNeeded(repairList);
        specialistAssigner.iterateOrder(order);
        assertEquals(order.getSpecialistsAssigned().get(0).getClass(),gasist.getClass());

    }

 @Test
    void getGasistAndElectricianOk(){
        SpecialistRegister.addSpecialist(electritian);
        SpecialistRegister.addSpecialist(gasist);
        repairList.add(new GasRepair(5));
        repairList.add(new ElectricalRepair(5));
        order.setRepairsNeeded(repairList);
        specialistAssigner.iterateOrder(order);
        boolean validation1= order.getSpecialistsAssigned().get(0).getClass()== gasist.getClass();
        boolean validation2= order.getSpecialistsAssigned().get(1).getClass()== electritian.getClass();
        assertTrue(validation1 && validation2);

    }
    @Test
    void getElectricianAndGasistOk(){
        SpecialistRegister.addSpecialist(gasist);
        SpecialistRegister.addSpecialist(electritian);
        repairList.add(new GasRepair(5));
        repairList.add(new ElectricalRepair(5));
        order.setRepairsNeeded(repairList);
        specialistAssigner.iterateOrder(order);
        boolean validation2= order.getSpecialistsAssigned().get(0).getClass()== gasist.getClass();
        boolean validation1= order.getSpecialistsAssigned().get(1).getClass()== electritian.getClass();
        assertTrue(validation1 && validation2);
    }

    /*@Test

    void getElectricianAndGasistFailNoGasist(){

        SpecialistRegister.addSpecialist(electritian);
        SpecialistRegister.addSpecialist(electritian);
        repairList.add(new GasRepair(5));
        repairList.add(new ElectricalRepair(5));
        order.setRepairsNeeded(repairList);


        assertThrows(NoHayEspecialistaExepcion.class, () -> {
            specialistAssigner.iterateOrder(order);
        });

}
*/

    @Test
    void noAvailableGasist(){

        SpecialistRegister.addSpecialist(electritian);
        repairList.add(new GasRepair(5));
        order.setRepairsNeeded(repairList);


        assertThrows(NoHayEspecialistaExepcion.class, () -> {
            specialistAssigner.getRequiredSpecialist(order.getRepairsNeeded().get(0));
        });

    }


    @Test
    void noAvailableElectritian(){

        SpecialistRegister.addSpecialist(gasist);
        repairList.add(new ElectricalRepair(5));
        order.setRepairsNeeded(repairList);

        assertThrows(NoHayEspecialistaExepcion.class, () -> {
            specialistAssigner.getRequiredSpecialist(order.getRepairsNeeded().get(0));
        });

    }
}
