package exceptions;

public class VelocidadeExcedidaException extends Exception {
    public VelocidadeExcedidaException() {
        super("O limite de velocidade foi excedido.");
    }
}