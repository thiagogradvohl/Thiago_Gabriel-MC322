package missao;

import java.util.List;
import ambiente.*;
import entidade.Entidade;
import robo.*;
import sensores.Sensor;

public class MissaoBuscarPonto implements Missao {
    private int X;
    private int Y;
    private int Z;
    private boolean executada;
    
    public MissaoBuscarPonto(int X, int Y, int Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.executada = false;
    }

    @Override
    public boolean isExecutada() {
        return this.executada;
    }

    @Override
    public void executar(Robo r, Ambiente a) throws Exception {
        try { 
            a.moverEntidade(r, this.X, this.Y, this.Z);  //robo movido para o ponto a ser buscado 
            System.out.printf("Robo %s Buscando Ponto (%d, %d, %d)\n", r.getId(), this.X, this.Y, this.Z);
            this.executada = true;
        } catch (Exception e) {
            throw e;
        }
    }

    public int getX() {
        return X;
    }
    
    public int getY() {
        return Y;
    }
    
    public int getZ() {
        return Z;
    }

    @Override
    public List<Sensor> getSensoresAtivados() {
        return null; //nenhum sensor eh usado
    }                //logo nenhum obstaculo eh identificado tambem

    @Override
    public List<Entidade> getObstaculosDetectados() {
        return null;
    }
}
