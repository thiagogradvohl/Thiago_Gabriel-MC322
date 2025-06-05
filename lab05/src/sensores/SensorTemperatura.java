package sensores;

import robo.*;
import ambiente.*;

public class SensorTemperatura extends Sensor {
    private int temperatura_max;
    private int temperatura_min;
    //Esse sensor analisa a temperatura em um ambiente,
    //de acordo com o min e max, que sao seus atributos

    public SensorTemperatura(double raio, int temperatura_max, int temperatura_min){
        super(raio);
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
    public void monitorar(Robo robo, Ambiente ambiente){
        //Essa funcao analisa a temperatura em certo lugar no ambiente
        if (ambiente.getTemperatura() >= getTemperatura_max())
            System.out.printf("->ALERTA! Temperatura de suporte máxima atingida! Temperatura = %d C acima da maxima permitida (%d C). Status: Risco de danos estruturais!\n",ambiente.getTemperatura(),getTemperatura_max());
        
        else if (ambiente.getTemperatura() > getTemperatura_min())        
            System.out.printf("->Temperatura adequada. Temperatura = %d C dentro do padrao de %d até %d C\n",ambiente.getTemperatura(),getTemperatura_min(), getTemperatura_max());
        
        else    
            System.out.printf("->ALERTA! Temperatura de suporte minima atingida! Temperatura = %d C abaixo da minima permitida (%d C). Status: Risco de danos estruturais!\n",ambiente.getTemperatura(),getTemperatura_min());
    
    }

    @Override
    public String toString() {
        String out = "Sensor de Temperatura: ";
        out += "Raio de varredura = " + getRaio() + "; ";
        out += "Intervalo ideal de Temperatura: " + getTemperatura_min() + " até " + getTemperatura_max() + " C";
        return out;
    }

}
