import java.util.Scanner; 

public class ErrorHandling {
    public static void main(String[] args) {
        handleInput();
    }

    public static void handleInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a value: ");

        try {
            double inputValue = Double.parseDouble(userInput.nextLine());
            if (inputValue == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            double inverseValue = 1 / inputValue;
            System.out.println("Inverse: " + inverseValue);
        } catch (NumberFormatException error) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (ArithmeticException error) {
            System.out.println(error.getMessage());
        } finally {
            userInput.close();
        }
    }
}
