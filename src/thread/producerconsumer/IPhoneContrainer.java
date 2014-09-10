package thread.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class IPhoneContrainer {
    List<IPhoneBox> boxes;
    public IPhoneContrainer() {
        boxes = new ArrayList<>();
    }
    
    public void add(IPhoneBox iPhoneBox) {
        boxes.add(iPhoneBox);
    }
    
    public int totalBoxes() {
        return boxes.size();
    }
}
