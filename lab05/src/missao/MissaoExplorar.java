package missao;

import java.util.*;

import ambiente.Ambiente;
import entidade.Entidade;
import robo.*;
import sensores.Sensor;
import sensores.SensorProximidade;

public class MissaoExplorar implements Missao {
    private double raioExploracao;
    private boolean executada;
    private List<Sensor> sensoresAtivados;
    private List<Entidade> obstaculosDetectados;

    public MissaoExplorar(double raio_exploracao) {
        this.raioExploracao = raio_exploracao;
        this.executada = false;
        this.sensoresAtivados = null;
        this.obstaculosDetectados = null;
    } 

    @Override
    public boolean isExecutada() {
        return this.executada;
    }

    @Override
    public List<Sensor> getSensoresAtivados() {
        return this.sensoresAtivados;
    }

    @Override
    public List<Entidade> getObstaculosDetectados() {
        return this.obstaculosDetectados;
    }

    @Override
    public void executar(Robo r, Ambiente a) { 
        if (!r.getSensores().isEmpty()) {
            System.out.printf("Robo %s monitorando area de raio %f, a partir da posicao (%d, %d, %d):", r.getId(), this.raioExploracao, r.getX(), r.getY(), r.getZ());
            for (Sensor s : r.getSensores()) {
                s.setRaio(raioExploracao);
                s.monitorar(r, a);
                this.sensoresAtivados.add(s);
                if (s instanceof SensorProximidade) {
                    this.obstaculosDetectados = ((SensorProximidade)s).identificarEntidades(r, a);
                }
            }
            this.executada = true;
        }
        else
            System.out.printf("Nao foi possivel realizar a Missao Explorar (robo %s nao possui sensores)\n", r.getId());
    }
}