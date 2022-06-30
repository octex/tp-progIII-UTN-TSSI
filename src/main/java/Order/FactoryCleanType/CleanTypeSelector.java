package Order.FactoryCleanType;

import CompanyUtils.Company;

import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.time.LocalDate;


public class CleanTypeSelector {

    private static CleanTypeSelector instance = null;
    private  Company company;
    private CleanTypeSelector(Company company)
    {
        this.company = company;
    }

    public static CleanTypeSelector getInstance(Company company)
    {
        if (instance == null)
            instance = new CleanTypeSelector(company);

        return instance;
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


    public  CleanType setCleanStrategy(CleanData cleanData) {
        String currentDate = LocalDate.now().toString();
        if((hasJustPolvoOrEmpty(cleanData.residuos)||
                (doesNotContainMud(cleanData.residuos)) && numberOfPetsSimple(cleanData.cantMascotas))||
                (recentlyCleaned(currentDate,cleanData.lastCleanDate))){
            getInstance(company).company.getPriceCalculator().setStrategy(new SimpleClean());
            this.company.getCompanyRegistry().increasNumberOfSimplex();
            return new SimpleClean();
        }
        this.company.getPriceCalculator().setStrategy(new SimpleClean());
        this.company.getCompanyRegistry().increaseNumberOfComplex();
        return new ComplexClean(company.getRobotAdjustmentFactor());
    }


    public Company getCompany() {
        return company;
    }
}
