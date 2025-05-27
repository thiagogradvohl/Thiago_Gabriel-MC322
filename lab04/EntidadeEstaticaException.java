public class EntidadeEstaticaException extends Exception {
    public EntidadeEstaticaException() {
        super("EntidadeEstaticaException: A entidade é estática (não pode ser movida).");
    }
}