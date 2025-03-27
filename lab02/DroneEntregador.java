public class DroneEntregador extends RoboAereo {
    int destino_x;
    int destino_y;
    int destino_z;
    String nome_destino;

    int partida_x;
    int partida_y;
    int partida_z;
    String nome_partida;

    public DroneEntregador(int posicaox, int posicaoy, int altitude, int altitudeMaxima, String nome, int destino_x, int destino_y, int destino_z, String nome_destino, String nome_partida, int partida_x, int partida_y, int partida_z){
        super(posicaox, posicaoy, altitude, altitudeMaxima, nome);
        this.destino_x = destino_x;
        this.destino_y = destino_y;
        this.destino_z = destino_z;
        this.nome_destino = nome_destino;
        this.nome_partida = nome_partida;
        this.partida_x = partida_x;
        this.partida_y = partida_y;
        this.partida_z = partida_z;
    }

    public void CalculaDistanciaTotal(){
        double distancia_total = Math.sqrt(
            Math.pow((destino_x - partida_x), 2) +
            Math.pow((destino_y - partida_y), 2) +
            Math.pow((destino_z - partida_z), 2)
        );

        System.out.printf("A distância total do trajeto é: %.2f\n",distancia_total);
    }

    public void CalculaDistanciaRestante(){
        double distancia_restante = Math.sqrt(
            Math.pow((destino_x - getPosicaox()), 2) +
            Math.pow((destino_y - getPosicaoy()), 2) +
            Math.pow((destino_z - getAltitude()), 2)
        );
        System.out.printf("A distância restante do trajeto é: %.2f\n",distancia_restante);
    }
    

}
