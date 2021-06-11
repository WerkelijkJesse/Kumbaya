package zeroXessApp.ClassObjects;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private String name;
    private String adress;
    private String date;
    private String time;
    private String patientUser;
    private String information;
    private LocalDate date1;
    private LocalTime time1;
    private LocalDateTime dateTime;

    public Appointment (String name, String adress, String patientUser, String information, LocalDate date1, LocalTime time1) {
        this.name = name;
        this.adress = adress;
        this.patientUser = patientUser;
        this.information = information;
        this.date1 = date1;
        this.time1 = time1;
        this.date = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.time = time1.toString();
        dateTime = LocalDateTime.of(date1, time1);
    }

    public String getName() {
        return this.name;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public String getPatientUser() {
        return this.patientUser;
    }

    public LocalDate getLocalDate() {
        return date1;
    }

    public LocalTime getLocalTime() {
        return time1;
    }

    public LocalDateTime getLocalDateTime() {
        return this.dateTime;
    }

    public String toString() {
        return name + "                        " + adress + "                                      " + date + "                " + time;
    }
}
