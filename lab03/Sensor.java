public abstract class Sensor {
    private double raio;
    Ambiente ambiente;

    public Sensor(double raio, Ambiente ambiente){
        this.raio = raio;
        this.ambiente = ambiente;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public abstract void monitorar(Robo robo);

    public String toString() {
        String out = "--Sensor--\n";
        out += "Raio de varredura = " + getRaio() + ".";
        return out;
    }
}
