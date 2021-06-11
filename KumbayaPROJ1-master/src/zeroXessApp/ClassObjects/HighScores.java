package zeroXessApp.ClassObjects;

public class HighScores {

    private Integer score;
    private String user;

    public HighScores (Integer score, String user) {
        this.score = score;
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public String getUser() {
        return user;
    }
}
