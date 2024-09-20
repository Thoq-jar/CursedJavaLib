package cursed.java.std;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public class stdout {
    private static final List<String> outputBuffer = new ArrayList<>();

    public static void write(String str) {
        synchronized (outputBuffer) {
            outputBuffer.add(str);
            try {
                out.write(str.getBytes());
                out.flush();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    public String getOutput() {
        synchronized (outputBuffer) {
            StringBuilder sb = new StringBuilder();
            for (String line : outputBuffer) sb.append(line).append("\n");
            return sb.toString();
        }
    }

    public void clear() {
        synchronized (outputBuffer) {
            outputBuffer.clear();
        }
    }
}
