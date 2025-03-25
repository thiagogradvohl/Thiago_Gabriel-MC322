public class BB_8 extends RoboTerrestre {
    //esse robo se locomove como uma bola, com frequencia angular, diametro e velocidade caracteristicos
    private int diametro;
    private int frequencia_rotacao;
    private int velocidade;

    public BB_8(int diametro, int frequencia_rotacao, int posicaox, int posicaoy, String nome, int velocidadeMaxima) {
        super(posicaox, posicaoy, nome, velocidadeMaxima);
        this.diametro = diametro;
        this.frequencia_rotacao = frequencia_rotacao;
        this.velocidade = velocidade();
    }

    private int velocidade() {
        //metodo velocidade sobrecarregado da super classe RoboTerrestre,
        //calcula a velocidade do BB_8 com base no diametro e na frequencia angular
        //velocidade = f * d * pi
        return this.frequencia_rotacao * this.diametro * (int) Math.PI;
    }

    @Override
    public void mover(int delta_x, int delta_y) {
        //metodo mover sobrescrito do Robo e RoboTerrestre
        //agora considera a velocidade caracteristica do objeto e nao mais o movimento em 1 segundo (RoboTerrestre) 
        if (this.velocidade > this.getVelocidadeMaxima())
            System.out.printf("Não foi possível realizar o movimento. A velocidade está acima da velocidade máxima.\n");
        else {
            this.posicaox += delta_x;   
            this.posicaoy += delta_y;  
        }    
    }

    public int getDiametro() {
        return diametro;
    }

    public int getFrequencia_rotacao() {
        return frequencia_rotacao;
    }

    public int getVelocidade() {
        return velocidade;
    }
}