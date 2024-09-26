public class SubjectCourse extends Course {
    public SubjectCourse(int ects, String name) {
        super(ects, name);
    }

    @Override
    String getType() {
        return "SubjectCourse";
    }

}
