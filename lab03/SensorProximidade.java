import java.util.ArrayList;
import java.util.List;

public class SensorProximidade extends Sensor{
    Ambiente ambiente_robos;

    public SensorProximidade(double raio, Ambiente ambiente_robos){
        super(raio);
        this.ambiente_robos = ambiente_robos;
        
    }

    protected double distancia1D(double ponto, double min, double max) {
        if (ponto < min) 
            return min - ponto;
        if (ponto > max) 
            return ponto - max;
        return 0;
    }

    public List<Obstaculo> identificarObstaculos(Robo robo){
        
        
        List<Obstaculo> obstaculos_vizinhos = new ArrayList<>();

        for(Obstaculo obs : this.ambiente_robos.obstaculos)
        {   
            double distancia_x = distancia1D(robo.getPosicaox(), obs.getPosicao_x1(), obs.getPosicao_x2());
            double distancia_y = distancia1D(robo.getPosicaoy(), obs.getPosicao_y1(), obs.getPosicao_y2());
            double distancia = Math.sqrt(Math.pow(distancia_x, 2) + Math.pow(distancia_y, 2));

            if(obs.getPosicao_x1() <= robo.getPosicaox() && robo.getPosicaox() <= obs.getPosicao_x2() && obs.getPosicao_y1() <= robo.getPosicaoy() 
            && robo.getPosicaoy() <= obs.getPosicao_y2())
            {
                System.out.printf("Robô colidiu com um obstáculo!\nPosição da colisão: (%d,%d,%d)",obs.getPosicao_x2(),obs.getPosicao_y2(),obs.getAltura());
            }
            else if(distancia <= getRaio())
                obstaculos_vizinhos.add(obs);
        }

        return obstaculos_vizinhos;
    }

    public void exibirObstaculos(List<Obstaculo> obstaculos) {
        for(Obstaculo obs : obstaculos)
            System.out.println(obs);
    }

    @Override
    public void monitorar(String nome_lugar, Robo robo) {
        List<Obstaculo> obstaculos_vizinhos = identificarObstaculos(robo);
        if (obstaculos_vizinhos != null) {
            System.out.printf("---Obstaculos encontrados pelo Sensor de Proximidade em %s (com raio de proximidade igual a %d)---\n",
            nome_lugar, getRaio());
            exibirObstaculos(obstaculos_vizinhos);
        }
        else   
            System.out.println("---O Sensor de Proximidade nao encontrou Obstaculos---");
    }

    @Override
    public String toString() {
        String out = "--- Sensor de Proximidade ---";
        out += ".Raio de varredura = " + getRaio() + " .";
        return out;
    }
}
