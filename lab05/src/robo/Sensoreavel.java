package robo;
import exceptions.*;
import ambiente.*;

public interface Sensoreavel {
    void acionarSensores(Ambiente ambiente) throws RoboDesligadoException;  //pode lancar robodesligadoexception
}