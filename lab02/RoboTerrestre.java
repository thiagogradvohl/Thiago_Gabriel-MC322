public class RoboTerrestre extends Robo {
    private int velocidadeMaxima;
    
    public RoboTerrestre(int posicaox, int posicaoy, String nome, int velocidadeMaxima) {
        super(posicaox, posicaoy, nome);
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;    
    }

    private int velocidade(int delta_x, int delta_y) {
        //calcula a velocidade do movimento (em m/s), considerando este como sendo realizado em 1 segundo
        return (int) Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2));
    }

    @Override
    public void mover(int delta_x, int delta_y) {
        //metodo sobrescrito do Robo, move o robo se a sua velocidade for menor que a velocidade maxima
        //para o calculo da velocidade considerou-se o tempo do movimento como sendo de 1 segundo
        if (velocidade(delta_x, delta_y) > this.velocidadeMaxima)
            System.out.printf("Não foi possível realizar o movimento. A velocidade está acima da velocidade máxima.\n");
        else {
            this.posicaox += delta_x;   
            this.posicaoy += delta_y;   
        } 
    }
}