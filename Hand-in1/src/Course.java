public abstract class Course {
     int ects;
     String name;
     String NameOfModule;

    public Course(int ects, String name, String NameOFModule) {
        this.ects = ects;
        this.name = name;
        this.NameOfModule = NameOFModule;
    }

    int getEcts() {
        return ects;
    }

    String getName() {
        return name;
    }

    String getNameOfModule() {
        return NameOfModule;
    }

    String getType() {
        return "";
    }
}

