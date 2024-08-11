package Calculator;

/**
 *
 * @author thilakshihansini
 */

//import packages
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;

    protected CalculatorImplementation() throws RemoteException {
        stack = new Stack<>();
    }

    @Override
    public synchronized void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    @Override
    public synchronized void pushOperation(String operator) throws RemoteException {
        int result;
        switch (operator) {
            case "min":
                result = stack.stream().min(Integer::compare).get();
                break;
            case "max":
                result = stack.stream().max(Integer::compare).get();
                break;
            case "lcm":
                result = lcm(stack);
                break;
            case "gcd":
                result = gcd(stack);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        stack.clear();
        stack.push(result);
    }

    @Override
    public synchronized int pop() throws RemoteException {
        return stack.pop();
    }

    @Override
    public synchronized boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public synchronized int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return pop();
    }

    private int gcd(Stack<Integer> stack) {
        return stack.stream().reduce(this::gcd).get();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(Stack<Integer> stack) {
        return stack.stream().reduce(1, this::lcm);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
