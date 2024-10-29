import java.util.Scanner;

public class CreditCardValidator {

    private long ccNumber; // Credit card number

    // Constructor to initialize the credit card number
    public CreditCardValidator(long ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validateCard() {
        long tempNumber = ccNumber;
        int lastDigit = (int) (tempNumber % 10); // Step a: Last digit extraction
        tempNumber = tempNumber / 10; // Remaining number

        System.out.println("Step a: Last digit = " + lastDigit + ", remaining number = " + tempNumber);

        // Step b: Reverse the remaining number
        String reversed = new StringBuilder(String.valueOf(tempNumber)).reverse().toString();
        System.out.println("Step b: Reversed number = " + reversed);

        // Step c: Double the odd-positioned digits (starting from index 0)
        StringBuilder doubledResult = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            int digit = Character.getNumericValue(reversed.charAt(i));
            if (i % 2 == 0) { // Odd position (index 0, 2, 4...), double it
                int doubledDigit = digit * 2;
                doubledResult.append(doubledDigit);
            } else { // Even position, keep it as is
                doubledResult.append(digit);
            }
        }

        String doubledOddPosition = doubledResult.toString();
        System.out.println("Step c: After doubling odd-positioned digits = " + doubledOddPosition);

        // Step d: Sum all digits of the new number
        int sum = 0;
        for (int i = 0; i < doubledOddPosition.length(); i++) {
            sum += Character.getNumericValue(doubledOddPosition.charAt(i));
        }
        System.out.println("Step d: Sum of all digits = " + sum);

        // Step e: Compute 10 - (sum % 10)
        int result = 10 - (sum % 10);
        if (result == 10) {
            result = 0; // If the result is 10, we make it 0
        }
        System.out.println("Step e: 10 - (sum % 10) = " + result);

        // Step f: Validate if result matches last digit
        if (lastDigit == result) {
            System.out.println("Step f: Valid card.");
        } else {
            System.out.println("Step f: Invalid card.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the credit card number: ");
        long ccNumber = scanner.nextLong();
        CreditCardValidator validator = new CreditCardValidator(ccNumber);
        validator.validateCard();
    }
}