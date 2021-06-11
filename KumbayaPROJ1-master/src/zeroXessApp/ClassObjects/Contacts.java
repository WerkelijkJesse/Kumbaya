package zeroXessApp.ClassObjects;

public class Contacts extends People {
    private String addedBy;
    public Contacts(String adress, Integer yearOfBirth, String username, String addedBy) {
        super(adress, yearOfBirth, username);
        this.addedBy = addedBy;
    }

    public String getAddedBy () {
        return this.addedBy;
    }
}
