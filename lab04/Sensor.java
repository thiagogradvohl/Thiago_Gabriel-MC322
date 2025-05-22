public abstract class Sensor {
    //Essa classe abstrata representa os sensores dos robos.
    //Suas subclasses realizarao a sobescrita do metodo monitorar (abstrato)
    private double raio;

    public Sensor(double raio){
        this.raio = raio;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    public abstract void monitorar(Robo robo, Ambiente ambiente);

    @Override
    public String toString() {
        String out = "--Sensor--\n";
        out += "Raio de varredura = " + getRaio() + ".";
        return out;
    }
}
