package exceptions;

public class MissaoIncompativelException extends Exception {
    public MissaoIncompativelException() {
        super("A missao designada eh incompativel com o robo em questao.");
    }
}