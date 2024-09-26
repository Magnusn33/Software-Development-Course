public class SubjectProject extends Course {
    public SubjectProject(String name) {
        super(15, name);
    }

    @Override
    String getType() {
        return "SubjectProject";
    }

}
