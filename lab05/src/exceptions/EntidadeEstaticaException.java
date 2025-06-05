package exceptions;

public class EntidadeEstaticaException extends Exception {
    public EntidadeEstaticaException() {
        super("A entidade é estática (não pode ser movida).");
    }
}