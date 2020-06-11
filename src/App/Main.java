package App;

public class Main {
    public static void main(String[] args) {
        final String version = "Save Account v0.1";
        System.out.println(version);

        ApplicationControl applicationControl = new ApplicationControl();
        applicationControl.loopControl();
    }
}
