import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RendelesTest {


    Termek termek1 = new Termek(BigInteger.valueOf(1), "Concept Kids:Állatok", 10495, 2);
    Termek termek2 = new Termek(BigInteger.valueOf(2), "Bűvös henger logikai játék", 1295, 1);
    Termek termek3 = new Termek(BigInteger.valueOf(3), "Dickie tűzoltó autó fénnyel és hanggal", 8995, 3);
    Termek termek4 = new Termek(BigInteger.valueOf(4), "Bogyó és Babóca Spedd Colors társasjáték", 4995, 2);

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
    public void felhasznaloKeres() {
        Rendeles rendeles = new Rendeles();
        Felhasznalo felhasznaloTalalt;
        List<Felhasznalo> felhasznalok = new ArrayList<>();
        felhasznalok.add(felhasznalo1);
        felhasznalok.add(felhasznalo2);
        felhasznalok.add(felhasznalo3);
        felhasznalok.add(felhasznalo4);
        felhasznalok.add(felhasznalo5);
        felhasznaloTalalt=rendeles.felhasznaloKeres("user4",
                                                    felhasznalok);
        System.out.println(felhasznaloTalalt);
    }

    @Test
    public void megrendeloKeres() {
        Rendeles rendeles = new Rendeles();
        Megrendelo megrendelo;
        List<Megrendelo> megrendelok = new ArrayList<>();
        megrendelok.add(megrendelo1);
        megrendelok.add(megrendelo2);
        megrendelok.add(megrendelo3);
        megrendelok.add(megrendelo4);
        megrendelo=rendeles.megrendeloKeres("user1",megrendelok);
        System.out.println(megrendelo);
    }

    @Test
    public void rendelesStatusAllitasInditaskor() {
        Rendeles rendeles=new Rendeles();
        rendeles.kezbesitesModja=KezbesitesModja.ONLINE;
        rendeles.rendelesStatusAllitasInditaskor(rendeles);
        System.out.println(rendeles.rendelesStatus);
    }

    @Test
    public void termekTetelHozzaadas() {
        Rendeles rendeles=new Rendeles();
        List<TermekTetel> termekTetelek=new ArrayList<>();
        termekTetelek.add(rendeles.TermekTetelHozzaadas(termek1, 1));
        termekTetelek.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelek);
        System.out.println("A rendelt tételek összértéke:"+rendeles.getAr());
    }

    @Test
    public void atadasFutarnak() {
        Rendeles rendeles=new Rendeles();
        rendeles.kezbesitesModja=KezbesitesModja.ONLINE;
        rendeles.atadasFutarnak(rendeles);
        System.out.println(rendeles.rendelesStatus);
    }

    @Test
    public void rendelesStatusAllitasSzallitaskor() {
        Rendeles rendeles=new Rendeles();
        SzallitasStatus szallitasStatus=SzallitasStatus.SUCCESSFUL;
        rendeles.RendelesStatusAllitasSzallitaskor(rendeles,szallitasStatus);
        System.out.println(rendeles.rendelesStatus);
    }

    @Test
    public void vasarlasFolyamat() {
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
        Rendeles rendeles = new Rendeles();
        Megrendelo megrendelo = new Megrendelo();
        FelhasznaloStatus felhasznaloStatus = FelhasznaloStatus.CUSTOMER;
        Megrendelo talaltMegrendelo;
        talaltMegrendelo = rendeles.vasarlasMegrendeloig(rendeles,
                userName,
                password,
                felhasznaloStatus,
                felhasznalok,
                megrendelok);
        // ha olyan felhasznaló lépett be, aki nem megrendelo hanem pl futár, admin, egyéb
        if (talaltMegrendelo == null) {
             //TODO
        } else {
            // Új megrendelő
            if (megrendelo.getUserName()==null) {
                megrendelo.setUserName(userName);
                megrendelo.setAdatok("megrendelo5", "cim5", "email5", "telefon5");
            }
            System.out.println(megrendelo);
        }
        rendeles.setUserIdDatumFizetesKezbesitesModja(userName,
                BigInteger.valueOf(1),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.ONLINE);
        // terméktétel lista létrehozása
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.rendelesStatusAllitasInditaskor(rendeles);

        if (rendeles.kezbesitesModja.equals(KezbesitesModja.ONLINE)) {
            SzallitasModja szallitasModja=SzallitasModja.COURIER_HOME_DELIVERY;
            if (szallitasModja.equals(SzallitasModja.COURIER_HOME_DELIVERY)) {
                rendeles.setSzallitasModja(szallitasModja);
                rendeles.atadasFutarnak(rendeles);
                rendeles.RendelesStatusAllitasSzallitaskor(rendeles, SzallitasStatus.UNSUCCESSFUL);
                if (rendeles.rendelesStatus.equals(RendelesStatus.FAILED_DELIVERY)) {
                    rendeles.setMegjegyzes("Nem voltak otthon");
                }
            }
        }
        System.out.println(rendeles);
    }
}
