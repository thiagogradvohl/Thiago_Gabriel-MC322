import java.util.ArrayList;
import java.util.List;

public class SensorAltitude extends SensorProximidade {

    public SensorAltitude(double raio, Ambiente ambiente_robos) {
        super(raio, ambiente_robos);
    }


    public List<int[]> identificarObstaculosAereos(RoboAereo robo_aereo){
        
        
        List<int[]> obstaculos_vizinhos = new ArrayList<>();

        for(Obstaculo obs : this.ambiente_robos.obstaculos)
        {
            if(obs.getPosicao_x1() == robo_aereo.getPosicaox() && obs.getPosicao_y1() == robo_aereo.getPosicaoy() && obs.getAltura() == robo_aereo.getAltitude())
            {
                System.out.printf("Robô colidiu com um obstáculo!\nPosição da colisão: (%d,%d,%d)",obs.getPosicao_x2(),obs.getPosicao_y2(),obs.getAltura());
            }
            else if(obs.getPosicao_x1() == robo_aereo.getPosicaox()+1 || obs.getPosicao_x1() == robo_aereo.getPosicaox()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x1(),obs.getPosicao_y1(),obs.getAltura()});
            }
            else if(obs.getPosicao_y1() == robo_aereo.getPosicaoy()+1 || obs.getPosicao_y1() == robo_aereo.getPosicaoy()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x1(),obs.getPosicao_y1(),obs.getAltura()});
            }
            else if (obs.getAltura() == robo_aereo.getAltitude()+1 || obs.getAltura() == robo_aereo.getAltitude()-1)
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

    public void monitorar(RoboAereo robo_aereo) {
        List<int[]> proximos = identificarObstaculosAereos(robo_aereo);
        exibirObstaculos(proximos);
    }

}
