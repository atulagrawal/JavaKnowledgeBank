package algorithm.ds.problem;


/*
 * Find if the given expression contains redundant parantheses. ex :if expr = a+(b*c) , print 
 * false, if expr = a+((b*c)), print true.
 */
public class Problem1 {
    public static void main(String args[]) {
        String exp1 = "a+(b*c)";
        String exp2 = "a+((b*c))";
        System.out.println(evaluate(exp1));
        System.out.println(evaluate(exp2));
    }
    
    private static boolean evaluate(String exp) {
        char[] expression = exp.toCharArray();
        for (int i = 0; i < expression.length -1; i++) {
            if(isParanthesis(expression[i]) && (expression[i]==expression[++i])) return true;
        }
        
        return false;
    }
    
    private static boolean isParanthesis(char alphabet) {
        if(alphabet=='(' || alphabet==')') return true;
        return false;
    }
}
