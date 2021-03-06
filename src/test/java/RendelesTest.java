
import org.junit.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
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
                                                     "psw4",
                                                    felhasznalok);
        assertThat(felhasznaloTalalt, equalTo(felhasznalo4));
        //System.out.println(felhasznaloTalalt);
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
        assertThat(megrendelo, equalTo(megrendelo1));
        System.out.println(megrendelo);
    }

    @Test
    public void rendelesStatusAllitasInditaskor() {
        Rendeles rendeles=new Rendeles();
        rendeles.kezbesitesModja=KezbesitesModja.ONLINE;
        rendeles.rendelesStatusAllitasInditaskor(rendeles);
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.BOOKED));
        //System.out.println(rendeles.rendelesStatus);
    }

    @Test
    public void termekTetelHozzaadas() {
        Rendeles rendeles=new Rendeles();
        rendeles.TermekTetelHozzaadas(termek1, 1);
        rendeles.TermekTetelHozzaadas(termek2,1);
        assertThat(termek1.OSSZMENNYISEG, equalTo(1));
        assertThat(termek2.OSSZMENNYISEG, equalTo(0));
    }


    @Test
    public void atadasFutarnak() {
        Rendeles rendeles=new Rendeles();
        rendeles.kezbesitesModja=KezbesitesModja.ONLINE;
        rendeles.atadasFutarnak(rendeles);
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.IN_PROGRESS));
        //System.out.println(rendeles.rendelesStatus);
    }

    @Test
    public void rendelesStatusAllitasSzallitaskor() {
        Rendeles rendeles=new Rendeles();
        SzallitasStatus szallitasStatus=SzallitasStatus.SUCCESSFUL;
        rendeles.RendelesStatusAllitasSzallitaskor(rendeles,szallitasStatus);
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.DELIVERED));
        //System.out.println(rendeles.rendelesStatus);
    }


}
