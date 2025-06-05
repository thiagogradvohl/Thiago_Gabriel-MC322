public class MunicaoInsuficienteException extends Exception {
    public MunicaoInsuficienteException() {
        super("Municao insuficiente para a acao. A quantidade minima eh 10.");
    }
}
