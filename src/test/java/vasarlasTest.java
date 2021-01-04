
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
    Megrendelo megrendelo3 = new Megrendelo("user3", "Megrendelo3", "cim3", "megrendelo3@gmail.com", "3333333");
    Megrendelo megrendelo4 = new Megrendelo("user4", "Megrendelo4", "cim4", "megrendelo4@gmail.com", "4444444");
    List<Felhasznalo> felhasznalok = new ArrayList<>();

    @Test
    public void onlineVasarlasSikertelenSzallitasUjMegrendelo() {
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
        megrendelok.add(megrendelo4);;
        Felhasznalo felhasznalo=new Felhasznalo("user6","psw6",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo("user6","megrendelo6","cim6","email6","telefon6");
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(1),
                                       felhasznalo.getUserName(),
                                       Calendar.getInstance().getTime(),
                                       FizetesModja.CARD,
                                       KezbesitesModja.ONLINE,
                                       SzallitasModja.COURIER_HOME_DELIVERY,
                             "Nem voltak otthon");
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                          megrendelo,
                          rendeles,
                          SzallitasStatus.UNSUCCESSFUL,
                          felhasznalok,
                          megrendelok);
        assertThat(termek1.getOsszMennyiseg(), equalTo(0));
        assertThat(termek2.getOsszMennyiseg(), equalTo(0));
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.FAILED_DELIVERY));
        assertThat(rendeles.getAr(), equalTo(22285));

    }
    @Test
    public void onlineVasarlasSikertelenSzallitasLetezoMegrendelo() {
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
        megrendelok.add(megrendelo4);;
        Felhasznalo felhasznalo=new Felhasznalo("user3","psw3",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(2),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.ONLINE,
                SzallitasModja.COURIER_HOME_DELIVERY,
                "Nem voltak otthon");
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,1));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                SzallitasStatus.UNSUCCESSFUL,
                felhasznalok,
                megrendelok);
        assertThat(termek1.getOsszMennyiseg(), equalTo(1));
        assertThat(termek2.getOsszMennyiseg(), equalTo(0));
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.FAILED_DELIVERY));
        assertThat(rendeles.getAr(), equalTo(11790));


    }
  @Test
    public void onlineVasarlasSikeresSzallitasLetezoMegrendelo() {
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
        Felhasznalo felhasznalo =new Felhasznalo("user2","psw2",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(3),
                                       felhasznalo.getUserName(),
                                       Calendar.getInstance().getTime(),
                                       FizetesModja.CARD,
                                       KezbesitesModja.ONLINE,
                                       SzallitasModja.COURIER_HOME_DELIVERY);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek4,1));
        rendeles.setTetelList(termekTetelList);
        SzallitasStatus szallitasstatus =SzallitasStatus.SUCCESSFUL;
        rendeles.vasarlas(felhasznalo,
                          megrendelo,
                          rendeles,
                          SzallitasStatus.SUCCESSFUL,
                          felhasznalok,
                          megrendelok);
      assertThat(termek3.getOsszMennyiseg(), equalTo(1));
      assertThat(termek4.getOsszMennyiseg(), equalTo(3));
      assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.DELIVERED));
      assertThat(rendeles.getAr(), equalTo(22985));

  }

    @Test
    public void onlineVasarlasSikeresSzallitasUjMegrendelo() {
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
        Felhasznalo felhasznalo =new Felhasznalo("user7","psw7",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo("user7","megrendelo7","cim7","email7","telefon7");
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(4),
                                       felhasznalo.getUserName(),
                                       Calendar.getInstance().getTime(),
                                       FizetesModja.CARD,
                                       KezbesitesModja.ONLINE,
                                       SzallitasModja.COURIER_HOME_DELIVERY);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek4,2));
        rendeles.setTetelList(termekTetelList);
        SzallitasStatus szallitasstatus =SzallitasStatus.SUCCESSFUL;
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                SzallitasStatus.SUCCESSFUL,
                felhasznalok,
                megrendelok);
        assertThat(termek3.getOsszMennyiseg(), equalTo(1));
        assertThat(termek4.getOsszMennyiseg(), equalTo(2));
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.DELIVERED));
        assertThat(rendeles.getAr(), equalTo(27980));

    }
@Test
    public void szemelyesVasarlasLetezoMegrendelo() {
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
        Felhasznalo felhasznalo =new Felhasznalo("user4","psw4",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(5),
                                       felhasznalo.getUserName(),
                                       Calendar.getInstance().getTime(),
                                       FizetesModja.CARD,
                                       KezbesitesModja.INPERSON);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek4,3));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                          megrendelo,
                          rendeles,
                          null,
                          felhasznalok,
                          megrendelok);
    assertThat(termek3.getOsszMennyiseg(), equalTo(1));
    assertThat(termek4.getOsszMennyiseg(), equalTo(1));
    assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.DELIVERED));
    assertThat(rendeles.getAr(), equalTo(32975));

    }
@Test
    public void szemelyesVasarlasLetezoUjMegrendelo() {
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
        Felhasznalo felhasznalo =new Felhasznalo("user8","psw8",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo("user8","megrendelo8","cim8","email8","telefon8");
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(6),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.INPERSON);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek4,3));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                null,
                felhasznalok,
                megrendelok);
    assertThat(termek3.getOsszMennyiseg(), equalTo(1));
    assertThat(termek4.getOsszMennyiseg(), equalTo(1));
    assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.DELIVERED));
    assertThat(rendeles.getAr(), equalTo(32975));

    }

@Test(expected = IllegalArgumentException.class)
    public void szemelyesVasarlasHibasJelszo() {
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
        Felhasznalo felhasznalo =new Felhasznalo("user1","psw2",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
         Rendeles rendeles=new Rendeles(BigInteger.valueOf(7),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.INPERSON);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek4,3));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                          megrendelo,
                          rendeles,
                         null,
                          felhasznalok,
                          megrendelok);
    }

    @Test (expected = IllegalArgumentException.class)
    public void szemelyesVasarlasVanSzallitasModja() {
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
        Felhasznalo felhasznalo =new Felhasznalo("user1","psw1",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(8),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.INPERSON,
                SzallitasModja.COURIER_HOME_DELIVERY);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek4,3));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                null,
                felhasznalok,
                megrendelok);

    }
    @Test(expected = IllegalArgumentException.class)
    public void onlineVasarlasSikertelenSzallitasLetezoMegrendeloNincsMegjegyzes() {
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
        megrendelok.add(megrendelo4);;
        Felhasznalo felhasznalo=new Felhasznalo("user3","psw3",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(9),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.ONLINE,
                SzallitasModja.COURIER_HOME_DELIVERY);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                SzallitasStatus.UNSUCCESSFUL,
                felhasznalok,
                megrendelok);

    }

    @Test(expected = IllegalArgumentException.class)
    public void onlineVasarlasSikertelenSzallitasNincsElegKeszleten() {
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
        megrendelok.add(megrendelo4);;
        Felhasznalo felhasznalo=new Felhasznalo("user3","psw3",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(10),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.ONLINE,
                SzallitasModja.COURIER_HOME_DELIVERY,
                "Nem létezik a megadott cím");
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,6));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                SzallitasStatus.UNSUCCESSFUL,
                felhasznalok,
                megrendelok);
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.BOOKED));



    }
    @Test
    public void onlineVasarlasMegNincsSzallitasModja() {
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
        megrendelok.add(megrendelo4);;
        Felhasznalo felhasznalo=new Felhasznalo("user4","psw4",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(11),
                                       felhasznalo.getUserName(),
                                       Calendar.getInstance().getTime(),
                                       FizetesModja.CARD,
                                       KezbesitesModja.ONLINE);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek1,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                null,
                felhasznalok,
                megrendelok);
       assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.BOOKED));

    }
    @Test
    public void onlineVasarlasAtadvaFutarnakNincsMegSzallitva() {
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
        megrendelok.add(megrendelo4);;
        Felhasznalo felhasznalo=new Felhasznalo("user1","psw1",FelhasznaloStatus.CUSTOMER);
        Megrendelo megrendelo=new Megrendelo();
        Rendeles rendeles=new Rendeles(BigInteger.valueOf(12),
                felhasznalo.getUserName(),
                Calendar.getInstance().getTime(),
                FizetesModja.CARD,
                KezbesitesModja.ONLINE,
                SzallitasModja.COURIER_HOME_DELIVERY);
        List<TermekTetel> termekTetelList=new ArrayList<>();
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek3,2));
        termekTetelList.add(rendeles.TermekTetelHozzaadas(termek2,1));
        rendeles.setTetelList(termekTetelList);
        rendeles.vasarlas(felhasznalo,
                megrendelo,
                rendeles,
                null,
                felhasznalok,
                megrendelok);
        assertThat(rendeles.rendelesStatus, equalTo(RendelesStatus.IN_PROGRESS));


    }

}