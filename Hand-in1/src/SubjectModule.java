import java.util.ArrayList;
import java.util.List;

public class SubjectModule {
    List<SubjectCourse> subjectCourses = new ArrayList<>();

    public SubjectModule() {
    }

    void addCourse(SubjectCourse subjectCourse) {subjectCourses.add(subjectCourse);}

    String getType() {
        return "SubjectModule";
    }


}
