package trash_model;

// choosing to extend DeviceType instead of implementing IType
// because they have the same attrs
public class ServiceType extends DeviceType {

    public ServiceType(ICategory category){
        super(category);
    }

    @Override
    public String Action() {
        return "Service";
    }
}
