import java.util.ArrayList;
import java.util.List;

public class SensorProximidadeAereo extends SensorProximidade {
    //Essa classe é um tipo de sensor de proximidade (classe SensorProximidade) que funciona para RobosAereos
    //ou seja, considera a altitude tanto dos obstaculos quanto dos robos para a analise

    public SensorProximidadeAereo(double raio, Ambiente ambiente) {
        super(raio, ambiente);
    }

    public List<Obstaculo> identificarObstaculosAereos(RoboAereo robo_aereo){
        //Essa funcao identifica obstaculos vizinhos ao robo dentro do raio de busca
        List<Obstaculo> obstaculos_vizinhos = new ArrayList<>();

        for(Obstaculo obs : this.ambiente.obstaculos)
        {   
            //calculo da distancia minima entre o robo e o obstaculo:
            double distancia_x = distancia1D(robo_aereo.getPosicaox(), obs.getPosicao_x1(), obs.getPosicao_x2());
            double distancia_y = distancia1D(robo_aereo.getPosicaoy(), obs.getPosicao_y1(), obs.getPosicao_y2());
            double distancia_z = distancia1D(robo_aereo.getAltitude(), 0, obs.getAltura());
            double distancia = Math.sqrt(Math.pow(distancia_x, 2) + Math.pow(distancia_y, 2) + Math.pow(distancia_z, 2));

            if(distancia == 0) 
                System.out.printf("Robô colidiu com o %s!\nPosição da colisão: (%d,%d,%d)",obs,robo_aereo.getPosicaox(),robo_aereo.getPosicaoy(),robo_aereo.getAltitude());
    
            else if(distancia <= getRaio())  //dentro do raio de busca
                obstaculos_vizinhos.add(obs);
        }

        return obstaculos_vizinhos;
    }

    public void monitorar(RoboAereo robo_aereo) {
        //Sobrecarga do metodo monitorar do SensorProximidade para analisar a proximidade para
        //um RoboAereo 
        List<Obstaculo> proximos = identificarObstaculosAereos(robo_aereo);
        if (proximos != null) {
            System.out.printf("->Obstaculos encontrados pelo Sensor de Altitude (no raio de proximidade igual a %d):\n",getRaio());
            exibirObstaculos(proximos);
        }
        else   
            System.out.println("->O Sensor de Altitude nao encontrou Obstaculos.");
    }

    @Override
    public String toString() {
        String out = "--Sensor de Altitude\n";
        out += "Raio de varredura = " + getRaio() + " .";
        return out;
    }
}
