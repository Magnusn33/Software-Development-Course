public class BachelorProject extends Course {
    public BachelorProject(String name) {
        super(15, name);
    }

    @Override
    String getType() {
        return "BachelorProject";
    }
}
