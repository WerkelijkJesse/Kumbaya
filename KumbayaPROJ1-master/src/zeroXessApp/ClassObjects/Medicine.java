package zeroXessApp.ClassObjects;

public class Medicine {

    private String name;
    private String doctor;
    private String m1;
    private String m2;
    private String m3;
    private String m4;
    private String m5;
    private String m6;
    private String m7;
    private String m8;

    public Medicine(String name, String doctor, String m1, String m2, String m3, String m4, String m5, String m6, String m7, String m8) {
        this.name = name;
        this.doctor = doctor;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
        this.m7 = m7;
        this.m8 = m8;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctor(){
        return doctor;
    }

    public String getM1() {
        return m1;
    }

    public String getM2() {
        return m2;
    }

    public String getM3() {
        return m3;
    }

    public String getM4() {
        return m4;
    }

    public String getM5() {
        return m5;
    }

    public String getM6() {
        return m6;
    }

    public String getM7() {
        return m7;
    }

    public String getM8() {
        return m8;
    }
}
