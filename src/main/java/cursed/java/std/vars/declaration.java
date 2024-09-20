package cursed.java.std.vars;

public class declaration<T> {
    private T value;

    public declaration(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
