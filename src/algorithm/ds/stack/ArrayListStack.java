package algorithm.ds.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack<T> implements Stack<T> {
    private List<T> stack;
    Integer top;
    public ArrayListStack() {
       stack = new ArrayList<>();
       top=-1;
    }
    @Override
    public T pop() {
        if(top>0) {
            top--;
            return stack.get(top);
        }
        return null;
      
    }

    @Override
    public void push(T value) {
        top++;
        stack.add(value);
        
    }

    @Override
    public Integer size() {
        return stack.size();
    }

}
