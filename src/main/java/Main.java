import cursed.java.Utils.console;

public class Main {
    public static void main(String[] args) {
        console.log("This is a log message.");
        console.info("This is an info message.");
        console.warn("This is a warning message.");
        console.error("This is an error message.");
        console.debug("This is a debug message.");

        console.time("MyTimer");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        console.timeEnd("MyTimer");
    }
}