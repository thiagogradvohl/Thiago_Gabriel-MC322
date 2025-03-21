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
}