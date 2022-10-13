package ix.smart.demo.Entities;

import javax.persistence.MappedSuperclass;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@MappedSuperclass

public interface MetaModel {

    MetaModel addOneSmartModel(SmartFeature metaModel) throws SmartModel.LogicNotYetImplemented, NoSuchAlgorithmException;
    MetaModel addRangeSmartModel(List<SmartFeature> metaModels) throws SmartModel.LogicNotYetImplemented, NoSuchAlgorithmException;
    void doAction();
}
