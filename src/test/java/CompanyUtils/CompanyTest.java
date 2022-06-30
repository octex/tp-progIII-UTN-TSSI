package CompanyUtils;

import Client.Location;
import CompanyUtils.Employees.*;
import CompanyUtils.OrderVerifyerExceptions.CouldNotVerifyOrderException;
import Order.FactoryCleanType.CleanData;
import Order.Repairs.ElectricalRepair;
import Order.Repairs.GasRepair;
import Order.Repairs.Repair;
import Robots.*;
import Services.Classic;
import Services.Exeptions.ClassicOverpassesDebtExeption;
import Services.Exeptions.EconomicOverpassesDebtExeption;
import Services.Exeptions.OverpassesDebtExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Order.*;
import Client.*;
import Services.*;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest
{
    Company company;
    PaymentModule paymentModule;
    Client testClient;
    Location location;
    Service testService;
    CleanData testCleanData;
    Order testOrder;
    ArrayList<Repair> repairs;
    ArrayList<Specialist> specialists;

    @BeforeEach
    void setUp()
    {
        ArrayList<Robot> robots = new ArrayList<>();
        Robot k311Yfu;
        Robot k311Ya;
        Robot po11h;
        Robot so31rty;
        Robot k311yfl;

        k311Yfu = new K311Y_fu();
        k311Ya = new K311Ya();
        po11h = new P011H();
        so31rty = new S031RTY();
        k311yfl = new K311Y_fl();

        robots.add(k311Yfu);
        robots.add(k311Ya);
        robots.add(po11h);
        robots.add(so31rty);
        robots.add(k311yfl);

        company = new Company(robots, new ArrayList<>(), new ArrayList<>());
        specialists = new ArrayList<>();
        paymentModule = company.getPaymentModule();
        Mockito.reset(paymentModule);

        Specialist electricalSpecialist = new Electritian(1f, "Nikola Tesla");
        Specialist gasSpecialist = new Gasist(1f, "Juan Carlos Perez Garay");

        specialists.add(electricalSpecialist);
        specialists.add(gasSpecialist);

        company.getSpecialistAssigner().setSpecialistRegister(specialists);

        location = new Location("Buenos Aires", "Olivos", "Maipu 2300");
        testClient = new Client(111111111, testService, Collections.singleton(location));
        testService = new Economic();
        testCleanData = new CleanData(LocalDate.now().toString(), new HashSet<>(), 1);
        repairs = new ArrayList<>();
    }

    @Test
    void tryToSendOrderFromClassicWithDebt() throws OverpassesDebtExeption
    {
        testService = new Classic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);

        Mockito.doThrow(new ClassicOverpassesDebtExeption("El cliente con servicio Classic supero la mora de $2000"))
                .when(paymentModule).checkClientsDebt(testClient);

        assertThrows(ClassicOverpassesDebtExeption.class , () -> {
            testClient.sendOrder(company, testOrder);
        });
    }

    @Test
    void tryToSendOrderFromEconomicThrowCouldNotVerifyOrderException() {
        testService = new Economic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);

        assertThrows(CouldNotVerifyOrderException.ServiceNotIncludedExeption.class , () -> {
            testClient.sendOrder(company, testOrder);
        });
    }

    @Test
    void tryToSendOrderFromToEconomicSuccess() {
        testService = new Economic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, false, false, Surface.PISOS);

        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
    }

    @Test
    void tryToSendOrderFromPlatinumClientSuccess()
    {
        testService = new Platinum();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, false, false, Surface.PISOS);

        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
    }

    @Test
    void tryToSendOrderFromEconomicClientWithDebt() throws OverpassesDebtExeption
    {
        testService = new Economic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, false, false, Surface.PISOS);

        Mockito.doThrow(new EconomicOverpassesDebtExeption("El cliente con servicio Economic se encuentra moroso."))
                .when(paymentModule).checkClientsDebt(testClient);

        assertThrows(EconomicOverpassesDebtExeption.class , () -> {
            testClient.sendOrder(company, testOrder);
        });
    }

    @Test
    void tryToSendOrderFromEconomicClientWithNoCleaningCredits()
    {
        testService = new Economic();
        testClient.setService(testService);

        testOrder = new Order(testClient, testCleanData, location, false, false, Surface.PISOS);

        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
        assertThrows(CouldNotVerifyOrderException.HasNoCreditsExeption.class , () -> {
            testClient.sendOrder(company, testOrder);
        });
    }

    @Test
    void tryToSendOrderFromClassicClientWithNoOrderingCredits()
    {
        testService = new Classic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);

        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
        assertThrows(CouldNotVerifyOrderException.HasNoCreditsExeption.class , () -> {
            testClient.sendOrder(company, testOrder);
        });
    }

    @Test
    void tryToSendOrderWithElectricalRepairOk()
    {
        testService = new Classic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);
        repairs.add(new ElectricalRepair(1));
        testOrder.setRepairsNeeded(repairs);
        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
    }

    @Test
    void tryToSendOrderWithGasRepairOk()
    {
        testService = new Classic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);
        repairs.add(new GasRepair(1));
        testOrder.setRepairsNeeded(repairs);
        assertDoesNotThrow(() -> testClient.sendOrder(company, testOrder));
    }

    @Test
    void tryToSendOrderWithElectricalRepairWithNoEmployeesAvailable()
    {
        testService = new Classic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);
        repairs.add(new ElectricalRepair(1));
        testOrder.setRepairsNeeded(repairs);
        company.getSpecialistAssigner().clearSpecialistRegister();

        assertThrows(NoHayEspecialistaExepcion.class, () -> testClient.sendOrder(company, testOrder));
    }

    @Test
    void tryToSendOrderWithGasRepairWithNoEmployeesAvailable()
    {
        testService = new Classic();
        testClient.setService(testService);
        testOrder = new Order(testClient, testCleanData, location, true, false, Surface.PISOS);
        repairs.add(new GasRepair(1));
        testOrder.setRepairsNeeded(repairs);
        company.getSpecialistAssigner().clearSpecialistRegister();

        assertThrows(NoHayEspecialistaExepcion.class, () -> testClient.sendOrder(company, testOrder));
    }

    @Test
    void tryToSendOrderExpectsASimpleClean()
    {

    }

    @Test
    void tryToSendOrderExpectsAComplexClean()
    {

    }
}