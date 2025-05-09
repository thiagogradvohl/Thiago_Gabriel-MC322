public class RoboAereo extends Robo {
    //Essa subclasse representa os robos com altura (robos aereos) e herda da classe Robo
    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(int posicaox, int posicaoy, int altitude, int altitudeMaxima, String nome, Sensor sensor) {  //método construtor para o robo aereo
        super(posicaox, posicaoy, nome, sensor);  //determina os atributos ja existentes na classe mae
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
    
    
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setAltitudeMaxima(int altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }

    @Override
    public String toString() {
        String out = "";
        out += "Robo aereo " + getNome() + " esta na posicao " + "(" + getPosicaox() + ", " + getPosicaoy() + ", " + getAltitude() + "), ";
        out += "com Altura maxima = " + getAltitudeMaxima() + ":\n";
        if (getSensores() == null) 
            out += "        |->Ele nao possui sensores.";
        else {
            out += "        |-->Sensores:\n";
            for (Sensor s : getSensores())
                out += "          |-->" + s.toString() + "\n";
        }
        return out;
    } 
}
