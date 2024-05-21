import java.math.BigDecimal;
import java.time.LocalDate;

public class SoutezniPar {
    private String jmena;
    private Integer startovniCislo;
    private BigDecimal startovne;
    private LocalDate datum;
    private Boolean divokaKarta;

    public SoutezniPar(Integer startovniCislo, String jmena, BigDecimal startovne, LocalDate datum, Boolean divokaKarta) {
        this.jmena = jmena;
        this.startovniCislo = startovniCislo;
        this.startovne = startovne;
        this.datum = datum;
        this.divokaKarta = divokaKarta;
    }
    public String getJmena() {
        return jmena;
    }

    public Integer getStartovniCislo() {
        return startovniCislo;
    }

    public BigDecimal getStartovne() {
        return startovne;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Boolean getDivokaKarta() {
        return divokaKarta;
    }

    public void setJmena(String jmena) {
        this.jmena = jmena;
    }

    public void setStartovniCislo(Integer startovniCislo) {
        this.startovniCislo = startovniCislo;
    }

    public void setStartovne(BigDecimal startovne) {
        this.startovne = startovne;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setDivokaKarta(Boolean divokaKarta) {
        this.divokaKarta = divokaKarta;
    }
}
