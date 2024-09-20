package cursed.java.std.vars;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class vars {
    private static final Map<String, declaration<?>> variables = new HashMap<>();

    public static <T> void let(String name, T value) {
        variables.put(name, new declaration<>(value));
    }

    public static <T> T get(String name) {
        declaration<?> variable = variables.get(name);
        if (variable != null) return (T) variable.get();
        return null;
    }
}