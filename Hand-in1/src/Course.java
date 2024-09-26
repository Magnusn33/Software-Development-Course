public abstract class Course {
    private int ects;
    private String name;

    public Course(int ects, String name) {
        this.ects = ects;
        this.name = name;
    }

    int getEcts() {
        return ects;
    }

    String getName() {
        return name;
    }

    String getType() {
        return "";
    }
}

