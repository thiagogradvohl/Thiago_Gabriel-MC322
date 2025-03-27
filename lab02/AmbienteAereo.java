public class AmbienteAereo extends Ambiente{
    private int altitude;

    public AmbienteAereo(int comprimento, int largura, int altitude) {
        //Método construtor: Define a altura e a largura do ambiente de movimentação do robô.
        super(comprimento, largura);
        this.altitude = altitude;

    }

    public int getAltitude()
    {
        return this.altitude;
    }

    public boolean dentroDosLimites(int x, int y, int z) {
        // Verifica se o robô está dentro dos limites considerando x, y e z
        return x <= getLargura() && x >= 0 && y >= 0 && y <= getcomprimento() && z <= getAltitude() && z >= 0;
    }
}
