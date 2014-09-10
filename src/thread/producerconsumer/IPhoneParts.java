package thread.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class IPhoneParts {
    List<String> items;
    
    public IPhoneParts() {
        items = new ArrayList<>();
        init();
    }
    
    private void init() {
        for (int i = 0; i < 5; i++) {
            items.add("Part" + i);            
        }
    }
}
