package algorithm.ds.stack; 

public class SimpleArrayStack implements Stack<Integer> {
    private Integer[] stack;
    private Integer top;
    private Integer maxSize;
    public SimpleArrayStack(Integer size) {
        stack = new Integer[size];
        maxSize = size;
        top=-1;
    }

    @Override
    public void push(Integer value) {
        if((top+1)<maxSize) {
            top++;
            stack[top]=value;
           
        }
    }

    @Override
    public Integer pop() {
        if(top >=0) {
            Integer value = stack[top];
            top--;
        return value;
        } else {
            return null;
        }
    }

    @Override
    public Integer size() {
       return top+1;
    }

}
