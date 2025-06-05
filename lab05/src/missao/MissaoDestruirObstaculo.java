package missao;

import java.util.List;

import ambiente.Ambiente;
import robo.*;
import sensores.Sensor;
import sensores.SensorProximidade;
import obstaculo.*;
import entidade.*;

public class MissaoDestruirObstaculo implements Missao {
    private Obstaculo alvo;
    private boolean executada;
    private List<Sensor> sensoresAtivados;
    private List<Entidade> obstaculosDetectados;

    public MissaoDestruirObstaculo(Obstaculo alvo) {
        this.alvo = alvo;
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
    public void executar(Robo r, Ambiente a) throws Exception {
        for (Sensor s: r.getSensores()) {
            if (s instanceof SensorProximidade) {  //apenas sensor de proximidade eh usado
                this.sensoresAtivados.add(s);
                List<Entidade> entidades_proximas = ((SensorProximidade)s).identificarEntidades(r, a);
                for (Entidade e : entidades_proximas) {
                    if (!this.obstaculosDetectados.isEmpty() && !this.obstaculosDetectados.contains(e))
                        this.obstaculosDetectados.add(e);
                }
                if (entidades_proximas.contains(this.alvo)) {
                    a.removerEntidade(this.alvo);
                    try {
                        a.moverEntidade(r, this.alvo.getX(), this.alvo.getY(), this.alvo.getZ());  //robo ocupa lugar do obstaculo apos destrui-lo
                    } catch (Exception e) {
                        throw e;
                    }
                    System.out.printf("Missao Destruir Obstaculo concluida com sucesso pelo robo %s (obstaculo %s destruido)\n", r.getId(), this.alvo.getTipoObs());
                    this.executada = true;
                }
                else
                    System.out.println("O robo nao esta identificando o alvo no raio do seu Sensor de Proximidade. Ele tem que chegar mais perto...");
                return;
            }
            System.out.printf("Nao eh possivel realizar a Missao de destruir obstaculo com o robo %s... Ele nao possui Sensor de Proximidade.\n", r.getId());
        }
    }

}