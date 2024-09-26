public class BachelorProgram {
    int totalEcts = 0;

    public int getTotalEcts(Activity activity) {
        return activity.getEcts();
    }

    public String getType(Activity activity) {
        return activity.getType();
    }

    public static void main(String[] args) {
        BachelorProgram program = new BachelorProgram();
        int totalEcts = 0;
        String Type = "";

        Activity activity = new BasicProject();
        totalEcts = totalEcts + program.getTotalEcts(activity);
        Type = program.getType(activity);
        System.out.println("Type: " + Type);
        System.out.println("ECTS: " + totalEcts + "\n");

        activity = new BasicCourse();
        totalEcts = totalEcts + program.getTotalEcts(activity);
        Type = program.getType(activity);
        System.out.println("Type: " + Type);
        System.out.println("ECTS: " + totalEcts + "\n");
    }

}
