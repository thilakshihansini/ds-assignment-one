package Calculator;

/**
 *
 * @author thilakshihansini
 */

//import packages
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Calculator calculator = new CalculatorImplementation();
            Registry registry = LocateRegistry.createRegistry(3008);//Create RMI registry on port 3008
            registry.rebind("CalculatorService", calculator);
            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
