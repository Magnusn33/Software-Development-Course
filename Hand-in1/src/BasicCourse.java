public class BasicCourse extends Course {
    public BasicCourse(int ects, String name) {
        super(ects, name);
    }

    @Override
    String getType() {
        return "BasicCourse";
    }

}
