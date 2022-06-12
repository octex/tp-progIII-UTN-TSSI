package Order.FactoryCleanType;




import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

class CleanTypeSelectorTest {
    public CleanData cleanData;




    @BeforeEach
    void setUp() throws ParseException {
        CleanTypeSelector cleanTypeSelector =CleanTypeSelector.getInstance();

        CleanTypeSelector.getInstance();
        String date ="2022-06-10";

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
    void doesNotContainMudFalse(){
        cleanData.getResiduos().add("Barro");
        assertFalse(CleanTypeSelector.doesNotContainMud(cleanData.residuos));
    }
    @Test
    void doesNotContainMudOk(){
        cleanData.getResiduos().remove("Barro");
        assertTrue(CleanTypeSelector.doesNotContainMud(cleanData.residuos));
    }
    @Test
    void recentlyCleanedOk(){
        cleanData.setLastCleanDate("2022-06-10");
        String currentDate = "2022-06-12";
        assertTrue(CleanTypeSelector.recentlyCleaned(currentDate,cleanData.lastCleanDate));
    }

    @Test
    void recentlyCleanedFalse(){
        cleanData.setLastCleanDate("2022-04-10");
        String currentDate = "2022-06-12";
        assertFalse(CleanTypeSelector.recentlyCleaned(currentDate,cleanData.lastCleanDate));
    }

    @Test
    void isEmptyOk(){
        cleanData.getResiduos().remove("Polvo");
        assertTrue(CleanTypeSelector.hasJustPolvoOrEmpty(cleanData.residuos));

    }
    @Test
    void returnsSimpleOk(){


        assertEquals(CleanType.SIMPLE,CleanTypeSelector.createCleanType(cleanData));

    }
    @Test
    void returnsSimpleWithMultipleDogsBecauseOfJustDustOk(){
        cleanData.setCantMascotas(5);
        assertEquals(CleanType.SIMPLE,CleanTypeSelector.createCleanType(cleanData));
    }
    @Test
    void returnsSimpleWith2MaterialsBecauseOfDate(){
        cleanData.getResiduos().add("Barro");
        cleanData.setCantMascotas(5);
        assertEquals(CleanType.SIMPLE,CleanTypeSelector.createCleanType(cleanData));
    }


    @Test
    void returnsComplexBecauseNotSimpleWithBarro(){
        cleanData.setLastCleanDate("2021-05-19");
        cleanData.getResiduos().add("Barro");
        cleanData.setCantMascotas(5);
        assertEquals(CleanType.COMPLEJA,CleanTypeSelector.createCleanType(cleanData));
    }
    @Test
    void returnsComplexBecauseNotSimpleWith2Residuos(){
        cleanData.setLastCleanDate("2021-05-19");
        cleanData.getResiduos().add("Pelos");
        cleanData.setCantMascotas(5);
        assertEquals(CleanType.COMPLEJA,CleanTypeSelector.createCleanType(cleanData));
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