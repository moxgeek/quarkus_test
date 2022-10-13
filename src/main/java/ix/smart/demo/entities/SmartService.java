package ix.smart.demo.Entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SmartService")
@DiscriminatorValue("smart_service")
public class SmartService extends SmartModel {

    @Column(length = 255)
    String url;
    @Column(length = 5)
    String protocol;
    public SmartService(String name, String identifier, String description, String url, String protocol) {
        super("Service:"+name, identifier, description);
        this.url = url;
        this.protocol = protocol;
    }

    public SmartService(){
        super();
    }

    @Override
    public void doAction() {
        System.out.println("Smart Service :");
        System.out.println("url :"+this.url);
        System.out.println("protocol :"+this.protocol);
        super.doAction();
    }
}