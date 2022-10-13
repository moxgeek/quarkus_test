package trash_model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SmartFeature")
@DiscriminatorValue("smart_feature")
public class SmartFeature extends SmartEntity implements ICategory {
}