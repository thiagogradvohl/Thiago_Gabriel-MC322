import java.util.ArrayList;
import java.util.List;

public class SensorAltitude extends SensorProximidade {
    private RoboAereo robo_aereo;
    

    public SensorAltitude(double raio, RoboAereo robo_aereo, Ambiente ambiente_robos) {
        super(raio, robo_aereo,ambiente_robos);
        this.robo_aereo = robo_aereo;
    }


    public List<int[]> identificarObstaculosAereos(){
        
        
        List<int[]> obstaculos_vizinhos = new ArrayList<>();

        for(Obstaculo obs : this.ambiente_robos.obstaculos)
        {
            if(obs.getPosicao_x1() == this.robo_aereo.getPosicaox() && obs.getPosicao_y1() == this.robo_aereo.getPosicaoy() && obs.getAltura() == this.robo_aereo.getAltitude())
            {
                System.out.printf("Robô colidiu com um obstáculo!\nPosição da colisão: (%d,%d,%d)",obs.getPosicao_x2(),obs.getPosicao_y2(),obs.getAltura());
            }
            else if(obs.getPosicao_x1() == this.robo_aereo.getPosicaox()+1 || obs.getPosicao_x1() == this.robo_aereo.getPosicaox()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x1(),obs.getPosicao_y1(),obs.getAltura()});
            }
            else if(obs.getPosicao_y1() == this.robo_aereo.getPosicaoy()+1 || obs.getPosicao_y1() == this.robo_aereo.getPosicaoy()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x1(),obs.getPosicao_y1(),obs.getAltura()});
            }
            else if (obs.getAltura() == this.robo_aereo.getAltitude()+1 || obs.getAltura() == this.robo_aereo.getAltitude()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x1(),obs.getPosicao_y1(),obs.getAltura()});
            }
        }

        return obstaculos_vizinhos;
    }

    @Override
    public void exibirObstaculos(List<int[]> obstaculos_aereos)
    {
        for(int[] obs : obstaculos_aereos)
        {
            System.out.printf("Obstáculo na posição (%d,%d,%d)\n",obs[0],obs[1],obs[2]);
        }
    }

    @Override
    public void monitorar(String contexto) {
        List<int[]> proximos = identificarObstaculosAereos();
        exibirObstaculos(proximos);
    }

}
