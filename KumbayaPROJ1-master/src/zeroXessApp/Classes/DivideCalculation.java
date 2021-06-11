package zeroXessApp.Classes;

public class DivideCalculation implements Calculation {
    public int calculation(int getal1, int getal2) {
        if (getal2 == 0) {
            return 0;
        }
        return getal1 / getal2;
    }
}
