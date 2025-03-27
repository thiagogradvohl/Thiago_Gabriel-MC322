public class RoverAutonomo extends RoboTerrestre {
    //Subclasse de robos terrestres que percorre trechos de modo autonomo, usando uma bateria que descarrega pelo caminho
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
        //recarrega a bateria do robo por uma quantidade especificada
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
        //move o robo em uma distancia especificada em cada eixo do plano, seguindo uma pré-determinada velocidade.
        //computa o consumo de bateria do trajeto e verifica se ela será ou nao suficiente para o trajeto
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
