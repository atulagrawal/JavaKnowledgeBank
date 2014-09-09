package algorithm.ds.stack;

public class SimpleArrayStackTest {
    public static void main(String args[]) {
        Stack stack = new ArrayListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println("SIZD" + stack.size());
        System.out.println(stack.pop());
        System.out.println("SIZD" + stack.size());
        System.out.println(stack.pop());
        System.out.println("SIZD" + stack.size());
        System.out.println(stack.pop());
        System.out.println("SIZD" + stack.size());
        System.out.println(stack.pop());
        System.out.println("SIZD" + stack.size());
        
    }
}
