package DammAutomationFramework;

public class GetWorkingDirectory {
    public static String main() {
        String directory = System.getProperty("user.dir");

        System.out.println("Working Directory = " + directory);

        return directory;
    }
}
