package ix.smart.demo.DAO;

import ix.smart.demo.Entities.SmartFeature;
import ix.smart.demo.Entities.SmartModel;
import ix.smart.demo.Repositories.SmartModelRepository;
import ix.smart.grpc.SmartModelRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped

public class SmartModelDbService implements DbService<SmartModel> {


    private final SmartModelRepository smartModelRepository;
    private final SmartFeatureService smartFeatureService;

    @Inject
    public SmartModelDbService(SmartModelRepository smartModelRepository, SmartFeatureService smartFeatureService) {
        this.smartModelRepository = smartModelRepository;
        this.smartFeatureService = smartFeatureService;
    }

    //  it will be greate to have some parser for the DBServices from GrpcRequests to Model and then to GrpsResponse
    // TODO ....
    @Override
    public SmartModel add(SmartModel smartModel) {
        smartModelRepository.persist(smartModel);
        if (smartModel.features!=null && smartModel.features.size()>0)
            for (SmartFeature smartFeature:
                 smartModel.features) {
                smartFeatureService.add(smartFeature);
            }
        return smartModel;
    }

    @Override
    public Boolean delete(Long id) {
        return smartModelRepository.deleteById(id);
    }

    @Override
    public SmartModel findOneById(Long id) {
        return smartModelRepository.findById(id);
    }

    @Override
    public SmartModel findOneByName(String name) {
        return smartModelRepository.find("name",name).firstResult();
    }

    @Override
    public List<SmartModel> findAll() {
        return smartModelRepository.listAll();
    }

    public SmartModel attachFeature(Long id, SmartFeature feature) throws SmartModel.LogicNotYetImplemented {
        SmartModel smartModel = smartModelRepository.findById(id);
        smartModel.addOneSmartModel(feature);
        smartModel.persistAndFlush();
        return smartModel;
    }



}
