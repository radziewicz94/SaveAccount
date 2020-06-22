package App;

public class Main {
    public static void main(String[] args) {
        final String version = "Aplikacja oszczędnościowa";
        System.out.println(version);

        ApplicationControl applicationControl = new ApplicationControl();
        applicationControl.loopControl();
    }
}
