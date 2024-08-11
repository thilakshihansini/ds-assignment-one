/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

/**
 *
 * @author thilakshihansini
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private static final long serialVersionUID = 1L;
    private Stack<Integer> stack;

    public CalculatorImplementation() throws RemoteException {
        stack = new Stack<>();
    }

    @Override
    public synchronized void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    @Override
    public synchronized void pushOperation(String operator) throws RemoteException {
        List<Integer> values = new ArrayList<>();
        while (!stack.isEmpty()) {
            values.add(stack.pop());
        }

        switch (operator) {
            case "min":
                stack.push(Collections.min(values));
                break;
            case "max":
                stack.push(Collections.max(values));
                break;
            case "lcm":
                stack.push(lcm(values));
                break;
            case "gcd":
                stack.push(gcd(values));
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    @Override
    public synchronized int pop() throws RemoteException {
        if (stack.isEmpty()) {
            throw new RemoteException("Stack is empty.");
        }
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
            throw new RemoteException("Thread interrupted during delay", e);
        }
        return pop();
    }

    private int gcd(List<Integer> values) {
        return values.stream().reduce(this::gcd).orElseThrow(IllegalArgumentException::new);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(List<Integer> values) {
        return values.stream().reduce(this::lcm).orElseThrow(IllegalArgumentException::new);
    }

    private int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}


