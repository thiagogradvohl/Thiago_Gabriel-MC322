package missao;

import java.util.ArrayList;

import ambiente.Ambiente;
import robo.*;
import sensores.Sensor;
import sensores.SensorProximidade;
import obstaculo.*;
import entidade.*;

public class MissaoRemoverObstaculo implements Missao {
    private Obstaculo alvo;
    private boolean executada;
    private ArrayList<Sensor> sensoresAtivados;
    private ArrayList<Entidade> obstaculosDetectados;
    private ArrayList<String> posicoesVisitadas;

    public MissaoRemoverObstaculo(Obstaculo alvo) {
        this.alvo = alvo;
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
    public ArrayList<String> getPosicoesVisitadas() {
        return this.posicoesVisitadas;
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
    public void executar(Robo r, Ambiente a) throws Exception {
        String posicao = "(" + r.getX() + ", " + r.getY() + ", " + r.getZ() + ")";
        if (!this.posicoesVisitadas.contains(posicao))
            this.posicoesVisitadas.add(posicao);
        for (Sensor s: r.getSensores()) {
            if (s instanceof SensorProximidade) {  //apenas sensor de proximidade eh usado
                if (!this.sensoresAtivados.contains(s))
                    this.sensoresAtivados.add(s);
                ArrayList<Entidade> entidades_proximas = ((SensorProximidade)s).identificarEntidades(r, a);
                for (Entidade e : entidades_proximas) {
                    if (!this.obstaculosDetectados.contains(e))
                        this.obstaculosDetectados.add(e);
                }
                if (entidades_proximas.contains(this.alvo)) {
                    a.removerEntidade(this.alvo);
                    try {
                        a.moverEntidade(r, this.alvo.getX(), this.alvo.getY(), this.alvo.getZ());  //robo ocupa lugar do obstaculo apos destrui-lo
                    } catch (Exception e) {
                        throw e;
                    }
                    System.out.printf("Missao Remover Obstaculo concluida com sucesso pelo robo %s (obstaculo %s destruido)\n", r.getId(), this.alvo.getTipoObs());
                    this.executada = true;
                }
                else
                    System.out.println("O robo nao esta identificando o alvo no raio do seu Sensor de Proximidade.");
                return;
            }
            System.out.printf("Nao eh possivel realizar a Missao de Remover obstaculo com o robo %s... Ele nao possui Sensor de Proximidade.\n", r.getId());
        }
    }

    @Override
    public String toString() {
        String out = "";
        out += "Missao Remover Obstaculo ";
        out += this.alvo.getTipoObs();

        return out;
    }

}