package missao;

import robo.*;

import java.util.ArrayList;

import ambiente.*;
import entidade.Entidade;
import sensores.*;

public class MissaoMonitorar implements Missao {
    private boolean executada;
    private ArrayList<Sensor> sensoresAtivados;
    private ArrayList<Entidade> obstaculosDetectados;
    private ArrayList<String> posicoesVisitadas;

    public MissaoMonitorar() {
        this.executada = false;
        this.sensoresAtivados = new ArrayList<>();
        this.obstaculosDetectados = new ArrayList<>();
        this.posicoesVisitadas = new ArrayList<>();
    }
    
    @Override
    public void executar(Robo r, Ambiente a) throws Exception { //imprime entidades ao redor do robo
                                                                //so funciona se o robo possuir um sensor de proximidade 
        String posicao = "(" + r.getX() + ", " + r.getY() + ", " + r.getZ() + ")";
        if (!this.posicoesVisitadas.contains(posicao))
            this.posicoesVisitadas.add(posicao);    
        for (Sensor s : r.getSensores()) {
            if (s instanceof SensorProximidade) {
                System.out.printf("Missao Monitorar sendo executada (%s com  Sensor de Proximidade)...\n", r.getId());
                s.monitorar(r, a);  //imprime entidades proximas
                ArrayList<Entidade> entidades_proximas = ((SensorProximidade)s).identificarEntidades(r, a);
                for (Entidade e : entidades_proximas) {
                    if (!this.obstaculosDetectados.contains(e))
                        this.obstaculosDetectados.add(e);
                }
                if (!this.sensoresAtivados.contains(s))
                    this.sensoresAtivados.add(s);
                this.executada = true;
                return;
            }
        }
        System.out.printf("Nao eh possivel realizar a Missao Monitorar com o robo %s... Ele nao possui um sensor de proximidade.\n", r.getId());
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
    public ArrayList<String> getPosicoesVisitadas() {
        return this.posicoesVisitadas;
    }

    @Override 
    public String toString() {
        String out = "";
        out += "Missao Monitorar";
        return out;
    }
}