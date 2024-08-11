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
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1105); // Create RMI registry on port 1105
            CalculatorImplementation calc = new CalculatorImplementation();
            Naming.rebind("CalculatorService", calc);
            System.out.println("Calculator Server is up and running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


