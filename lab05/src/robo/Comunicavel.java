package robo;
import exceptions.*;

public interface Comunicavel {
    String enviarMensagem(Comunicavel destinatario, String mensagem) throws RoboDesligadoException;
    void receberMensagem(String mensagem) throws RoboDesligadoException;  //pode lancar robodesligadoexception
}