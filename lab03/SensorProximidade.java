import java.util.ArrayList;
import java.util.List;

public class SensorProximidade extends Sensor{

    public SensorProximidade(double raio, Ambiente ambiente){
        super(raio, ambiente);
    }

    protected double distancia3D(Robo robo, Obstaculo obs) {
        //calcula a distancia entre o robo e um dado obstaculo
        double distancia_x = distancia1D(robo.getPosicaox(), obs.getPosicao_x1(), obs.getPosicao_x2());
        double distancia_y = distancia1D(robo.getPosicaoy(), obs.getPosicao_y1(), obs.getPosicao_y2());
        double distancia_z = 0;
        if (robo instanceof RoboAereo)
            distancia_z = distancia1D(((RoboAereo)robo).getAltitude(), 0, obs.getAltura());
        
        return  Math.sqrt(Math.pow(distancia_x, 2) + Math.pow(distancia_y, 2) + Math.pow(distancia_z, 2));
    }

    protected double distancia1D(double ponto, double min, double max) {
        //Essa funcao calcula a distancia de um ponto para outro em uma dimensao
        //sera usada para calcular a distancia de um robo ate um obstaculo 
        if (ponto < min) 
            return min - ponto;
        if (ponto > max) 
            return ponto - max;
        return 0;
    }

    public List<Obstaculo> identificarObstaculos(Robo robo){
        
        List<Obstaculo> obstaculos_vizinhos = new ArrayList<>();

        for(Obstaculo obs : this.ambiente.getObstaculos())
        {   
            double distancia = distancia3D(robo, obs);

            if(distancia == 0)   //robo colidiu
            {
                System.out.printf("Robô colidiu com o %s!\nPosição da colisão: (%d, %d, 0)", obs, robo.getPosicaox(), robo.getPosicaoy());
            }   
            else if(distancia <= getRaio()) {
                obstaculos_vizinhos.add(obs);
            }
        }

        return obstaculos_vizinhos;
    }

    public void exibirObstaculos(List<Obstaculo> obstaculos) {
        for(Obstaculo obs : obstaculos)
            System.out.println("    |->" + obs);
    }

    @Override
    public void monitorar(Robo robo) {
        List<Obstaculo> obstaculos_vizinhos = identificarObstaculos(robo);
        if (obstaculos_vizinhos.size() != 0) {
            System.out.printf("->Obstaculos encontrados pelo Sensor de Proximidade (no raio de proximidade igual a %.1f):\n", getRaio());
            exibirObstaculos(obstaculos_vizinhos);
        }
        else   
            System.out.println("->O Sensor de Proximidade nao encontrou Obstaculos");
    }

    @Override
    public String toString() {
        String out = "Sensor de Proximidade: ";
        out += "Raio de varredura = " + getRaio();
        return out;
    }
}
