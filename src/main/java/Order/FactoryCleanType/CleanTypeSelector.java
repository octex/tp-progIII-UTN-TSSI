package Order.FactoryCleanType;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class CleanTypeSelector {
    CleanData cleanData;

    public CleanTypeSelector(CleanData cleanData) {
        this.cleanData = cleanData;
    }

    private boolean hasMultipleResiduos(){
        return this.cleanData.residuos.size()>2;
    }
    private boolean contieneBarro(){
        return  this.cleanData.residuos.contains("Barro");
    }
    private boolean numberOfPetsComplex(){
        return this.cleanData.cantMascotas>1;
    }

    private int daysFromLastClean(){
        return (int) ChronoUnit.DAYS.between((Temporal) cleanData.lastCleanDate, (Temporal) cleanData.lastCleanDate);
    }


    private boolean recentlyCleaned(){
        return daysFromLastClean() < 3;

    }

    private boolean longTimeFromLastClean(){
        return daysFromLastClean() > 30;

    }
}
