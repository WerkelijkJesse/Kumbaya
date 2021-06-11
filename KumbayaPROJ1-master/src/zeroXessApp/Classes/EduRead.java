package zeroXessApp.Classes;

public abstract class EduRead {
    public String question;
    public String spot1;
    public String spot2;
    public String spot3;
    public String spot4;
    public String answer;

    public EduRead(String question, String spot1, String spot2, String spot3, String spot4, String answer) {
        this.question = question;
        this.spot1 = spot1;
        this.spot2 = spot2;
        this.spot3 = spot3;
        this.spot4 = spot4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSpot1() {
        return spot1;
    }

    public void setSpot1(String spot1) {
        this.spot1 = spot1;
    }

    public String getSpot2() {
        return spot2;
    }

    public void setSpot2(String spot2) {
        this.spot2 = spot2;
    }

    public String getSpot3() {
        return spot3;
    }

    public void setSpot3(String spot3) {
        this.spot3 = spot3;
    }

    public String getSpot4() {
        return spot4;
    }

    public void setSpot4(String spot4) {
        this.spot4 = spot4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
