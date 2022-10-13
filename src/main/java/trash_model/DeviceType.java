package trash_model;

public class DeviceType implements IType {
    protected ICategory category;

    public DeviceType(ICategory category){
        this.category = category;
    }

    @Override
    public String Action() {
        return "Device";
    }
}
