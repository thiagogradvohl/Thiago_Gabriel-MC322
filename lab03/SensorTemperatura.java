public class SensorTemperatura extends Sensor{
    private int temperatura_max;
    private int temperatura_min;

    public SensorTemperatura(double raio, Ambiente ambiente, int temperatura_max, int temperatura_min){
        super(raio, ambiente);
        this.temperatura_max = temperatura_max;
        this.temperatura_min = temperatura_min;
    }

    public int getTemperatura_max() {
        return temperatura_max;
    }

    public void setTemperatura_max(int temperatura_max) {
        this.temperatura_max = temperatura_max;
    }

    public int getTemperatura_min() {
        return temperatura_min;
    }

    public void setTemperatura_min(int temperatura_min) {
        this.temperatura_min = temperatura_min;
    }

    @Override
    public void monitorar(Robo robo){
        //Essa funcao analisa a temperatura em certo lugar no ambiente
        if (ambiente.getTemperatura() >= getTemperatura_max())
            System.out.printf("->ALERTA! Temperatura de suporte máxima atingida!\nTemperatura: %d C acima da maxima permitida (%d C)\nStatus: Risco de danos estruturais!\n",ambiente.getTemperatura(),getTemperatura_max());
        
        else if (ambiente.getTemperatura() > getTemperatura_min())        
            System.out.printf("->Temperatura adequada.\nTemperatura: %d C dentro do padrao de %d até %d C\n",ambiente.getTemperatura(),getTemperatura_min(), getTemperatura_max());
        
        else    
            System.out.printf("->ALERTA! Temperatura de suporte minima atingida!\nTemperatura: %d abaixo da minima permitida (%d C)\nStatus: Risco de danos estruturais!",ambiente.getTemperatura(),getTemperatura_min());
    
    }

    @Override
    public String toString() {
        String out = "Sensor de Temperatura: ";
        out += "Raio de varredura = " + getRaio() + "; ";
        out += "Intervalo ideal de Temperatura: " + getTemperatura_min() + " até " + getTemperatura_max() + " C";
        return out;
    }

}
