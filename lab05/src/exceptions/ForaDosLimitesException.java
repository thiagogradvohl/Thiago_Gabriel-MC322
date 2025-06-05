package exceptions;

public class ForaDosLimitesException extends Exception {
    public ForaDosLimitesException() {
        super("A entidade iria para fora dos limites do ambiente.");
    }
}