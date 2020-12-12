import java.math.BigInteger;

public class TermekTetel extends Termek {
    Integer mennyiseg;
    Integer ar;


    public TermekTetel(){}

    public TermekTetel(BigInteger termekId,
                       String nev,
                       Integer egysegAr,
                       Integer mennyiseg) {
        super(termekId, nev, egysegAr);
        this.mennyiseg = mennyiseg;
    }
    public Integer getMennyiseg() {
        return this.mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg=mennyiseg;
    }

    public Integer getar() {
        return this.egysegAr*this.mennyiseg;
    }

    @Override
    public String toString() {
        return "TermekTetel{" +"\n"+
                ", Termék Id=" + termekId +"\n"+
                ", név='" + nev + '\'' +"\n"+
                ", mennyiség='" + mennyiseg + '\'' +"\n"+
                "  egységár*mennyiség=" + getar() +"\n"+
                ", egysegAr=" + egysegAr +"\n"+
                ", OSSZMENNYISEG=" + OSSZMENNYISEG +"\n"+
                '}';
    }
}
