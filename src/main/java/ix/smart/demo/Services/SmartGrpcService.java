package ix.smart.demo.Services;

import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import ix.smart.demo.DAO.SmartFeatureService;
import ix.smart.demo.DAO.SmartModelDbService;
import ix.smart.demo.Entities.SmartDevice;
import ix.smart.demo.Entities.SmartFeature;
import ix.smart.demo.Entities.SmartModel;
import ix.smart.demo.Entities.SmartService;
import ix.smart.grpc.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@GrpcService
public class SmartGrpcService implements ix.smart.grpc.SmartGrpcService{

    private final SmartFeatureService smartFeatureService;
    private final SmartModelDbService smartModelDbService;

    @Inject
    public SmartGrpcService(SmartFeatureService smartFeatureService, SmartModelDbService smartModelDbService) {
        this.smartFeatureService = smartFeatureService;
        this.smartModelDbService = smartModelDbService;
    }

    @Override
    public Uni<SmartModelResponse> addNewModel(SmartModelRequest request) {

        if (request == null)
            return null;
        SmartModel smartModel = null;
        //TODO better to put everything to a parser inside the service itself without dealing with managing instances

        if (request.getCategory().getNumber() == 0)
            smartModel = new SmartDevice(request.getName(),request.getIdentifier(),request.getDescription(),request.getDeviceBrandName());
        else
            smartModel = new SmartService(request.getName(),request.getIdentifier(),request.getDescription(),request.getServiceUrl(),request.getServiceProtocol());

        this.smartModelDbService.add(smartModel);


        return Uni.createFrom().item(() ->
                SmartModelResponse.newBuilder().setName(request.getName()).setDescription(request.getDescription()).build()
        );
    }

    @Override
    public Uni<SmartFeatureRequest> addNewFeature(SmartFeatureResponse request) {
        return null;
    }

    @Override
    @Blocking
    @Transactional
    public Uni<Empty> addDemoData(Empty request) {
        String message = "";
        try {
            demoRecords();
            message = "Ok";
        } catch (SmartModel.LogicNotYetImplemented e) {
         message = e.getMessage();
        }

        String finalMessage = message;
        return Uni.createFrom().item(() ->
                Empty.newBuilder().setMessage(finalMessage).build());
    }



    // Ugly function to fill db with some data ( or we can use the SQL import file ... in proprieties // TODO )
    private void demoRecords() throws SmartModel.LogicNotYetImplemented {

        List<SmartFeature> smartFeatures = Arrays.asList(
                // initial smart models without features
                smartFeatureService.add(new SmartFeature("Feature 1","F1")),
                smartFeatureService.add(new SmartFeature("Feature 2","F2")),
                smartFeatureService.add(new SmartFeature("Feature 3","F3")),
                smartFeatureService.add(new SmartFeature("Feature 4","F4")),
                smartFeatureService.add(new SmartFeature("Feature 5","F5"))
        );

        for (SmartFeature smartFeature:
                smartFeatures) {
            smartFeatureService.add(smartFeature);
        }
        // initial smart model with feautre

        List<SmartModel> smartModels = Arrays.asList(
                // initial smart models without features
                smartModelDbService.add(new SmartDevice("AMAZFIT","WATCH/TREX","Smart watch with GPS","Xiaomi")),
                smartModelDbService.add(new SmartDevice("forruner","WATCH/SPORT","Smart watch with GPS++","Garmin")),
                smartModelDbService.add(new SmartDevice("PeaceMaker","PeaceMaker","Smart watch with GPS++","Philips")),
                smartModelDbService.add(new SmartService("HEARTBEAT","SOFTWARE/MONITOR-X1","MONITOR for peacemaker","localhost","http")),
                smartModelDbService.add(new SmartService("MovieMe","Movie/List1","Predection Movie title","imdb.com","ws"))
        );

        for (SmartModel smartModel:
                smartModels) {
            smartModelDbService.add(smartModel);
        }

        smartModelDbService.attachFeature(smartModels.get(1).id, smartFeatures.get(1));
        smartModelDbService.attachFeature(smartModels.get(2).id, smartFeatures.get(2));
        smartModelDbService.attachFeature(smartModels.get(3).id, smartFeatures.get(3));

    }

}
