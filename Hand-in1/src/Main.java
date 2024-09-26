public class Main {
    public static void main(String[] args)
    {
        BachelorProgram program = new BachelorProgram();
        int totalEcts = 0;
        String Type = "";

        //Run basicProject class
        Activity activity = new BasicProject();
        totalEcts = totalEcts + program.getTotalEcts(activity);
        Type = program.getType(activity);
        System.out.println("Type: " + Type);
        System.out.println("ECTS: " + totalEcts + "\n");

        //Run basicCourse class
        activity = new BasicCourse();
        totalEcts = totalEcts + program.getTotalEcts(activity);
        Type = program.getType(activity);
        System.out.println("Type: " + Type);
        System.out.println("ECTS: " + totalEcts + "\n");
    }
}