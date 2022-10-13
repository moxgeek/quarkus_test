package ix.smart.demo.Entities;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Entity
public class SmartFeature extends PanacheEntity implements MetaModel {


    public String name;
    public String identifier;


    public SmartFeature(String name, String identifier){
        this.name = name;
        this.identifier = identifier;
    }

    public SmartFeature() {

    }


    //even for smart Feature, it can have a least of features
    // ex :  Search Movie can get Search Movie by popularity , or by year ... as a feature

    // throwing notYetImplemented Exception for the moment
    // even if i cannot see why a feature will have a list of features,
    // however, it can make sens in terms of scalability
    // ex : feature : watch video, features : [blur frame , grayscale image, reduce FPS ]
    @Override
    public MetaModel addOneSmartModel(SmartFeature metaModel) throws NoSuchAlgorithmException {
      throw new NoSuchAlgorithmException();

    }


    @Override
    public MetaModel addRangeSmartModel(List<SmartFeature> metaModels) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException();
    }

    @Override
    public void doAction() {
        System.out.println("Smart Feature :");
        System.out.println("name:".concat(this.name).concat(" identifier:").concat(this.identifier));
    }
}
