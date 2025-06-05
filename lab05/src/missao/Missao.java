package missao;
import java.util.List;

import ambiente.*;
import entidade.Entidade;
import robo.*;
import sensores.*;

public interface Missao {
    void executar(Robo r, Ambiente a) throws Exception;
    boolean isExecutada();
    List<Sensor> getSensoresAtivados();
    List<Entidade> getObstaculosDetectados();
}
