public class TimeTracker {
    private static Long start;

    public static void start(){
        start = System.nanoTime();
    }

    public static Long getTime() {
        return System.nanoTime() - start;
    }
}
