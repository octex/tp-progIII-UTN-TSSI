package Order.FactoryCleanType;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class CleanTypeSelector {

    private static CleanTypeSelector single_instance = null;

    private CleanTypeSelector()
    {

    }
    public static CleanTypeSelector getInstance()
    {
        if (single_instance == null)
            single_instance = new CleanTypeSelector();

        return single_instance;
    }

    protected static boolean hasJustPolvoOrEmpty(HashSet<String> residuos){
        return ((residuos.contains("Polvo") && residuos.size()==1)||(residuos.isEmpty()));
    }

    protected static boolean numberOfPetsSimple(Integer cantMascotas){
        return cantMascotas<2;
    }

    protected static int daysFromLastClean(String currentDate,String lastCleanDate){
        //Parsing the date
        LocalDate dateAfter = LocalDate.parse(currentDate);
        LocalDate dateBefore = LocalDate.parse(lastCleanDate);
        long daysDifference = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        return (int) daysDifference;
    }
    protected static boolean recentlyCleaned(String currentDate,String lastCleanDate){
        return daysFromLastClean(currentDate, lastCleanDate) < 15;
    }

    protected static boolean doesNotContainMud(HashSet<String> residuos){
        return (!residuos.contains("Barro"));
    }


    public static CleanType createCleanType(CleanData cleanData) {
        String currentDate="2022-06-12";
        if((hasJustPolvoOrEmpty(cleanData.residuos)||
                (doesNotContainMud(cleanData.residuos)) && numberOfPetsSimple(cleanData.cantMascotas))||
                (recentlyCleaned(currentDate,cleanData.lastCleanDate))){
            return CleanType.SIMPLE;
        }
        return CleanType.COMPLEJA;
    }


}
