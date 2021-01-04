
import java.math.BigInteger;
import java.text.SimpleDateFormat;
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
                    List<TermekTetel> tetelList,
                    FizetesModja fizetesModja,
                    KezbesitesModja kezbesitesModja)
    {
        this.rendelesId       = rendelesId;
        this.userName         = userName;
        this.megrendelesDatum = megrendelesDatum;
        this.tetelList        = tetelList;
        this.fizetesModja     = fizetesModja;
        this.kezbesitesModja  = kezbesitesModja;
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
                    FizetesModja fizetesModja,
                    KezbesitesModja kezbesitesModja,
                    SzallitasModja szallitasModja)
    {
        this.rendelesId       = rendelesId;
        this.userName         = userName;
        this.megrendelesDatum = megrendelesDatum;
        this.fizetesModja     = fizetesModja;
        this.kezbesitesModja  = kezbesitesModja;
        this.szallitasModja   = szallitasModja;
    }
    public Rendeles(BigInteger rendelesId,
                    String userName,
                    Date megrendelesDatum,
                    FizetesModja fizetesModja,
                    KezbesitesModja kezbesitesModja,
                    SzallitasModja szallitasModja,
                    String megjegyzes) {

        this.rendelesId = rendelesId;
        this.userName = userName;
        this.megrendelesDatum = megrendelesDatum;
        this.fizetesModja = fizetesModja;
        this.kezbesitesModja = kezbesitesModja;
        this.szallitasModja = szallitasModja;
        this.megjegyzes = megjegyzes;
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
                                         String password,
                                         List<Felhasznalo> felhasznalok) {
         if (userName == null){
             throw new IllegalArgumentException("Nincs user megadva !");
         }

         for (Felhasznalo fh : felhasznalok) {
            if (fh.userName.equals(userName)) {
                if (fh.getPassword().equals(password)) {
                    return fh;
                }
                else{
                    throw new IllegalArgumentException("Hibás jelszó !");
                }

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
             throw new IllegalArgumentException(termek.nev+" termékből a rendelhető mennyiseg max. "+termek.OSSZMENNYISEG+" db");
             //System.out.println(termek.nev+" termékből a rendelhető mennyiseg max. "+termek.OSSZMENNYISEG+" db");
           }
         termekTetel.setMennyiseg(Math.min(termek.getOsszMennyiseg(),mennyiseg));

        //System.out.println("termekTetel.getMennyiseg(): "+termekTetel.getMennyiseg());

        termekTetel.setOsszMennyiseg(termek.getOsszMennyiseg()-Math.min(termek.getOsszMennyiseg(),mennyiseg));
        termek.setOsszMennyiseg(termekTetel.getOsszMennyiseg());
        //System.out.println("termekTetel.getOsszMennyiseg(): "+termekTetel.getOsszMennyiseg());

        return termekTetel;
       }

    public void atadasFutarnak(Rendeles rendeles) {
        rendeles.rendelesStatus=RendelesStatus.IN_PROGRESS;
    }

    public void RendelesStatusAllitasSzallitaskor(Rendeles rendeles,SzallitasStatus szallitasStatus) {
        /*if (szallitasStatus==null){
            throw new IllegalArgumentException("Nincs megadva a szállítás státusza ! ");
        }*/
        {
            if (szallitasStatus.equals(SzallitasStatus.UNSUCCESSFUL)) {
                rendeles.rendelesStatus = RendelesStatus.FAILED_DELIVERY;
            }
            else
                rendeles.rendelesStatus = RendelesStatus.DELIVERED;
        }
    }
    public Megrendelo rendelesMegrendeloje(Felhasznalo felhasznalo,
                                           List<Felhasznalo> felhasznalok,
                                           List<Megrendelo> megrendelok) {
        Megrendelo megrendelo=new Megrendelo();
        if (felhasznalo.getFelhasznaloStatus() == FelhasznaloStatus.CUSTOMER) {
            Felhasznalo felhasznaloTalalt;
            felhasznaloTalalt = felhasznaloKeres(felhasznalo.getUserName(),felhasznalo.getPassword(),felhasznalok);
            // ha nincs ilyen felhasználó
            if (felhasznaloTalalt==null) {
                Felhasznalo ujFelhasznalo = new Felhasznalo();
                felhasznalo.setUserName(felhasznalo.getUserName());
                felhasznalo.setPassword(felhasznalo.getPassword());
                felhasznalo.setFelhasznaloStatus(felhasznalo.getFelhasznaloStatus());
                // egyelőre csak a megrendelő user kap értéket
                megrendelo.setUserName(felhasznalo.getUserName());
                }
            else    {
                Megrendelo talaltMegrendelo;
                talaltMegrendelo = megrendeloKeres(felhasznalo.getUserName(), megrendelok);
                if (talaltMegrendelo == null) {
                        megrendelo.setUserName(felhasznalo.getUserName());
                    }
                else{
                    megrendelo=talaltMegrendelo;
                }
            }
            return megrendelo;
        }
       return null;
    }


    public void vasarlas(Felhasznalo felhasznalo,
                         Megrendelo megrendelo,
                         Rendeles rendeles,
                         SzallitasStatus szallitasStatus,
                         List<Felhasznalo> felhasznalok,
                         List<Megrendelo> megrendelok) {
        Megrendelo talaltMegrendelo;
        talaltMegrendelo = rendelesMegrendeloje(felhasznalo,
                                                felhasznalok,
                                                megrendelok);
        //System.out.println("megrendelo="+talaltMegrendelo);
            if (talaltMegrendelo.getUserName()!=null && talaltMegrendelo.getNev()==null) {
                megrendelo.setAdatok(megrendelo.getNev(), megrendelo.getCim(), megrendelo.getEmail(), megrendelo.getTelefon());
            }
            else{
                megrendelo=talaltMegrendelo;
            }

        rendeles.rendelesStatusAllitasInditaskor(rendeles);
            if (rendeles.getKezbesitesModja().equals(KezbesitesModja.ONLINE)) {
                if (rendeles.getSzallitasModja() != null){
                    if (rendeles.getSzallitasModja().equals(SzallitasModja.COURIER_HOME_DELIVERY)) {
                        rendeles.atadasFutarnak(rendeles);
                        if (szallitasStatus != null) {
                            rendeles.RendelesStatusAllitasSzallitaskor(rendeles, szallitasStatus);
                            if (rendeles.rendelesStatus.equals(RendelesStatus.FAILED_DELIVERY)) {
                                if (rendeles.getMegjegyzes() == null) {
                                    throw new IllegalArgumentException("A megjegyzés sikertelen szállításkor kitöltendő !");
                                }

                            } else {
                                if (rendeles.getMegjegyzes() != null) {
                                    throw new IllegalArgumentException("A megjegyzés csak sikertelen szállításkor kitölthető !");
                                }
                            }
                        }
                    }
                }
            } else {
                if (rendeles.getSzallitasModja() != null) {
                    throw new IllegalArgumentException("Személyes vásárlásnál a szállítás módja nem kitölthető !");
                }
                if (szallitasStatus != null) {
                    throw new IllegalArgumentException("Személyes vásárlásnál a szállítás státusza nem kitölthető !");
                }
            }

        teljesRendelesKiiras(rendeles,megrendelo,szallitasStatus);
    }

    public void teljesRendelesKiiras(Rendeles rendeles,
                                     Megrendelo megrendelo,
                                     SzallitasStatus szallitasstatus){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss zzz");

        System.out.println(" User név            = " + rendeles.getUserName());
        System.out.println(" Megrendelő név      = " + megrendelo.getNev());
        System.out.println(" Cím                 = " + megrendelo.getCim());
        System.out.println(" Email               = " + megrendelo.getEmail());
        System.out.println(" Telefon             = " + megrendelo.getTelefon());
        System.out.println(" Rendeles Id         = " + rendeles.getRendelesId());
        System.out.println(" Megrendeles Dátuma  = " + dateFormat.format(rendeles.getMegrendelesDatum()));
        System.out.println(" ----------------------------------------------------------- ");
        System.out.println(" Tételek =" + rendeles.getTetelList());
        System.out.println(" ----------------------------------------------------------- ");
        System.out.println(" Ár összesen         = " + rendeles.getAr());
        System.out.println(" Fizetes    Módja    = " + rendeles.getFizetesModja());
        System.out.println(" Kézbesites Módja    = " + rendeles.getKezbesitesModja());
        if (rendeles.getKezbesitesModja().equals(KezbesitesModja.ONLINE)) {
            System.out.println(" Szállitás  Módja    = " + rendeles.getSzallitasModja());
        }
        System.out.println(" Rendelés Status     = " + rendeles.getRendelesStatus());
        if (rendeles.getKezbesitesModja().equals(KezbesitesModja.ONLINE)) {
            System.out.println(" Szállítás Status    = " + szallitasstatus);
        }
        if (rendeles.getKezbesitesModja().equals(KezbesitesModja.ONLINE) && szallitasstatus!=null && szallitasstatus.equals(SzallitasStatus.UNSUCCESSFUL)) {

            System.out.println(" Megjegyzés          =  " + rendeles.getMegjegyzes());
        }
    }


    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss zzz");
        return  "  Rendeles Id             = " + rendelesId +"\n"+
            ", User név                = '" + userName +"\n"+
            ", Megrendeles Dátuma      = " + dateFormat.format(megrendelesDatum) +"\n"+
            ", Megrendelés ár összesen = " + getAr() +"\n"+
            ", tetelList=" + tetelList +"\n"+
            ", Fizetes    Módja = " + fizetesModja +"\n"+
            ", Kézbesites Módja = " + kezbesitesModja +"\n"+
            ", Szállitás  Módja = " + szallitasModja +"\n"+
            ", Rendelés Status  = " + rendelesStatus +"\n"+
            ", Megjegyzés       = '" + megjegyzes + '\'' +
            '}';
    }
}











