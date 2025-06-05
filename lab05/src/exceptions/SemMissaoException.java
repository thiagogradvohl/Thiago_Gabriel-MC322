package exceptions;

public class SemMissaoException extends Exception {
    public SemMissaoException() {
        super("O robo nao possui uma missao para executar.");
    }
}