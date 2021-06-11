package zeroXessApp.Classes;
import javafx.scene.image.Image;
import zeroXessApp.ClassObjects.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ArrayLists {

    private static final ArrayLists onlyInstance = new ArrayLists();

    private final ArrayList <Accounts> accounts = new ArrayList<>();
    private final ArrayList <Animals> cattle = new ArrayList<>();
    private final ArrayList <Animals> market = new ArrayList<>();
    private final ArrayList <Contacts> contacts = new ArrayList<>();
    private final ArrayList <Doctor> doctors = new ArrayList<>();
    private final ArrayList <String> easyWrite = new ArrayList<>();
    private final ArrayList <String> mediumWrite = new ArrayList<>();
    private final ArrayList <String> hardWrite = new ArrayList<>();
    private final ArrayList <Appointment> appointments = new ArrayList<>();
    private final ArrayList<EduReadEasy> eduRead = new ArrayList<>();
    private final ArrayList<EduReadMedium> eduReadM = new ArrayList<>();
    private final ArrayList<EduReadHard> eduReadH = new ArrayList<>();
    private final ArrayList <HighScores> mathHighScores = new ArrayList<>();
    private final ArrayList <String> wordWrite = new ArrayList<>();
    private final ArrayList <CorrectSum> correctSums = new ArrayList<>();
    private final ArrayList <Medicine> medicines = new ArrayList<>();
    private final ArrayList<ReadAndPick> readAndPicks = new ArrayList<>();

    private  ArrayLists() { }

    public ArrayList<Accounts> getAccountList() {
        return accounts;
    }

    public ArrayList<Animals> getCattleList() {
        return cattle;
    }

    public ArrayList<Animals> getMarketAnimalList() {
        return market;
    }

    public ArrayList<Contacts> getContactList() {
        return contacts;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctors;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointments;
    }

    public ArrayList<EduReadEasy> getEduReadEasyList() {
        return eduRead;
    }

    public ArrayList<EduReadMedium> getEduReadMediumList() {
        return eduReadM;
    }

    public ArrayList<EduReadHard> getEduReadHardList() { return eduReadH; }

    public ArrayList<HighScores> getMathHighScoreList() { return mathHighScores; }

    public ArrayList<String> getWriteWordsList() { return wordWrite; }

    public ArrayList<Medicine> getMedicineList() { return medicines; }

    public ArrayList<CorrectSum> getCorrectSumsList() {
        return correctSums;
    }

    public  ArrayList<ReadAndPick> getReadAndPicksList(){return readAndPicks;}

    public void addAccount(Accounts account) {
        accounts.add(account);
    }

    public void addCattle(Animals animal) {
        cattle.add(animal);
    }

    public void addToMarket(Animals animal) {
        market.add(animal);
    }

    public void addContact(Contacts contact) {
        contacts.add(contact);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addMathHighScore(HighScores highscore) { mathHighScores.add(highscore); }

    public void addEduReadEasy (EduReadEasy eduReadEasy) {
        eduRead.add(eduReadEasy);
    }

    public void addEduReadMedium (EduReadMedium eduReadMedium) {
        eduReadM.add(eduReadMedium);
    }

    public void addEduReadHard(EduReadHard eduReadHard){eduReadH.add(eduReadHard);}

    public void addEduWriteWords(String word){wordWrite.add(word);}

    public void addCorrectSum(CorrectSum correctSum) { correctSums.add(correctSum); }

    public void addMedicine (Medicine medicine) { medicines.add(medicine); }

    public void addReadAndPick(ReadAndPick readAndPick){readAndPicks.add(readAndPick);}

    public Accounts getAccount (int index) {
       return accounts.get(index);
    }

    public Animals getCattle(int index) {
        return cattle.get(index);
    }

    public Animals getMarketAnimal(int index) { return market.get(index); }

    public Contacts getContact (int index) {
        return contacts.get(index);
    }

    public Doctor getDoctor(int index) {
        return doctors.get(index);
    }

    public Appointment getAppointment(int index) {
        return appointments.get(index);
    }

    public HighScores getMathHighScore (int index) {
        return mathHighScores.get(index);
    }

    public Medicine getMedicine (int index) {
        return medicines.get(index);
    }

    public void addEasyWrite (String string) { easyWrite.add(string);}

    public void addMediumWrite (String string) { mediumWrite.add(string);}

    public void addHardWrite (String string) { hardWrite.add(string);}

    public String getEasyWrite(int index){ return easyWrite.get(index);}

    public String getMediumWrite(int index){ return mediumWrite.get(index);}

    public String getHardWrite(int index){ return hardWrite.get(index);}

    public EduReadEasy getEduReadEasy(int index) {
        return eduRead.get(index);
    }

    public EduReadMedium getEduReadMedium(int index) {
        return eduReadM.get(index);
    }

    public EduReadHard getEduReadHard(int index){ return eduReadH.get(index);}

    public String getWriteWords (int index) {
        return wordWrite.get(index);
    }

    public CorrectSum getCorrectSum(int index) {
        return correctSums.get(index);
    }

    public ReadAndPick getReadAndPick(int index){return readAndPicks.get(index);}

    public static ArrayLists getOnlyInstance() {
        return onlyInstance;
    }

        public void addAll() {
            defaultElements();
            defaultDoctors();
            defaultSentences();
            defaultReadEasy();
            defaultReadMedium();
            defaultReadHard();
            defaultAppointments();
            defaultHighScores();
            defaultMedicine();
            defaultWords();
            defaultReadAndPick();
        }

        public void defaultElements() {
            addAccount(new Accounts("TVS23", 1960, "Moderator",
                    "The Netherlands", "123", "4567", "0653129198"));
            addAccount(new Accounts("TVS22", 1980, "Testacc",
                    "The Netherlands", "123", "4567", "0612345678"));
            addAccount(new Accounts("TVS24", 1964, "Tracey",
                    "The Netherlands", "123", "4567", "0612345678"));
            addAccount(new Accounts("HHS23", 1982, "Carl",
                    "The Netherlands", "123", "4567", "0612345678"));
            addAccount(new Accounts("JWP22", 1956, "Matt",
                    "The Netherlands", "123", "4567", "0612345678"));
            addAccount(new Accounts("TUD21", 1974, "Jack",
                    "The Netherlands", "123", "4567", "0612345678"));
            addAccount(new Accounts("ADR20", 1978, "Donald",
                    "The Netherlands", "123", "4567", "0612345678"));
            addContact(new Contacts("21st Street 1", 1999, "Kris", "Moderator"));
            addContact(new Contacts("Gansplein 4", 1932, "Paul", "Moderator"));
            addCattle(new Pig("Pig", "Piggie", "Male", "Pink", 100, "Moderator"));

            Pig pig1 = new Pig("Pig", "Joopie", "Female", "Pink", 80, "Moderator");
            Sheep sheep1 = new Sheep("Sheep", "Meeehhhee", "Male", "White", 100, "Moderator");
            Goat goat1 = new Goat("Goat", "Beeee", "Female", "Grey", 40, "Moderator");
            pig1.setPrice(150);
            sheep1.setPrice(500);
            goat1.setPrice(350);
            addToMarket(pig1);
            addToMarket(sheep1);
            addToMarket(goat1);
        }

        public void defaultDoctors() {
            Doctor doctor1 = new Doctor("TVS24", 1964, "doctor1", "Tracey", "X", "", "", "");
            Doctor doctor2 = new Doctor("HHS23", 1982, "doctor2", "Carl", "", "X", "", "");
            Doctor doctor3 = new Doctor("JWP22", 1956, "doctor3", "Matt", "", "", "X", "");
            Doctor doctor4 = new Doctor("TUD21", 1974, "doctor4", "Jack", "", "", "", "X");
            Doctor doctor5 = new Doctor("ADR20", 1978, "doctor5", "Donald", "X", "X", "", "X");
            addDoctor(doctor1);
            addDoctor(doctor2);
            addDoctor(doctor3);
            addDoctor(doctor4);
            addDoctor(doctor5);
        }

        public void defaultSentences() {
            addEasyWrite("This is an easy sentence.");
            addEasyWrite("The cat is red.");
            addEasyWrite("You're finished! Press the stop button quick!");
            addMediumWrite("This is a medium sentence, so slightly harder.");
            addMediumWrite("The difficult quiz was taken by the professor.");
            addMediumWrite("You're finished! Press the stop button quickly!");
            addHardWrite("This is a really hard, difficult, complex sentence.");
            addHardWrite("Unless you find the evidence against my client absolutely incontrovertible, you must declare her not guilty of this charge.");
            addHardWrite("You did it! Press the stop button quick!");
        }

        public void defaultMedicine() {
            Medicine medicine1 = new Medicine("Jon", "Tracey", "", "X", "X", "X", "", "X", "X", "");
            Medicine medicine2 = new Medicine("Moderator", "Tracey", "X", "X", "", "X", "", "X", "X", "");
            addMedicine(medicine1);
            addMedicine(medicine2);
        }

        public void defaultWords() {
            addEduWriteWords("Dog");
            addEduWriteWords("Cat");
            addEduWriteWords("Mouse");
            addEduWriteWords("Gorilla");
            addEduWriteWords("Shark");
            addEduWriteWords("Sparrow");
            addEduWriteWords("Seagull");
            addEduWriteWords("Tiger");
            addEduWriteWords("Bear");
            addEduWriteWords("Pig");
        }

        public void defaultReadEasy() {
            EduReadEasy one = new EduReadEasy("What does the boy have?", "Rat", "Dog", "Cat", "Lion", "Dog");
            addEduReadEasy(one);
            EduReadEasy two = new EduReadEasy("What color is the dog?", "Black with a white spot", "White with a black spot", "Red with a blue spot", "Orange with a yellow spot", "White with a black spot");
            addEduReadEasy(two);
            EduReadEasy three = new EduReadEasy("How big is the ball?", "Huge", "Little", "Tiny", "Big", "Little");
            addEduReadEasy(three);
            EduReadEasy four = new EduReadEasy("Why does the dog run fast?", "To catch the ball", "To run away", "To run to his owner", "For food", "To catch the ball");
            addEduReadEasy(four);
        }

        public void defaultReadMedium() {
            EduReadMedium one = new EduReadMedium("Who was brave?", "Captain and his crew", "Wilma", "Boat", "clear morning", "Captain and his crew");
            addEduReadMedium(one);
            EduReadMedium two = new EduReadMedium("Why was the trip getting dull?", "They couldn't find Wilma", "It was cold", "The ocean was dull", "It was clear morning", "The ocean was dull");
            addEduReadMedium(two);
            EduReadMedium three = new EduReadMedium("Why was their course correct?", "According to map ", "According to gps", "They've seen Wilma there before", "According to spyglass", "They've seen Wilma there before");
            addEduReadMedium(three);
            EduReadMedium four = new EduReadMedium("Why did Wilma do flip?", "To break the ship", "To swim away", "To say bye", "To say hi", "To say hi");
            addEduReadMedium(four);
        }

        public void defaultReadHard() {
            EduReadHard one = new EduReadHard("What is the girl's name?", "Not Sarah", "Not Nancy", "Nancy", "Sarah", "Nancy");
            addEduReadHard(one);
            EduReadHard two = new EduReadHard("How old is she?", "11", "12", "13", "6", "11");
            addEduReadHard(two);
            EduReadHard three = new EduReadHard("At what school she goes?", "Beantrix Potter School", "Belatrix Potter school", "Belantrix Potter School", "Beatrix Potter School", "Belatrix Potter School");
            addEduReadHard(three);
            EduReadHard four = new EduReadHard("What doesn't she study?", "Math", "Science", "Art", "English", "Art");
            addEduReadHard(four);
            EduReadHard five = new EduReadHard("What does she eat at the first break?", "Sandwich", "Crisps", "Vegetables", "Burger", "Sandwich");
            addEduReadHard(five);
        }


        public void defaultAppointments() {
            Appointment appointment = new Appointment("Tracey", "TVS24", "Moderator", "Test", LocalDate.of(2021, 10, 12), LocalTime.of(9, 30));
            Appointment appointment1 = new Appointment("Carl", "HHS23", "Moderator", "Test2", LocalDate.of(2020, 4, 9), LocalTime.of(14, 0));
            addAppointment(appointment);
            addAppointment(appointment1);
        }

        public void defaultHighScores() {
            HighScores highScore1 = new HighScores(6, "Moderator");
            HighScores highScore2 = new HighScores(12, "Matt");
            addMathHighScore(highScore1);
            addMathHighScore(highScore2);
        }

        public void defaultReadAndPick() {
            Image image1 = new Image("/zeroXessApp/Pictures/Girl.png", true);
            ReadAndPick test1 = new ReadAndPick("Doll", image1);
            addReadAndPick(test1);
            Image image2 = new Image("/zeroXessApp/Pictures/Whale.png", true);
            ReadAndPick test2 = new ReadAndPick("Whale", image2);
            addReadAndPick(test2);
            Image image3 = new Image("/zeroXessApp/Pictures/Dog.png", true);
            ReadAndPick test3 = new ReadAndPick("Dog", image3);
            addReadAndPick(test3);
            Image image4 = new Image("/zeroXessApp/Pictures/Horse.png", true);
            ReadAndPick test4 = new ReadAndPick("Horse", image4);
            addReadAndPick(test4);
            Image image5 = new Image("/zeroXessApp/Pictures/Donkey.png", true);
            ReadAndPick test5 = new ReadAndPick("Donkey", image5);
            addReadAndPick(test5);
            Image image6 = new Image("/zeroXessApp/Pictures/Rabbit.png", true);
            ReadAndPick test6 = new ReadAndPick("Rabbit", image6);
            addReadAndPick(test6);
            Image image7 = new Image("/zeroXessApp/Pictures/Bat.png", true);
            ReadAndPick test7 = new ReadAndPick("Bat", image7);
            addReadAndPick(test7);
            Image image8 = new Image("/zeroXessApp/Pictures/Cat.png", true);
            ReadAndPick test8 = new ReadAndPick("Cat", image8);
            addReadAndPick(test8);
        }
}
