public class SensorOxigenio extends Sensor{
    //Esse sensor verifica a qualidade da concentracao de oxigenio em um ambiente,
    //de acordo com o min e max, que sao seus atributos
    private int concentracao_o2_min;  //unidade = mol/l
    private int concentracao_o2_max;

    public SensorOxigenio(double raio, Ambiente ambiente, int concentracao_o2_max, int concentracao_o2_min){
        super(raio, ambiente);
        this.concentracao_o2_max = concentracao_o2_max;
        this.concentracao_o2_min = concentracao_o2_min;
    }
    
    public int getConcentracao_o2_max() {
        return concentracao_o2_max;
    }
    
    public int getConcentracao_o2_min() {
        return concentracao_o2_min;
    }

    public void setConcentracao_o2_min(int concentracao_o2_min) {
        this.concentracao_o2_min = concentracao_o2_min;
    }

    public void setConcentracao_o2_max(int concentracao_o2_max) {
        this.concentracao_o2_max = concentracao_o2_max;
    }

    @Override
    public void monitorar(Robo robo){
        //Essa funcao analisa a concentracao de O2 em certo lugar no ambiente
        if (ambiente.getConcentracao_o2() > getConcentracao_o2_max()) { 
            System.out.printf("->Oxigenio elevado! Risco de oxidação acelerada/Risco de incêndio!\nConcentracao de O2: %d mol/l maior do que a maxima (%d mol/l)\nStatus: Risco de danos estruturais!\n",ambiente.getConcentracao_o2(), getConcentracao_o2_max());
        } else if (ambiente.getConcentracao_o2() >= getConcentracao_o2_min()) {
            System.out.printf("->Nivel normal! Concentracao de O2 = %d mol/l dentro da faixa de %d até %d mol/l\n",ambiente.getConcentracao_o2(), getConcentracao_o2_min(), getConcentracao_o2_max());
        } else {
            System.out.printf("->Pouco risco de oxidação.\nConcentração de O2: %d mol/l abaixo da minima (%d mol/l)\nStatus: Risco de danos estruturais!\n",ambiente.getConcentracao_o2(), getConcentracao_o2_min());
        }
    }

    @Override
    public String toString() {
        String out = "Sensor de Oxigenio: ";
        out += "Raio de varredura = " + getRaio() + "; ";
        out += "Intervalo ideal de Concentracao de O2: " + getConcentracao_o2_min() + " ate " + getConcentracao_o2_max() + " mol/l";
        return out;
    }
}
