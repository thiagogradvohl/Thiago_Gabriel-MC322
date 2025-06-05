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
    private ArrayList<Sensor> sensoresAtivados;
    private ArrayList<Entidade> obstaculosDetectados;
    private ArrayList<String> posicoesVisitadas;

    public MissaoExplorar(double raio_exploracao) {
        this.raioExploracao = raio_exploracao;
        this.executada = false;
        this.sensoresAtivados = new ArrayList<>();
        this.obstaculosDetectados = new ArrayList<>();
        this.posicoesVisitadas = new ArrayList<>();
    } 

    @Override
    public boolean isExecutada() {
        return this.executada;
    }

    @Override
    public ArrayList<Sensor> getSensoresAtivados() {
        return this.sensoresAtivados;
    }

    @Override
    public ArrayList<Entidade> getObstaculosDetectados() {
        return this.obstaculosDetectados;
    }

    @Override
    public void executar(Robo r, Ambiente a) { 
        if (!r.getSensores().isEmpty()) {
            System.out.printf("Robo %s monitorando area de raio %.1f, a partir da posicao (%d, %d, %d):\n", r.getId(), this.raioExploracao, r.getX(), r.getY(), r.getZ());
            String posicao = "(" + r.getX() + ", " + r.getY() + ", " + r.getZ() + ")";
            if (!this.posicoesVisitadas.contains(posicao))    
                this.posicoesVisitadas.add(posicao);
            for (Sensor s : r.getSensores()) {
                s.setRaio(raioExploracao);
                s.monitorar(r, a);
                if (!this.sensoresAtivados.contains(s))
                    this.sensoresAtivados.add(s);
                if (s instanceof SensorProximidade) {
                    for (Entidade e : ((SensorProximidade)s).identificarEntidades(r, a))
                        if (this.obstaculosDetectados.contains(e))
                            this.obstaculosDetectados.add(e);
                }
            }
            this.executada = true;
        }
        else
            System.out.printf("Nao foi possivel realizar a Missao Explorar (robo %s nao possui sensores)\n", r.getId());
    }

    @Override 
    public ArrayList<String> getPosicoesVisitadas() {
        return this.posicoesVisitadas;
    }

    @Override
    public String toString() {
        String out = "";
        out += "Missao Explorar raio de " + this.raioExploracao;
        return out;
    }
}