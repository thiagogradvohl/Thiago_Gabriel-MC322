public class RoboTerrestre extends Robo {
    private int velocidadeMaxima;
    
    public RoboTerrestre(int posicaox, int posicaoy, String nome, int velocidadeMaxima) {
        super(posicaox, posicaoy, nome);
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;    
    }
    
    public void mover(int delta_x, int delta_y, int velocidade) {
        if (velocidade > this.velocidadeMaxima)
            System.out.printf("Não foi possível realizar o movimento. A velocidade está acima da velocidade máxima.\n");
        else 
            mover(delta_x, delta_y);
    }   
}