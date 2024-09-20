import cursed.java.std.console;
import cursed.java.std.window;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import static cursed.java.std.vars.vars.get;
import static cursed.java.std.vars.vars.let;
import static java.lang.System.exit;
import static java.lang.System.out;

@SuppressWarnings("CallToPrintStackTrace")
public class demoLib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            out.println("\nWhat would you like to explore?");
            out.println("1. Console Output");
            out.println("2. Timer");
            out.println("3. Windows");
            out.println("4. Variables");
            out.println("5. Exit");
            out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    out.println("\n");
                    consoleOut();
                    break;
                case 2:
                    out.println("\n");
                    timer();
                    break;
                case 3:
                    out.println("\n");
                    variables();
                    break;
                case 4:
                    openWindow();
                    break;
                case 5:
                    out.println("Exiting the demo...");
                    exit(0);
                    break;
                default:
                    out.println("\nInvalid choice!");
            }
        }
    }

    public static void consoleOut() {
        console.log("This is a log message.");
        console.info("This is an info message.");
        console.warn("This is a warning message.");
        console.error("This is an error message.");
        console.debug("This is a debug message.");
    }

    public static void timer() {
        console.time("MyTimer");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        console.timeEnd("MyTimer");
    }

    public static void openWindow() {
        CountDownLatch latch = new CountDownLatch(1);

        Thread windowThread = new Thread(() -> {
            javax.swing.SwingUtilities.invokeLater(() -> {
                window.alert("This is an alert message.");
                window.create("This is a window");
                window.create("This is a sized window", 400, 700);
                window.textField("Title", "This is a text field!");
                window.textField("Title", "This is a sized text field!", 500, 700);
                latch.countDown();
            });
        });

        windowThread.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void variables() {
        let("name", "Yeet");
        console.log(get("name"));
    }
}