package thread.producerconsumer;

import java.util.Date;

public class IPhoneBox {
    private IPhone iPhone;
    private Date packagedDate;
    public IPhone getiPhone() {
        return iPhone;
    }
    public void setiPhone(IPhone iPhone) {
        this.iPhone = iPhone;
    }
    public Date getPackagedDate() {
        return packagedDate;
    }
    public void setPackagedDate(Date packagedDate) {
        this.packagedDate = packagedDate;
    }
    
}
