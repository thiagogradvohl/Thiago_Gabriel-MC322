package missao;

import robo.*;

import java.util.List;

import ambiente.*;
import entidade.Entidade;
import sensores.*;

public class MissaoMonitorar implements Missao {
    private boolean executada;
    private List<Sensor> sensoresAtivados;
    private List<Entidade> obstaculosDetectados;

    public MissaoMonitorar() {
        this.executada = false;
        this.sensoresAtivados = null;
        this.obstaculosDetectados = null;
    }
    
    @Override
    public void executar(Robo r, Ambiente a) throws Exception { //imprime entidades ao redor do robo
                                                                //so funciona se o robo possuir um sensor de proximidade 
        for (Sensor s : r.getSensores()) {
            if (s instanceof SensorProximidade) {
                System.out.printf("Missao Monitorar sendo executada (%s com  Sensor de Proximidade)...\n", r.getId());
                s.monitorar(r, a);  //imprime entidades proximas
                this.obstaculosDetectados = ((SensorProximidade)s).identificarEntidades(r, a);
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
    public List<Sensor> getSensoresAtivados() {
        return this.sensoresAtivados;
    }

    @Override
    public List<Entidade> getObstaculosDetectados() {
        return this.obstaculosDetectados;
    }
}