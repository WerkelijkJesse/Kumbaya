package zeroXessApp.ClassObjects;

public class Doctor extends People {

    private String realName;
    private String ear;
    private String eyes;
    private String skin;
    private String general;

    public Doctor(String adress, Integer yearOfBirth, String username, String realName, String ear, String eyes, String skin, String general) {
        super(adress, yearOfBirth, username);
        this.realName = realName;
        this.ear = ear;
        this.eyes = eyes;
        this.skin = skin;
        this.general = general;
    }

    public String getRealName() {
        return this.realName;
    }

    public String getEar() {
        return this.ear;
    }

    public String getEyes() {
        return this.eyes;
    }

    public String getSkin() {
        return this.skin;
    }

    public String getGeneral() {
        return this.general;
    }


}
