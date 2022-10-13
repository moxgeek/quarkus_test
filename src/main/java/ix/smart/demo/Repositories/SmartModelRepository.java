package ix.smart.demo.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ix.smart.demo.Entities.SmartModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped

public class SmartModelRepository implements PanacheRepository<SmartModel> {
}
