package robo;

import missao.Missao;
import missao.MissaoMonitorar;
import sensores.Sensor;
import ambiente.*;
import exceptions.*;

public class RoboMonitoramento extends AgenteInteligente {

    public RoboMonitoramento(int X, int Y, int Z, String id, Sensor sensor, EstadoRobo estado, Missao missao) {
        super(X, Y, Z, id, sensor, estado, missao);
    }

    @Override
    public void executarMissao(Ambiente a) throws Exception {
        if (getEstado() == EstadoRobo.LIGADO) {
            if (this.missao instanceof MissaoMonitorar) {
                if (temMissao()) {
                    System.out.println("Executando missao para monitorar (ver entidades proximas)...");
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
        return;
    }
}
