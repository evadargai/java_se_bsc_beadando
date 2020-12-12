
public class Megrendelo extends Felhasznalo{
    String nev;
    String cim;
    String email;
    String telefon;

    public Megrendelo(String userName, String nev, String cim, String email, String telefon) {
        super(userName);
        this.nev = nev;
        this.cim = cim;
        this.email = email;
        this.telefon = telefon;
    }
    public Megrendelo(String userName) {
        super(userName);
    }

    public Megrendelo(){}


    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void setAdatok(String nev,String cim,String email,String telefon){
    this.nev=nev;
    this.cim=cim;
    this.email=email;
    this.telefon=telefon;}

    @Override
    public String toString() {
        return "Megrendelo{" +
                ", userName='" + userName + '\'' +
                ", nev='" + nev + '\'' +
                ", cim='" + cim + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
