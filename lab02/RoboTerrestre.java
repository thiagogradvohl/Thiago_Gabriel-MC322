public class RoboTerrestre extends Robo {
    private int velocidadeMaxima;
    private int velocidade;
    
    public RoboTerrestre(int posicaox, int posicaoy, String nome, int velocidadeMaxima, int velocidade) {
        super(posicaox, posicaoy, nome);
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidade=velociade.
    }

    
    public int getVelocidadeMaxima() {
        return velocidadeMaxima;    
    }
    
    public int getVelocidade() {
        return velocidade;
    }

    
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void mover(int delta_x, int delta_y) {
        //metodo sobrescrito do Robo, move o robo se a sua velocidade for menor que a velocidade maxima
        //para o calculo da velocidade considerou-se o tempo do movimento como sendo de 1 segundo
        if (getVelocidade() > this.velocidadeMaxima)
            System.out.printf("Não foi possível realizar o movimento. A velocidade está acima da velocidade máxima.\n");
        else {
            this.posicaox += delta_x;   
            this.posicaoy += delta_y;   
        } 
    }
}
