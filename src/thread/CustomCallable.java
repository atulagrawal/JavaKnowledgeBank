package thread;
import java.util.concurrent.Callable;


public class CustomCallable implements Callable<Integer> {
    private Integer idx;
    public CustomCallable(Integer idx) {
        this.idx=idx;
        
    }
    @Override
    public Integer call() throws Exception {
        if(idx==10) {
            System.out.println("IDX is correct");
            return idx;
        } else {
            throw new Exception("IDX is not correxct");
        }
    }

}
