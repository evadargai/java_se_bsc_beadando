
import javax.swing.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Rendeles  {
    BigInteger        rendelesId;
    String            userName;
    Date              megrendelesDatum;
    RendelesStatus    rendelesStatus;
    List<TermekTetel> tetelList;
    FizetesModja      fizetesModja;
    KezbesitesModja   kezbesitesModja;
    SzallitasModja    szallitasModja;
    String            megjegyzes;
    public Rendeles(){
    }
    public Rendeles(BigInteger rendelesId,
                    String userName,
                    Date megrendelesDatum,
                    FizetesModja fizetesModja,
                    KezbesitesModja kezbesitesModja)
    {
        this.rendelesId       = rendelesId;
        this.userName         = userName;
        this.megrendelesDatum = megrendelesDatum;
        this.fizetesModja     = fizetesModja;
        this.kezbesitesModja  = kezbesitesModja;
    }

    public Rendeles(BigInteger rendelesId,
                    String userName,
                    Date megrendelesDatum,
                    List<TermekTetel> tetelList,
                    FizetesModja fizetesModja,
                    KezbesitesModja kezbesitesModja,
                    SzallitasModja szallitasModja,
                    String megjegyzes) {

        this.rendelesId = rendelesId;
        this.userName = userName;
        this.megrendelesDatum = megrendelesDatum;
        this.tetelList = tetelList;
        this.fizetesModja = fizetesModja;
        this.kezbesitesModja = kezbesitesModja;
        this.szallitasModja = szallitasModja;
        this.megjegyzes = megjegyzes;
    }

    public Rendeles(String userName){ this.userName=userName;}


    public BigInteger getRendelesId() {
        return rendelesId;
    }

    public void setRendelesId(BigInteger rendelesId) {
        this.rendelesId = rendelesId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getMegrendelesDatum() {
        return megrendelesDatum;
    }

    public void setMegrendelesDatum(Date megrendelesDatum) {
        this.megrendelesDatum = megrendelesDatum;
    }

    public Integer getAr() {
        // a rendelés ára a tételek árának összege
        int ar=0;
        for (TermekTetel rt : tetelList) {
            ar = ar + rt.getar();
        }
        return ar;
    }

    public RendelesStatus getRendelesStatus() {
        return this.rendelesStatus;
    }

    public List<TermekTetel> getTetelList() {
        return this.tetelList;
    }

    public void setTetelList(List<TermekTetel> tetelList) {
        this.tetelList = tetelList;
    }

    public FizetesModja getFizetesModja() {
        return this.fizetesModja;
    }

    public void setFizetesiModja(FizetesModja fizetesModja) {
        this.fizetesModja = fizetesModja;
    }

    public void setFizetesModja(FizetesModja fizetesModja) {
        this.fizetesModja = fizetesModja;
    }

    public KezbesitesModja getKezbesitesModja() {
        return kezbesitesModja;
    }

    public void setKezbesitesModja(KezbesitesModja kezbesitesModja) {
        this.kezbesitesModja = kezbesitesModja;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes=megjegyzes;
    }

    public SzallitasModja getSzallitasModja() {
        return szallitasModja;
    }

    public void setSzallitasModja(SzallitasModja szallitasModja) {
        this.szallitasModja = szallitasModja;
    }

    public void setUserIdDatumFizetesKezbesitesModja(String userName,
                                                     BigInteger rendelesId,
                                                     Date       megrendelesDatum,
                                                     FizetesModja fizetesModja,
                                                     KezbesitesModja kezbesitesModja){
        this.userName=userName;
        this.rendelesId=rendelesId;
        this.megrendelesDatum=megrendelesDatum;
        this.fizetesModja=fizetesModja;
        this.kezbesitesModja=kezbesitesModja;
    }

     public Felhasznalo felhasznaloKeres(String userName,
                                         List<Felhasznalo> felhasznalok) {
         if (userName == null){
             throw new IllegalArgumentException("Nincs user megadva !");
         }

         for (Felhasznalo fh : felhasznalok) {
            if (fh.userName.equals(userName)) {
                return fh;
            }
        }
        return null;
     }

    public Megrendelo megrendeloKeres(String userName,
                                      List<Megrendelo> megrendelok){
        if (userName == null){
            throw new IllegalArgumentException("Nincs user megadva !");
        }
        for (Megrendelo mr:megrendelok) {
            if (mr.userName.equals(userName)) {
                return mr;
            }
        }
        return null;
    }


    public void rendelesStatusAllitasInditaskor(Rendeles rendeles) {

        if (rendeles.kezbesitesModja == null){
            throw new IllegalArgumentException("Nincs megadva a rendelés kézbesítésének a módja !");
        }
        if (rendeles.kezbesitesModja.equals(KezbesitesModja.INPERSON)) {
            rendeles.rendelesStatus = RendelesStatus.DELIVERED;
        } else {
            rendeles.rendelesStatus = RendelesStatus.BOOKED;
        }
    }

    public TermekTetel TermekTetelHozzaadas(Termek termek,Integer mennyiseg) {
        if (termek==null){
        throw new IllegalArgumentException("Nincs megadva termék ! ");
        }
        if (mennyiseg==null){
            throw new IllegalArgumentException("Nincs megadva mennyiség ! ");
        }

         TermekTetel termekTetel= new TermekTetel();
         termekTetel.setTermekId(termek.termekId);
         termekTetel.setNev(termek.nev);
         termekTetel.setEgysegAr(termek.egysegAr);
         termekTetel.setMennyiseg(mennyiseg);
         if (termek.OSSZMENNYISEG<mennyiseg){
             //throw new IllegalArgumentException(termek.nev+" termékből a rendelhető mennyiseg max. "+termek.OSSZMENNYISEG+" db");
             System.out.println(termek.nev+" termékből a rendelhető mennyiseg max. "+termek.OSSZMENNYISEG+" db");
           }
         termekTetel.setMennyiseg(Math.min(termek.getOsszMennyiseg(),mennyiseg));
         termekTetel.setOsszMennyiseg(termek.getOsszMennyiseg()-Math.min(termek.getOsszMennyiseg(),mennyiseg));
         return termekTetel;
       }

    public void atadasFutarnak(Rendeles rendeles) {
        rendeles.rendelesStatus=RendelesStatus.IN_PROGRESS;
    }

    public void RendelesStatusAllitasSzallitaskor(Rendeles rendeles,SzallitasStatus szallitasStatus) {
        if (szallitasStatus==null){
            throw new IllegalArgumentException("Nincs megadva a szállítás státusza ! ");
        }
        {
            if (szallitasStatus.equals(SzallitasStatus.UNSUCCESSFUL)) {
                rendeles.rendelesStatus = RendelesStatus.FAILED_DELIVERY;
            }
            else
                rendeles.rendelesStatus = RendelesStatus.DELIVERED;
        }
    }
    public Megrendelo vasarlasMegrendeloig(Rendeles rendeles,
                                           String userName,
                                           String password ,
                                           FelhasznaloStatus felhasznaloStatus,
                                           List<Felhasznalo> felhasznalok,
                                           List<Megrendelo> megrendelok) {
        Felhasznalo felhasznalo = new Felhasznalo();
        if (felhasznaloStatus == FelhasznaloStatus.CUSTOMER) {
            Megrendelo megrendelo = new Megrendelo();
            Felhasznalo felhasznaloTalalt;
            felhasznaloTalalt = rendeles.felhasznaloKeres(userName, felhasznalok);
            if (felhasznaloTalalt==null) {
                felhasznalo.setUserName(userName);
                felhasznalo.setPassword(password);
                felhasznalo.setFelhasznaloStatus(felhasznaloStatus);}
            else    {
                    megrendelo = rendeles.megrendeloKeres(userName, megrendelok);
            }
            return megrendelo;
        }
       return null;
    }

    public void vasarlas(String userName,
                         String password,
                         FelhasznaloStatus felhasznaloStatus,
                         String nev,
                         String cim,
                         String email,
                         String telefon,
                         BigInteger rendelesId,
                         Date megrendelesDatum,
                         FizetesModja fizetesModja,
                         KezbesitesModja kezbesitesModja,
                         List<TermekTetel> termekTetelList,
                         SzallitasModja szallitasModja,
                         SzallitasStatus szallitasStatus,
                         String megjegyzes,
                         List<Felhasznalo> felhasznalok,
                         List<Megrendelo> megrendelok) {
        Rendeles rendeles = new Rendeles();
        Megrendelo megrendelo = new Megrendelo();
        Megrendelo talaltMegrendelo;
        talaltMegrendelo = rendeles.vasarlasMegrendeloig(rendeles,
                                                         userName,
                                                         password,
                                                         felhasznaloStatus,
                                                         felhasznalok,
                                                         megrendelok);
        // ha olyan felhasznaló lépett be, aki nem megrendelo hanem pl futár, admin, egyéb
        if (talaltMegrendelo == null) {
            // nincs kidolgozva
        } else {
            // Új megrendelő
            if (megrendelo.getUserName()==null) {
                megrendelo.setUserName(userName);
                megrendelo.setAdatok(nev,cim,email,telefon);
            }
        }
        rendeles.setUserIdDatumFizetesKezbesitesModja(userName,
                                                      rendelesId,
                                                      megrendelesDatum,
                                                      fizetesModja,
                                                      kezbesitesModja);
        // terméktétel lista létrehozása
        rendeles.setTetelList(termekTetelList);
        rendeles.rendelesStatusAllitasInditaskor(rendeles);

        if (rendeles.kezbesitesModja.equals(KezbesitesModja.ONLINE)) {
            if (szallitasModja.equals(SzallitasModja.COURIER_HOME_DELIVERY)) {
                rendeles.setSzallitasModja(szallitasModja);
                rendeles.atadasFutarnak(rendeles);
                rendeles.RendelesStatusAllitasSzallitaskor(rendeles, szallitasStatus);
                if (rendeles.rendelesStatus.equals(RendelesStatus.FAILED_DELIVERY)) {
                    rendeles.setMegjegyzes(megjegyzes);
                }
                else{
                    if (rendeles.getMegjegyzes()!=null){
                        rendeles.setMegjegyzes(null);
                        //System.out.println("A megjegyzés csak sikertelen szállításkor kitölthető !");
                        throw new IllegalArgumentException("A megjegyzés csak sikertelen szállításkor kitölthető !");
                    }
                }
            }
        }
        System.out.println(rendeles);
    }



    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
    return  "  rendelesId=" + rendelesId +"\n"+
            ", user név='" + userName +"\n"+
            ", megrendeles Dátuma=" + dateFormat.format(megrendelesDatum) +"\n"+
            ", megrendelés ár összesen=" + getAr() +"\n"+
            ", tetelList=" + tetelList +"\n"+
            ", Fizetes Módja=" + fizetesModja +"\n"+
            ", Kézbesites Módja=" + kezbesitesModja +"\n"+
            ", Szallitás Módja=" + szallitasModja +"\n"+
            ", rendelesStatus=" + rendelesStatus +"\n"+
            ", megjegyzés='" + megjegyzes + '\'' +
            '}';
    }
}











