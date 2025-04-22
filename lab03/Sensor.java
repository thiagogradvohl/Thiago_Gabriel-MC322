public abstract class Sensor {
    private double raio;

    public Sensor(double raio){
        this.raio = raio;
    }
    public double getRaio(){
        return this.raio;
    }
    public void setRaio(int raio){
        this.raio = raio;
    }
    public abstract void monitorar(String nome_lugar);

    
}
