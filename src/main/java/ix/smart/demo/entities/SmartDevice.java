package ix.smart.demo.Entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SmartDevice")
@DiscriminatorValue("smart_device")
public class SmartDevice extends SmartModel {

    // brand for the IOT ( maybe dosnt make sens but i see it like arduino or raspberrypi , omega ... )
    @Column(length = 50)
    public String brandName;
    public SmartDevice(String name, String identifier, String description,String brandName) {
        super("Device:"+name, identifier, description);
        this.brandName = brandName;
    }

    public SmartDevice() {
        super();
    }


    @Override
    public void doAction() {
        System.out.println("Smart Device :");
        System.out.println("url :"+this.brandName);
        super.doAction();
    }
}
