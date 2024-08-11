/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

/**
 *
 * @author thilakshihansini
 */
import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Please Enter command (pushValue, pushOperation, pop, isEmpty, delayPop, exit):");
                String command = scanner.nextLine();

                switch (command) {
                    case "pushValue":
                        System.out.println("Please Enter integer value:");
                        int value = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        calc.pushValue(value);
                        break;
                    case "pushOperation":
                        System.out.println("Please Enter operation (min, max, lcm, gcd):");
                        String operation = scanner.nextLine();
                        calc.pushOperation(operation);
                        break;
                    case "pop":
                        System.out.println("Popped value is: " + calc.pop());
                        break;
                    case "isEmpty":
                        System.out.println("Is stack empty: " + calc.isEmpty());
                        break;
                    case "delayPop":
                        System.out.println("Enter delay in milliseconds:");
                        int millis = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Delayed pop value: " + calc.delayPop(millis));
                        break;
                    case "exit":
                        scanner.close();
                        return;
                    default:
                        System.out.println("Please enter Valid Command.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


