package Classes;

public class Mechanic {

    private int userid;
    private String username;
    private String password;
    private boolean ismechanic;

    public Mechanic(int userid,String username,String password,boolean ismechanic)
    {
        this.ismechanic = ismechanic;
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsmechanic() {
        return ismechanic;
    }

    public void setIsmechanic(boolean ismechanic) {
        this.ismechanic = ismechanic;
    }
}
