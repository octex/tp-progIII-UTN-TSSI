package CompanyUtils;

import Client.Location;
import Order.FactoryCleanType.CleanType;
import Order.FactoryCleanType.SimpleClean;
import Robots.Surface;
import Services.Classic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Order.*;
import Client.*;
import Services.*;
//import org.mockito.internal.matchers.Or;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ContatorsTest {

    Company company;

    @BeforeEach
    void setUp() {
        company = new Company();
    }

    @Test
    void contatorInitializeComplex() {

        assertEquals(0, company.getCompanyRegistry().getNumberOfComplex());
    }
    
}
