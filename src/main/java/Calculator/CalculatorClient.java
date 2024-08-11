package Calculator;

/**
 *
 * @author thilakshihansini
 */

//import packages
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry for port 3008
            Registry registry = LocateRegistry.getRegistry("localhost", 3008);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Please Choose an option:");
                System.out.println("1. Push Value");
                System.out.println("2. Perform Operation (min, max, lcm, gcd)");
                System.out.println("3. Pop Value");
                System.out.println("4. Delay Pop");
                System.out.println("5. Check if Stack is Empty");
                System.out.println("6. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: //Performance for case 1
                        System.out.print("Enter an integer value: ");
                        int value = scanner.nextInt();
                        calculator.pushValue(value);
                        System.out.println("Value pushed to stack.");
                        break;

                    case 2: //performance for case 2
                        System.out.print("Enter an operation (min, max, lcm, gcd): ");
                        String operation = scanner.next();
                        calculator.pushOperation(operation);
                        System.out.println("Operation performed and result pushed to stack.");
                        break;

                    case 3: //performance for case 3
                        if (!calculator.isEmpty()) {
                            int poppedValue = calculator.pop();
                            System.out.println("Popped value: " + poppedValue);
                        } else {
                            System.out.println("Stack is empty.");
                        }
                        break;

                    case 4: //performance for case 4
                        System.out.print("Enter delay in milliseconds before popping: ");
                        int millis = scanner.nextInt();
                        int delayedPoppedValue = calculator.delayPop(millis);
                        System.out.println("Popped value after delay: " + delayedPoppedValue);
                        break;

                    case 5://performance for case 5
                        boolean empty = calculator.isEmpty();
                        System.out.println("Stack is empty: " + empty);
                        break;

                    case 6: //performance for case 6
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    default: //performance for default case
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
