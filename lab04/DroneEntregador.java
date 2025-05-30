public class DroneEntregador extends RoboAereo {
    //Essa é uma subclasse de robos aereos que representam robos entregadores. 
    //Eles operam com destinos e pontos de partida, e as respectivas coordenadas de ambos lugares. Além disso, o robo é provido com um metodo de calcular distancia total e a restante ao ponto de chegada
    int destino_X;
    int destino_Y;
    int destino_z;
    String produto;

    public DroneEntregador(int X, int Y, int altitude, int altitudeMaXima, String id, int destino_X, int destino_Y, int destino_z, Sensor sensor, EstadoRobo estado, String produto){
        super(X, Y, altitude, altitudeMaXima, id, sensor, estado);
        this.destino_X = destino_X;
        this.destino_Y = destino_Y;
        this.destino_z = destino_z;
        this.produto = produto;
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
    public void executarTarefa() throws Exception {
        //realiza a entrega na posicao de destino e desliga automaticamente
        if (this.getEstado() == EstadoRobo.DESLIGADO)
            throw new RoboDesligadoException(); //exception
            
        else if (CalculaDistanciaRestante() == 0) {
            System.out.printf("Encomenda %s entregue ao destino.\n", this.produto);
            this.produto = "Nada";
            this.setEstado(EstadoRobo.DESLIGADO);
        }

        else 
            System.out.printf("O robo ainda nao chegou ao seu destino (%d, %d, %d)!\n", this.destino_X, this.destino_Y, this.destino_z);
    }

    public void novaEntrega(int novoDestinoX, int novoDestinoY, int novoDestinoZ, String novoProduto) {
        this.destino_X = novoDestinoX;
        this.destino_Y = novoDestinoY;
        this.destino_z = novoDestinoZ;
        this.produto = novoProduto;
    }

    public void setDestino_X(int destino_X) {
        this.destino_X = destino_X;
    }

    public void setDestino_Y(int destino_Y) {
        this.destino_Y = destino_Y;
    }

    public void setDestino_z(int destino_z) {
        this.destino_z = destino_z;
    }

    @Override
    public String getDescricao() {
        String out = "";
        out += "DroneEntregador " + getId();
        out += " (" + getEstado() + ")";
        out += " esta na posicao " + "(" + getX() + ", " + getY() + ", " + getZ() + "), ";
        out += "com altitude maxima = " + getAltitudeMaxima();
        out += ", com destino em (" + getDestino_X() + ", " + getDestino_Y() + ", " + getDestino_z() + ")";
        out += ", e carrega " + getProduto() + ":\n"; 

        if (getSensores() == null) 
            out += "        |-->Ele nao possui sensores.";
        else {
            out += "        |-->Sensores:\n";
            for (Sensor s : getSensores())
                out += "          |-->" + s.toString() + "\n";
        }
        return out;
    }

    public int getDestino_X() {
        return destino_X;
    }

    public int getDestino_Y() {
        return destino_Y;
    }

    public int getDestino_z() {
        return destino_z;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    } 
}
