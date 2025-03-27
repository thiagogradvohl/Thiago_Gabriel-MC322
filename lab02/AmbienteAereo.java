public class AmbienteAereo extends Ambiente{
    private int altitude;

    public AmbienteAereo(int comprimento, int largura, int altitude) {
        //Método construtor: Define a altura e a largura do ambiente de movimentação do robô.
        super(comprimento, largura);
        this.altitude = altitude;

    }
    
    public void dentroDosLimites(RoboAereo robo) {
        //retorna se o robô está, ou não, nos limites do ambiente.
        if (robo.getPosicaox() <= getLargura() && robo.getPosicaox() >= 0 && robo.getPosicaoy() >= 0 && robo.getPosicaoy() <= getcomprimento() && robo.getAltitude() <= getAltitude() && robo.getAltitude() >= 0)
        System.out.println("O robo esta dentro dos limites.");
        else
        System.out.println("O robo nao esta dentro dos limites.");
    }
    
    public int getAltitude()
    {
       return this.altitude;
    }
    
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
