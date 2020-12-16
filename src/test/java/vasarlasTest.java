
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class vasarlasTest {
    Termek termek1 = new Termek(BigInteger.valueOf(1), "Concept Kids:Állatok", 10495, 2);
    Termek termek2 = new Termek(BigInteger.valueOf(2), "Bűvös henger logikai játék", 1295, 1);
    Termek termek3 = new Termek(BigInteger.valueOf(3), "Dickie tűzoltó autó fénnyel és hanggal", 8995, 3);
    Termek termek4 = new Termek(BigInteger.valueOf(4), "Bogyó és Babóca Spedd Colors társasjáték", 4995, 4);

    Felhasznalo felhasznalo1 = new Felhasznalo("user1", "psw1", FelhasznaloStatus.CUSTOMER);
    Felhasznalo felhasznalo2 = new Felhasznalo("user2", "psw2", FelhasznaloStatus.CUSTOMER);
    Felhasznalo felhasznalo3 = new Felhasznalo("user3", "psw3", FelhasznaloStatus.CUSTOMER);
    Felhasznalo felhasznalo4 = new Felhasznalo("user4", "psw4", FelhasznaloStatus.CUSTOMER);
    Felhasznalo felhasznalo5 = new Felhasznalo("user5", "psw5", FelhasznaloStatus.OTHER);

    Megrendelo megrendelo1 = new Megrendelo("user1", "Megrendelo1", "cim1", "megrendelo1@gmail.com", "1111111");
    Megrendelo megrendelo2 = new Megrendelo("user2", "Megrendelo2", "cim2", "megrendelo2@gmail.com", "2222222");
    Megrendelo megrendelo3 = new Megrendelo("user3", "Megrendelo3", "cim3", "megrendelo3@gmail.com", "1111111");
    Megrendelo megrendelo4 = new Megrendelo("user4", "Megrendelo4", "cim4", "megrendelo4@gmail.com", "4444444");

    @Test
    public void onlineVasarlasSikertelenSzallitassal() {
        Rendeles rendeles=new Rendeles();
        List<Felhasznalo> felhasznalok = new ArrayList<>();
        felhasznalok.add(felhasznalo1);
        felhasznalok.add(felhasznalo2);
        felhasznalok.add(felhasznalo3);
        felhasznalok.add(felhasznalo4);
        felhasznalok.add(felhasznalo5);
        List<Megrendelo> megrendelok = new ArrayList<>();
        megrendelok.add(megrendelo1);
        megrendelok.add(megrendelo2);
        megrendelok.add(megrendelo3);
        megrendelok.add(megrendelo4);
        String userName = "user6";
        String password = "psw6";
        FelhasznaloStatus felhasznaloStatus = FelhasznaloStatus.CUSTOMER;
        String nev="megrendelo5";
        String cim="cim5";
        String email="email5";
        String telefon="telefon5";
        BigInteger rendelesId=BigInteger.valueOf(1);
        Date megrendelesDatum= Calendar.getInstance().getTime();
        FizetesModja fizetesModja=FizetesModja.CARD;
        KezbesitesModja kezbesitesModja=KezbesitesModja.ONLINE;
        SzallitasModja szallitasModja=SzallitasModja.COURIER_HOME_DELIVERY;
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,1));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        SzallitasStatus szallitasStatus= SzallitasStatus.UNSUCCESSFUL;
        String megjegyzes="Nem voltak otthon";
        rendeles.vasarlas(userName,
                          password,
                          felhasznaloStatus,
                          nev,
                          cim,
                          email,
                          telefon,
                          rendelesId,
                          megrendelesDatum,
                          fizetesModja,
                          kezbesitesModja,
                          termekTetelList,
                          szallitasModja,
                          szallitasStatus,
                          megjegyzes,
                          felhasznalok,
                          megrendelok);
        System.out.println("Szállítás státusza = "+szallitasStatus);

    }
  @Test
    public void onlineVasarlasSikeresSzallitassal() {
        Rendeles rendeles=new Rendeles();
        List<Felhasznalo> felhasznalok = new ArrayList<>();
        felhasznalok.add(felhasznalo1);
        felhasznalok.add(felhasznalo2);
        felhasznalok.add(felhasznalo3);
        felhasznalok.add(felhasznalo4);
        felhasznalok.add(felhasznalo5);
        List<Megrendelo> megrendelok = new ArrayList<>();
        megrendelok.add(megrendelo1);
        megrendelok.add(megrendelo2);
        megrendelok.add(megrendelo3);
        megrendelok.add(megrendelo4);
        String userName = "user6";
        String password = "psw6";
        FelhasznaloStatus felhasznaloStatus = FelhasznaloStatus.CUSTOMER;
        String nev="megrendelo5";
        String cim="cim5";
        String email="email5";
        String telefon="telefon5";
        BigInteger rendelesId=BigInteger.valueOf(1);
        Date megrendelesDatum= Calendar.getInstance().getTime();
        FizetesModja fizetesModja=FizetesModja.CARD;
        KezbesitesModja kezbesitesModja=KezbesitesModja.ONLINE;
        SzallitasModja szallitasModja=SzallitasModja.COURIER_HOME_DELIVERY;
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        SzallitasStatus szallitasStatus= SzallitasStatus.SUCCESSFUL;
        String megjegyzes=null;
        rendeles.vasarlas(userName,
                          password,
                          felhasznaloStatus,
                          nev,
                          cim,
                          email,
                          telefon,
                          rendelesId,
                          megrendelesDatum,
                          fizetesModja,
                          kezbesitesModja,
                          termekTetelList,
                          szallitasModja,
                          szallitasStatus,
                          megjegyzes,
                          felhasznalok,
                          megrendelok);
        System.out.println("Szállítás státusza = "+szallitasStatus);
    }
@Test
    public void szemelyesVasarlas() {
        Rendeles rendeles=new Rendeles();
        List<Felhasznalo> felhasznalok = new ArrayList<>();
        felhasznalok.add(felhasznalo1);
        felhasznalok.add(felhasznalo2);
        felhasznalok.add(felhasznalo3);
        felhasznalok.add(felhasznalo4);
        felhasznalok.add(felhasznalo5);
        List<Megrendelo> megrendelok = new ArrayList<>();
        megrendelok.add(megrendelo1);
        megrendelok.add(megrendelo2);
        megrendelok.add(megrendelo3);
        megrendelok.add(megrendelo4);
        String userName = "user4";
        String password = "psw4";
        FelhasznaloStatus felhasznaloStatus = FelhasznaloStatus.CUSTOMER;
        String nev="megrendelo5";
        String cim="cim5";
        String email="email5";
        String telefon="telefon5";
        BigInteger rendelesId=BigInteger.valueOf(1);
        Date megrendelesDatum=Calendar.getInstance().getTime();
        FizetesModja fizetesModja=FizetesModja.CARD;
        KezbesitesModja kezbesitesModja=KezbesitesModja.INPERSON;
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,1));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        SzallitasStatus szallitasStatus= null;
        String megjegyzes=null;
        rendeles.vasarlas(userName,
                          password,
                          felhasznaloStatus,
                          nev,
                          cim,
                          email,
                          telefon,
                          rendelesId,
                          megrendelesDatum,
                          fizetesModja,
                          kezbesitesModja,
                          termekTetelList,
                null,
                          szallitasStatus,
                          megjegyzes,
                          felhasznalok,
                          megrendelok);

    }
}