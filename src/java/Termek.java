import java.math.BigInteger;

public class Termek {
    BigInteger termekId;
    String  nev;
    Integer egysegAr;
    Integer OSSZMENNYISEG;

    public Termek() {
    }

    public Termek(BigInteger termekId,
                  String nev,
                  Integer egysegAr,
                  Integer OSSZMENNYISEG) {
        this.termekId = termekId;
        this.nev = nev;
        this.egysegAr = egysegAr;
        this.OSSZMENNYISEG = OSSZMENNYISEG;
    }
    public Termek(BigInteger termekId,
                  String nev,
                  Integer egysegAr) {
        this.termekId = termekId;
        this.nev = nev;
        this.egysegAr = egysegAr;
    }
    public Termek(BigInteger termekId) {
        this.termekId = termekId;
    }

    public BigInteger getTermekId() {

        return termekId;
    }
    public void setTermekId(BigInteger termekId) {

        this.termekId = termekId;
    }

    public String getNev() {

        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getEgysegAr() {
        return egysegAr;
    }

    public void setEgysegAr(Integer egysegAr) {
        this.egysegAr = egysegAr;
    }

    public Integer getOsszMennyiseg() {
        return OSSZMENNYISEG;
    }

    public void setOsszMennyiseg(Integer osszMennyiseg) {

        this.OSSZMENNYISEG = osszMennyiseg;
    }

    @Override
    public String toString() {
        return "Termek{" +
                "termekId=" + termekId +
                ", nev='" + nev + '\'' +
                ", egysegAr=" + egysegAr +
                ", OSSZMENNYISEG=" + OSSZMENNYISEG +
                '}';
    }
}
