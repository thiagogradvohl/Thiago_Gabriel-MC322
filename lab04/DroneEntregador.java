public class DroneEntregador extends RoboAereo {
    //Essa é uma subclasse de robos aereos que representam robos entregadores. 
    //Eles operam com destinos e pontos de partida, e as respectivas coordenadas de ambos lugares. Além disso, o robo é provido com um metodo de calcular distancia total e a restante ao ponto de chegada
    int destino_X;
    int destino_Y;
    int destino_z;

    public DroneEntregador(int X, int Y, int altitude, int altitudeMaXima, String id, int destino_X, int destino_Y, int destino_z, int partida_X, int partida_Y, int partida_z, Sensor sensor, EstadoRobo estado){
        super(X, Y, altitude, altitudeMaXima, id, sensor, estado);
        this.destino_X = destino_X;
        this.destino_Y = destino_Y;
        this.destino_z = destino_z;
    }

    public double CalculaDistanciaRestante(){
        //calcula e imprime para cada dada posição do robo, a distancia restante para chegar no destino
        double distancia_restante = Math.sqrt(
            Math.pow((destino_X - getX()), 2) +
            Math.pow((destino_Y - getY()), 2) +
            Math.pow((destino_z - getZ()), 2)
        );
        return distancia_restante;
    }
    
    @Override
    public void moverPara(int X, int Y, int Z) {
        if (CalculaDistanciaRestante() != 0)
            super.moverPara(X, Y, Z);
        if (CalculaDistanciaRestante() == 0)
            executarTarefa();
    }
    
    @Override
    public void executarTarefa() {
        if (CalculaDistanciaRestante() == 0 && this.getEstado() == EstadoRobo.LIGADO) {
            System.out.println("Encomenda entregue ao destino.");
            this.setEstado(EstadoRobo.DESLIGADO);
        }
        else if (this.getEstado() == EstadoRobo.DESLIGADO) {} //exception

        else {} //exception ainda nao chegou ao destino
    }
}
