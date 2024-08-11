package Calculator;

/**
 *
 * @author thilakshihansini
 */

//import packages
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    //Push Value method is using to add an integer value to a remote stack or collection
    void pushValue(int val) throws RemoteException;

    //Push Operation method Allow adding elements to the stack
    void pushOperation(String operator) throws RemoteException;

    //pop method is pop the top of the stack and return it to the client.
    int pop() throws RemoteException;

    //is Empty method return true if the stack is empty, false otherwise. Therefore it type is boolean
    boolean isEmpty() throws RemoteException;

    //delaypop method wait milliseconds before carrying out the pop operation
    int delayPop(int millis) throws RemoteException;
}
