public class SensorOxigenio extends Sensor{
    private int concentracao_o2;

    public SensorOxigenio(double raio, int concentracao_o2){
        super(raio);
        this.concentracao_o2 = concentracao_o2;
    }
    
    public int getConcentracao_o2() {
        return concentracao_o2;
    }
    
    public void setconcentracao_o2(int concentracao_o2) {
        this.concentracao_o2 = concentracao_o2;
    }

    @Override

    public void monitorar(String nome_lugar){

        if (concentracao_o2 > 50) {
            System.out.printf("Oxigênio elevado! Risco de oxidação acelerada/Risco de incêndio!\nLugar: %s\nTemperatura: %d\nStatus: Risco de danos estruturais!\n",nome_lugar,this.concentracao_o2);
        } else if (concentracao_o2 >= 21) {
            System.out.printf("Nível normal\nLugar: %s\nTemperatura: %d\nStatus: Risco de danos estruturais!\n",nome_lugar,this.concentracao_o2);
        } else {
            System.out.printf("Pouco risco de oxidação.\nLugar: %s\nTemperatura: %d\nStatus: Risco de danos estruturais!\n",nome_lugar,this.concentracao_o2);
        }
    }

}
