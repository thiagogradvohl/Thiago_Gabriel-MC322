public class RoverAutonomo extends RoboTerrestre implements Autonomo {
    //Subclasse de robos terrestres que percorre trechos de modo autonomo, usando uma bateria que descarrega pelo caminho
    private int energia;
    
    
    public RoverAutonomo(int X, int Y, int Z, String id, int velocidadeMaxima, int velocidade, int energia, Sensor sensor, EstadoRobo estado)
    {
        super(X, Y, Z, id, velocidadeMaxima, velocidade, sensor, estado);
        this.energia = energia;
    }
    public int getEnergia(){
        return this.energia;
    }
    
    public void setEnergia(int energia){
        this.energia = energia;
    }
    
    @Override
    public void recarregarBateria(int energia_adicionada){
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
    public void moverPara(int X, int Y, int Z) {
        //move o robo em uma distancia especificada em cada eixo do plano, seguindo uma pré-determinada velocidade.
        //computa o consumo de bateria do trajeto e verifica se ela será ou nao suficiente para o trajeto
        int consumo = Math.abs(X - getX()) + Math.abs(Y - getY()) + Math.abs(Z - getZ()); 
        if (energia < consumo) {
            System.out.println("Bateria insuficiente para o movimento.\nFavor carregar.");
            return;
        }
        else if (getX() + X >= 0 && getY() >= 0) {
            setX(X);
            setY(Y);
            setZ(Z);
            this.energia -= consumo;
        }
        else
            System.out.println("O robo nao se moveu, pois iria para coordenadas negativas.");

        System.out.printf("Movimento realizado.\nBateria restante: %d\n", getEnergia());
    }
}
