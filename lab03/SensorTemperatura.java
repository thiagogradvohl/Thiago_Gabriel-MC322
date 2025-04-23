public class SensorTemperatura extends Sensor{
    private int temperatura;

    public SensorTemperatura(double raio, int temperatura){
        super(raio);
        this.temperatura = temperatura;
    }
    
    public int getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public void monitorar(String nome_lugar, Robo robo){
        //Essa funcao analisa a temperatura em certo lugar no ambiente
        if(this.temperatura >= 70)
        {
            System.out.printf("ALERTA! Temperatura de suporte máxima atingida!\nLugar: %s\nTemperatura: %d\nStatus: Risco de danos estruturais!\n",nome_lugar,this.temperatura);
        }
        else if (this.temperatura>10)
        {
            System.out.printf("Temperatura adequada.\nLugar: %s\nTemperatura: %d\n",nome_lugar,this.temperatura);
        }
        else
        {
            System.out.printf("ALERTA! Temperatura de suporte mínima atingida!\nLugar: %s\nTemperatura: %d\nStatus: Risco de danos estruturais!",nome_lugar,this.temperatura);
        }
    }

    @Override
    public String toString() {
        String out = "--- Sensor de Temperatura ---\n";
        out += ".Raio de varredura = " + getRaio() + " .\n";
        out += ".Temperarura do ambiente = " + getTemperatura() + " .";
        return out;
    }

}
