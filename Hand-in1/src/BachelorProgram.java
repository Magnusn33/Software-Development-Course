public class BachelorProgram {

    Activity activity = new BasicProject();
    int ects = activity.getEcts();

    public static void main(String[] args) {
        BachelorProgram program = new BachelorProgram();
        System.out.println("ECTS: " + program.ects);
    }

}
