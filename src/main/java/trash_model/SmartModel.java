package trash_model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SmartModel")
@DiscriminatorValue("smart_model")
public class SmartModel extends SmartEntity implements ICategory {

}
