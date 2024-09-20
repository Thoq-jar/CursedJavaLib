package cursed.java.std;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class console {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";
    static final String ANSI_BOLD = "\u001B[1m";
    static final String ANSI_ITALIC = "\u001B[3m";
    static final String ANSI_UNDERLINE = "\u001B[4m";
    static final String ANSI_STRIKETHROUGH = "\u001B[9m";

    private static final Map<String, Long> timers = new HashMap<>();

    public static void log(String message) {
        stdout.write(ANSI_RESET + message + "\n");
    }

    public static void info(String message) {
        stdout.write(ANSI_GREEN + message + ANSI_RESET + "\n");
    }

    public static void warn(String message) {
        stdout.write(String.format("%s%s%s\n", ANSI_YELLOW, message, ANSI_RESET));
    }

    public static void error(String message) {
        stdout.write(ANSI_RED + message + ANSI_RESET + "\n");
    }

    public static void debug(String message) {
        stdout.write(ANSI_CYAN + "[DEBUG] " + message + ANSI_RESET + "\n");
    }

    public void table(String[][] data) {
        int maxRowLength = data.length > 0 ? data[0].length : 0;
        for (int i = 0; i < maxRowLength; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (String[] row : data) if (i < row.length) rowBuilder.append(row[i]).append("\t");
            stdout.write(ANSI_BOLD + rowBuilder.substring(0, rowBuilder.length() - 1) + ANSI_RESET + "\n");
        }
    }

    public static void time(String label) {
        long startTime = System.currentTimeMillis();
        timers.put(label, startTime);
        stdout.write(ANSI_BLUE + "Timer started for: " + label + ANSI_RESET + "\n");
    }

    public static void timeEnd(String label) {
        Long startTime = timers.get(label);
        if (startTime != null) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            stdout.write(String.format("%sTimer ended for: %s. Duration: %.3f ms%n",
                    ANSI_BLUE,
                    label,
                    duration / 1000.0));
            timers.remove(label);
            stdout.write(ANSI_RESET);
        } else {
            stdout.write(ANSI_RED + "No timer found for: " + label + "\n" + ANSI_RED);
        }
    }
}
