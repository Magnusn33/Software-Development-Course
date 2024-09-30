public class SubjectCourse extends Course {
    public SubjectCourse(int ects, String name, String NameOfModule) {
        super(ects, name, NameOfModule);
    }

    @Override
    String getType() {
        return "SubjectCourse";
    }
}
