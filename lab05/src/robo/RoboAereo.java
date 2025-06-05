package robo;
import sensores.*;
import ambiente.Ambiente;
import exceptions.RoboDesligadoException;
import exceptions.SemMissaoException;
import missao.*;

public abstract class RoboAereo extends AgenteInteligente {
    //Essa subclasse representa os robos com altura (robos aereos) e herda da classe Robo
    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(int X, int Y, int altitude, int altitudeMaxima, String id, Sensor sensor, EstadoRobo estado, Missao missao) {  //método construtor para o robo aereo
        super(X, Y, altitude, id, sensor, estado, missao);  //determina os atributos ja existentes na classe mae
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
    public void executarMissao(Ambiente a) throws Exception {
        if (this.getEstado() == EstadoRobo.LIGADO) {
            if (this.temMissao())
                this.missao.executar(this, a);
            else 
                throw new SemMissaoException();
        }
        else 
            throw new RoboDesligadoException();
    }

    @Override
    public String getDescricao() {
        String out = "";
        out += "Robo aereo " + getId() + " esta na posicao " + "(" + getX() + ", " + getY() + ", " + getAltitude() + "), ";
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
