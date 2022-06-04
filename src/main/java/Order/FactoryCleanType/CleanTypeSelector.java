package Order.FactoryCleanType;

import Order.FactoryCleanType.CleanTypeExeptions.NoEncajaEnNingunaLimpiezaExeption;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashSet;

public class CleanTypeSelector {

    private static CleanTypeSelector single_instance = null;

    ComplexCleanCreator complexCleanCreator=new ComplexCleanCreator();
    SimpleCleanCreator simpleCleanCreator = new SimpleCleanCreator();
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

    protected static int daysFromLastClean(Date lastCleanDate){
        return (int) ChronoUnit.DAYS.between((Temporal) lastCleanDate, (Temporal) lastCleanDate);
    }
    protected static boolean recentlyCleaned(Date lastCleanDate){
        return daysFromLastClean( lastCleanDate) < 3;
    }


    protected static boolean longTimeFromLastClean(Date lastCleanDate){
        return daysFromLastClean(lastCleanDate) > 30;
    }

    public static CleanType selectCleanType(CleanData cleanData) {

        if(hasJustPolvoOrEmpty(cleanData.residuos)||numberOfPetsSimple(cleanData.cantMascotas) /*||recentlyCleaned(cleanData.lastCleanDate)*/){

                return CleanType.SIMPLE;

        }else if(/*longTimeFromLastClean(cleanData.lastCleanDate)||*/!numberOfPetsSimple(cleanData.cantMascotas)||!hasJustPolvoOrEmpty(cleanData.residuos)){
            return CleanType.COMPLEJA;
        }
        return CleanType.COMPLEJA;
    }


}
