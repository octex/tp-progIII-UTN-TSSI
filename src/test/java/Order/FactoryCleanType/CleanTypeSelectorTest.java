package Order.FactoryCleanType;




import Order.FactoryCleanType.CleanTypeExeptions.NoEncajaEnNingunaLimpiezaExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

class CleanTypeSelectorTest {
    public CleanData cleanData;




    @BeforeEach
    void setUp() throws ParseException {
        CleanTypeSelector.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date =sdf.parse("12/24/1994");

        HashSet <String>residuos=new HashSet();
        residuos.add("Polvo");
        cleanData=new CleanData(date,residuos,1);
    }

    @Test
    void numberOfPetsSimpleOk()
    {
        assertTrue(CleanTypeSelector.numberOfPetsSimple(cleanData.cantMascotas));
    }
    @Test
    void numberOfPetsSimpleFail()
    {
        cleanData.setCantMascotas(5);
        assertFalse(CleanTypeSelector.numberOfPetsSimple(cleanData.cantMascotas));
    }

    @Test
    void hasJustDustOk(){

        assertTrue(CleanTypeSelector.hasJustPolvoOrEmpty(cleanData.residuos));
    }

    @Test
    void hasJustDustFail(){
        cleanData.getResiduos().add("Barro");
        assertFalse(CleanTypeSelector.hasJustPolvoOrEmpty(cleanData.residuos));
    }

    @Test
    void isEmptyOk(){
        cleanData.getResiduos().remove("Polvo");
        assertTrue(CleanTypeSelector.hasJustPolvoOrEmpty(cleanData.residuos));

    }
    @Test
    void returnsSimpleOk(){


        assertEquals(CleanType.SIMPLE,CleanTypeSelector.selectCleanType(cleanData));

    }
    @Test
    void returnsSimpleWithMultipleDogsBecauseOfJustDustOk(){
        cleanData.setCantMascotas(5);

        assertEquals(CleanType.SIMPLE,CleanTypeSelector.selectCleanType(cleanData));

    }
    @Test
    void returnsComplexWithMultipleDogsAndBarroOk(){
        cleanData.getResiduos().add("Barro");
        cleanData.setCantMascotas(5);
        assertNotEquals(CleanType.COMPLEJA,CleanTypeSelector.selectCleanType(cleanData));

    }


    @Test
    void returnsComplexWithJustBarroOK(){
        cleanData.getResiduos().remove("Polvo");
        cleanData.getResiduos().add("Barro");
        cleanData.setCantMascotas(5);
        assertEquals(CleanType.COMPLEJA,CleanTypeSelector.selectCleanType(cleanData));
    }
    @Test
    void returnsComplexWithTwoOrMoreResiduosOK(){
        cleanData.getResiduos().add("Pelos");
        cleanData.setCantMascotas(5);
        assertEquals(CleanType.COMPLEJA,CleanTypeSelector.selectCleanType(cleanData));
    }
/*
    @Test
    void AssignRobotForClassicService()
    {
        System.out.println(CleanTypeSelector.daysFromLastClean(cleanData.lastCleanDate));
        assertEquals(0,CleanTypeSelector.daysFromLastClean(cleanData.lastCleanDate));
    }
    */
}