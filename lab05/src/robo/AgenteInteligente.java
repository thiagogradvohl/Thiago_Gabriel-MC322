package robo;

import ambiente.Ambiente;
import missao.*;
import sensores.Sensor;

public abstract class AgenteInteligente extends Robo {
    protected Missao missao;
    
    public AgenteInteligente(int X, int Y, int Z, String id, Sensor sensor, EstadoRobo estado, Missao missao) {
        super(X, Y, Z, id, sensor, estado);
        this.missao = missao;
    }

    public void definirMissao(Missao m) {
        this.missao = m;
    }
    
    public boolean temMissao() {
        return missao != null;
    }
    public Missao getMissao() {
        return missao;
    }

    public abstract void executarMissao(Ambiente a) throws Exception;
}
