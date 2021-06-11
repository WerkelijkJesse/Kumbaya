package zeroXessApp.ClassObjects;

public class Accounts extends People {

    private String password;
    private String country;
    private String secretAnswer;
    private String phoneNumber;
    private String diseaces;

    public Accounts(String adress, Integer yearOfBirth, String username, String country, String password, String secretAnswer, String phoneNumber) {
        super(adress, yearOfBirth, username);
        this.country = country;
        this.password = password;
        this.secretAnswer = secretAnswer;
        this.phoneNumber = phoneNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumber(String number) {
        this.phoneNumber = number;
    }

    public void setDiseaces(String diseaces) {
        this.diseaces = diseaces;
    }

    public String getCountry () {
        return this.country;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSecretAnswer() {
        return this.secretAnswer;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getDiseaces() {
        return this.diseaces;
    }
}
