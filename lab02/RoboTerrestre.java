public class RoboTerrestre extends Robo {
    private int velocidadeMaxima;
    private int velocidade;
    
    public RoboTerrestre(int posicaox, int posicaoy, String nome, int velocidadeMaxima, int velocidade) {
        super(posicaox, posicaoy, nome);
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidade = velocidade;
    }

    
    public int getVelocidadeMaxima() {
        return velocidadeMaxima;    
    }
    
    public int getVelocidade() {
        return velocidade;
    }

    
    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }


    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void mover(int delta_x, int delta_y) {
        //metodo sobrescrito do Robo, move o robo se a sua velocidade for menor que a velocidade maxima
        if (getVelocidade() > this.velocidadeMaxima || this.posicaox + delta_x < 0 || this.posicaoy + delta_y < 0)
            System.out.printf("Não foi possível realizar o movimento.\n");
        else {
            this.posicaox += delta_x;   
            this.posicaoy += delta_y;   
        } 
    }
}
