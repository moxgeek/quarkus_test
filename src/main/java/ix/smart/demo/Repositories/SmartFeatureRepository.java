package ix.smart.demo.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ix.smart.demo.Entities.SmartFeature;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SmartFeatureRepository implements PanacheRepository<SmartFeature> {
}
