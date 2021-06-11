package zeroXessApp.Classes;

public class EduMathCheckResult {

    public static String plus(int getal1, int getal2, String resultaat) {
        return check(getal1, getal2, new PlusCalculation(), resultaat);
    }

    public static String minus(int getal1, int getal2, String resultaat) {
        return check(getal1, getal2, new MinusCalculation(), resultaat);
    }

    public static String multiply(int getal1, int getal2, String resultaat) {
        return check(getal1, getal2, new MultiplyCalculation(), resultaat);
    }

    public static String divide(int getal1, int getal2, String resultaat) {
        return check(getal1, getal2, new DivideCalculation(), resultaat);
    }

    public static String check (int getal1, int getal2, Calculation calculation, String resultaat) {
        try {
            if (resultaat.equals("")) {
                return "Fill in your answer";
            }
            else {
                if (Integer.parseInt(resultaat) == calculation.calculation(getal1, getal2))
                    return "Excellent!";
            }
        }
        catch (Exception e) {
            return "Fill in a numeric answer"; // NullPointerException
        }
        return "Incorrect!";
    }

    public static String checkSign(String sign, int getal1, int getal2, String resultaat) {
        String message = "";
        if (sign.equals("+")) {
            message = plus(getal1, getal2, resultaat);
        } else if (sign.equals("-")) {
            message = minus(getal1, getal2, resultaat);
        } else if (sign.equals("x")) {
            message = multiply(getal1, getal2, resultaat);
        } else if (sign.equals("/")) {
            message = divide(getal1, getal2, resultaat);
        }
        return message;
    }


}
