import java.util.ArrayList;
import java.util.List;

public class RoboAereo extends Robo {
    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(int posicaox, int posicaoy, int altitude, int altitudeMaxima, String nome) {  //método construtor para o robo aereo
        super(posicaox, posicaoy, nome);  //determina os atributos ja existentes na classe mae
        this.altitude = altitude;
        this.altitudeMaxima = altitudeMaxima;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public void subir(int metros) {
        //Essa funcao faz o robo subir em altitude se possivel
        if (this.altitude + metros <= altitudeMaxima) 
            this.altitude += metros;
    }

    public void descer(int metros) {
        //Essa funcao faz o robo descer em altitude se possivel
        if (this.altitude - metros >= 0)
            this.altitude -= metros;
    }
    
    public List<int[]> identificarObstaculosAereos(List<ObstaculoAereo> obstaculos){
        //identifica
        
        List<int[]> obstaculos_vizinhos = new ArrayList<>();

        for(ObstaculoAereo obs : obstaculos)
        {
            if(obs.getPosicaox() == getPosicaox()+1 || obs.getPosicaox() == getPosicaox()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicaox(),obs.getPosicaoy(),obs.getAltitudeObs()});
            }
            else if(obs.getPosicaoy() == getPosicaoy()+1 || obs.getPosicaoy() == getPosicaoy()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicaox(),obs.getPosicaoy(),obs.getAltitudeObs()});
            }
            else if (obs.getAltitudeObs() == getAltitude()+1 || obs.getAltitudeObs() == getAltitude()-1)
            {
                obstaculos_vizinhos.add(new int[]{obs.getPosicaox(),obs.getPosicaoy(),obs.getAltitudeObs()});
            }
        }

        return obstaculos_vizinhos;
    }

    @Override
    public void exibirObstaculos(List<int[]> obstaculos)
    {
        for(int[] obs : obstaculos)
        {
            System.out.printf("Obstáculo na posição (%d,%d,%d)\n",obs[0],obs[1],obs[2]);
        }
    }

    @Override
    public void exibirPosicao() {
        //imprime as posições x e y do robô.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\nAltitude: %d\n", getPosicaox(), getPosicaoy(), getAltitude());
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setAltitudeMaxima(int altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }
}
