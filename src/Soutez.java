import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Soutez {
    private String nazev;
    private Boolean dokonceno;
    private SoutezniPar vitez;
    private List<SoutezniPar> seznam = new ArrayList<>();

    public Soutez(String nazev, List<SoutezniPar> seznam){
        this.nazev = nazev;
        this.seznam = seznam;
        this.dokonceno = false;
        this.vitez = null;

    }

    public Boolean getDokonceno() {
        return dokonceno;
    }

    public BigDecimal startvneCelkem(){
        BigDecimal dohromadyStartovne = BigDecimal.valueOf(0.0);
        for(SoutezniPar par : seznam){
            dohromadyStartovne = dohromadyStartovne.add(par.getStartovne());
        }
        return dohromadyStartovne;
    }

    public int pocetDivokychKaret(List<SoutezniPar> seznam){
        return  seznam.size();
    }
}
