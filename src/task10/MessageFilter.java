package task10;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
