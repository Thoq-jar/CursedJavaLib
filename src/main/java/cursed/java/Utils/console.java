package cursed.java.Utils;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.err;
import static java.lang.System.out;

public class console {
    private static final Map<String, Long> timers = new HashMap<>();
    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_RESET = "\u001B[0m";

    public static void log(String message) {
        out.println(message);
    }

    public static void info(String message) {
        out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void warn(String message) {
        out.format("%s%s%s\n", ANSI_YELLOW, message, ANSI_RESET);
    }

    public static void error(String message) {
        err.format("%s%s%s\n", ANSI_RED, message, ANSI_RESET);
    }

    public static void debug(String message) {
        out.println("[DEBUG] " + message);
    }

    public static void table(String[][] data) {
        for (String[] row : data) {
            for (String cell : row) {
                out.print(cell + "\t");
            }
            out.println();
        }
    }

    public static void time(String label) {
        long startTime = System.currentTimeMillis();
        timers.put(label, startTime);
        out.println("Timer started for: " + label);
    }

    public static void timeEnd(String label) {
        Long startTime = timers.get(label);
        if (startTime != null) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            out.println("Timer ended for: " + label + ". Duration: " + duration + " ms");
            timers.remove(label);
        } else {
            out.println("No timer found for: " + label);
        }
    }
}