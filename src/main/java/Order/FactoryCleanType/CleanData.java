package Order.FactoryCleanType;

import java.util.HashSet;

public class CleanData {
    String lastCleanDate;
    HashSet<String> residuos;
    int cantMascotas;

    public CleanData(String lastCleanDate, HashSet<String> residuos, int cantMascotas) {
        this.lastCleanDate = lastCleanDate;
        this.residuos = residuos;
        this.cantMascotas = cantMascotas;
    }

    public String getLastCleanDate() {
        return lastCleanDate;
    }

    public void setLastCleanDate(String lastCleanDate) {
        this.lastCleanDate = lastCleanDate;
    }

    public HashSet<String> getResiduos() {
        return residuos;
    }

    public void setResiduos(HashSet<String> residuos) {
        this.residuos = residuos;
    }

    public int getCantMascotas() {
        return cantMascotas;
    }

    public void setCantMascotas(int cantMascotas) {
        this.cantMascotas = cantMascotas;
    }
}
