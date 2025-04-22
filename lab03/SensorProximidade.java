import java.util.ArrayList;
import java.util.List;

public class SensorProximidade extends Sensor{
    private Robo robo;
    Ambiente ambiente_robos;

    public SensorProximidade(double raio, Robo robo, Ambiente ambiente_robos){
        super(raio);
        this.robo = robo;
        this.ambiente_robos = ambiente_robos;
        
    }

    public List<int[]> identificarObstaculos(){
        

        List<int[]> obstaculos_vizinhos = new ArrayList<>();

        for(Obstaculo obs : this.ambiente_robos.obstaculos)
        {
            if(obs.getPosicao_x2() == this.robo.getPosicaox() && obs.getPosicao_y2() == this.robo.getPosicaoy())
            {
                System.out.printf("Robô colidiu com um obstáculo!\nPosição da colisão: (%d,%d)",obs.getPosicao_x2(),obs.getPosicao_y2());
            }
            else if(obs.getPosicao_x2() == this.robo.getPosicaox()+1 || obs.getPosicao_x2() == this.robo.getPosicaox()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x2(),obs.getPosicao_y2()});
            }
            else if(obs.getPosicao_y2() == this.robo.getPosicaoy()+1 || obs.getPosicao_y2() == this.robo.getPosicaoy()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicao_x2(),obs.getPosicao_y2()});
            }
        }

        return obstaculos_vizinhos;
    }

    public void exibirObstaculos(List<int[]> obstaculos_vizinhos)
    {
        for(int[] obs : obstaculos_vizinhos)
        {
            System.out.printf("Obstáculo na posição (%d,%d)\n",obs[0],obs[1]);
        }
    }

    @Override
    public void monitorar(String nome_lugar){
        List<int[]> obstaculos_vizinhos = identificarObstaculos();
        exibirObstaculos(obstaculos_vizinhos);
    }
    
}
