package robo;

import missao.*;
import sensores.Sensor;
import ambiente.*;
import exceptions.MissaoIncompativelException;
import exceptions.RoboDesligadoException;
import exceptions.SemMissaoException;

public class DestruidorObstaculoInteligente extends AgenteInteligente {

    public DestruidorObstaculoInteligente(int X, int Y, int Z, String id, Sensor sensor, EstadoRobo estado, Missao missao) {
        super(X, Y, Z, id, sensor, estado, missao);
    }

    @Override
    public void executarMissao(Ambiente a) throws Exception {
        if (getEstado() == EstadoRobo.LIGADO) {
            if (this.missao instanceof MissaoDestruirObstaculo) {
                if (temMissao()) {
                    System.out.println("Executando missao para destruir obstaculo...");
                    try { 
                        missao.executar(this, a);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                else 
                    throw new SemMissaoException();
            }
            else
                throw new MissaoIncompativelException();
        }
        else
            throw new RoboDesligadoException();
    }

    @Override
    public void executarTarefa() {  
        return; //?
    }
}

