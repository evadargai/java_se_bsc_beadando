
public class Felhasznalo {
    String userName;
    private String password;
    private FelhasznaloStatus felhasznaloStatus;


    public Felhasznalo(String userName, String password, FelhasznaloStatus felhasznaloStatus) {
        this.userName = userName;
        this.password = password;
        this.felhasznaloStatus = felhasznaloStatus;
    }

    public Felhasznalo(String userName) {
        this.userName = userName;
    }

    public Felhasznalo() { }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FelhasznaloStatus getFelhasznaloStatus() {
        return felhasznaloStatus;
    }

    public void setFelhasznaloStatus(FelhasznaloStatus felhasznaloStatus) {
        this.felhasznaloStatus = felhasznaloStatus;
    }

    @Override
    public String toString() {
        return "Felhasznalo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", felhasznaloStatus=" + felhasznaloStatus +
                '}';
    }
}
