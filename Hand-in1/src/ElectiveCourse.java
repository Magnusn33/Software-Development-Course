public class ElectiveCourse extends Course {
    public ElectiveCourse(int ects, String name) {
        super(ects, name);
    }

    @Override
    String getType() {
        return "ElectiveCourse";
    }
}
