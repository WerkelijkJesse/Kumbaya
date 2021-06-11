package zeroXessApp.ClassObjects;

public abstract class People {
    private String adress;
    private Integer yearOfBirth;
    private String username;

    public People (String adress, Integer yearOfBirth, String username) {
        this.adress = adress;
        this.yearOfBirth = yearOfBirth;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return this.adress;
    }

    public Integer getYearOfBirth () {
        return this.yearOfBirth;
    }

    public String getUsername() {
        return this.username;
    }

    public String toString() {
        return username + " " + adress + " " + yearOfBirth.toString();
    }
}
