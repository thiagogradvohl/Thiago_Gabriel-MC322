public class RoverAutonomo extends RoboTerrestre {
    int energia;
    
    
    public RoverAutonomo(int posicaox, int posicaoy, String nome, int velocidadeMaxima, int energia)
    {
        super(posicaox, posicaoy, nome, velocidadeMaxima);
        this.energia = energia;
    }
    public int getEnergia(){
        return this.energia;
    }
    public void setEnergia(int energia){
        this.energia = energia;
    }
   
    public void Recarregar(int energia_adicionada){
        setEnergia(getEnergia()+energia_adicionada);
        if(getEnergia() > 100)
        {
            System.out.println("Carga concluída. Bateria completamente carregada.\n");
            return;
        }
        System.out.printf("Status da bateria: %d\n", getEnergia());
    }

    @Override
    public void mover(int delta_x, int delta_y, int velocidade) {
        int consumo = Math.abs(delta_x) + Math.abs(delta_y); 
        if (energia < consumo) {
            System.out.println("Bateria insuficiente para o movimento. \nFavor carregar\n.");
            return;
        }
        super.mover(delta_x, delta_y, velocidade);
        this.energia -= consumo;
        System.out.printf("Movimento realizado.\nBateria restante: %d", getEnergia());
    }
}
