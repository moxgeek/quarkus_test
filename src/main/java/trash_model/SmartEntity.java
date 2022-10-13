package trash_model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "smart_category")
public class SmartEntity extends PanacheEntity {


    @Column(name = "name",
            length = 100)
    public String name;
    public String identifier;
    public String description;

}
