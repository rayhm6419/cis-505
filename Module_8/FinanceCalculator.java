package Module_8;

public class FinanceCalculator {
    private static final int MONTHS_IN_YEAR = 12;

    // b. Static method to calculate future value
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        // c. Calculate the number of months
        int months = years * MONTHS_IN_YEAR;

        // d. Calculate interest rate from Exhibit A
        double interestRate = 1 + rate / 100;

        // e. Calculate present value
        double presentValue = monthlyPayment * months;

        // f. Calculate future value from Exhibit B
        double futureValue = presentValue * Math.pow(interestRate, months);

        // g. Return future value
        return futureValue;
    }
}
