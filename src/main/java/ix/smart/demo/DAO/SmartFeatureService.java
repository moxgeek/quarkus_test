package ix.smart.demo.DAO;

import ix.smart.demo.Entities.SmartFeature;
import ix.smart.demo.Repositories.SmartFeatureRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
@ApplicationScoped

public class SmartFeatureService implements DbService<SmartFeature>{

    private final SmartFeatureRepository smartFeatureRepository;

    @Inject
    public SmartFeatureService(SmartFeatureRepository smartFeatureRepository) {
        this.smartFeatureRepository = smartFeatureRepository;
    }

    @Override
    public SmartFeature add(SmartFeature smartFeature) {
        smartFeatureRepository.persist(smartFeature);
        return smartFeature;
    }

    @Override
    public Boolean delete(Long id) {
        return smartFeatureRepository.deleteById(id);
    }

    @Override
    public SmartFeature findOneById(Long id) {
        return smartFeatureRepository.findById(id);
    }

    @Override
    public SmartFeature findOneByName(String name) {
        return smartFeatureRepository.find("name",name).firstResult();
    }

    @Override
    public List<SmartFeature> findAll() {
        return smartFeatureRepository.listAll();
    }

}
