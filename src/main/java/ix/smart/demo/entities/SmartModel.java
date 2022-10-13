package ix.smart.demo.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "smart_category")
public class SmartModel extends PanacheEntity implements MetaModel{


    @Column
    public String name;
    @Column
    public String identifier;
    @Column
    public String description;

    // I chose to use MetaModel instead of SmartFeature, because i think
    // in terms of scalability, we can see a device has list of devices
    // and service has a list of service. Composite pattern
    @Column
    @OneToMany
    public List<SmartFeature> features = new ArrayList<>();


    public SmartModel(String name, String identifier, String description){
        this.name = name;
        this.identifier = identifier;
        this.description = description;
    }

    public SmartModel() {

    }


    @Override
    public MetaModel addRangeSmartModel(List<SmartFeature> metaModels) throws LogicNotYetImplemented {
        //TODO maybe you need to double-check each row if it's an instance of smartFeature
        if (metaModels != null)
            features.addAll(metaModels);
        else
            throw new LogicNotYetImplemented();

        return this;

    }

    @Override
    public MetaModel addOneSmartModel(SmartFeature metaModel) throws LogicNotYetImplemented {
        if (metaModel instanceof SmartFeature)
            features.add(metaModel);
        else
            throw new LogicNotYetImplemented();

        return this;
    }
    @Override
    public void doAction() {
        System.out.println("name:".concat(this.name).concat(" identifier:").concat(this.identifier));

    }


    // this class is related to some cases that was not described, but it makes sense
    // as add device in a device ( embedded IOT )
    // add service into service ( third part services )
    // ....
    public static class LogicNotYetImplemented extends Exception{


    }

}


