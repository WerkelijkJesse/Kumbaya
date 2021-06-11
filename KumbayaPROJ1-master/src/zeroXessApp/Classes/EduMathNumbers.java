package zeroXessApp.Classes;

public class EduMathNumbers {

    public static double randomNumbers(double min, double max) {
        return ((Math.random() * ((max - min) + 1)) + min);
    }

    public static boolean checkNumbers(String operator, int getal1, int getal2) {
        if (operator.equals("-")) {
            return checkMinus(getal1, getal2);
        } else if (operator.equals("/")) {
            return checkDivide(getal1, getal2);
        } return false;
    }

    public static boolean checkDivide(int getal1, int getal2) {
        if (getal1 % getal2 != 0) {
            return true;
        } return false;
    }

    public static boolean checkMinus(int getal1, int getal2) {
        if (getal1 < getal2) {
            return true;
        } return false;
    }

}
