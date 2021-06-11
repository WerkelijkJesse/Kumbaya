package zeroXessApp.Classes;
import zeroXessApp.ClassObjects.Accounts;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Checker {

    protected String pass;
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public static boolean checkAge(int yob) {
        if (yob >= 2016) {
            return false;
        }
        return true;
    }

    public static int checkPrice(int yob) {
        int costPerYear = 0;
        if (yob <= 2000) {
            costPerYear = 10;
        }
        else if (yob <= 2010) {
            costPerYear = 5;
        }
        else if (yob <= 2016) {
            costPerYear = 1;
        }
        return costPerYear;
    }

    public static boolean checkUsername(ArrayList<Accounts> accounts, String userName) {
        for (Accounts account : accounts) {
            if (account.getUsername().equalsIgnoreCase(userName)) {
                return false;
            } }
        return true;
    }

    public static boolean checkLogin(ArrayList<Accounts> accounts, String userName, String passWord) {
        for (Accounts account : accounts) {
            if (account.getUsername().equalsIgnoreCase(userName) && account.getPassword().equals(passWord)) {
                return true; } }
        return false;
    }

    public boolean checkForgot(ArrayList<Accounts> accounts, String username, Integer yob, String lastNumbers) {
        for (int i=0; i<accounts.size(); i++) {
            if ((accounts.get(i).getUsername().equalsIgnoreCase(username)) &&
                 (accounts.get(i).getYearOfBirth().equals(yob)) &&
                 (accounts.get(i).getSecretAnswer().equals(lastNumbers))) {
                pass = accounts.get(i).getPassword();
                return true; }
        }
        return false;
    }

    public String getPassword() {
        return pass;
    }

    public static boolean checkAppointment(String name, LocalDate localDate, LocalTime localTime) {
        for (int i = 0; i< arrays.getAppointmentList().size(); i++) {
            if (arrays.getAppointment(i).getName().equals(name) && arrays.getAppointment(i).getLocalDate().equals(localDate)
                && arrays.getAppointment(i).getLocalTime().equals(localTime)) {
                return false; }
        }
        return true;
    }

    public static Boolean writeAnswerCompare (String question, String answer, Boolean time){
        if(question.equals(answer) && time){
            return true;
        }
        else{
            return false;
        }
    }
}
