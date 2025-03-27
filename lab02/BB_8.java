public class BB_8 extends RoboTerrestre {
    //esse robo se locomove como uma bola, com frequencia angular, diametro e velocidade caracteristicos
    private int diametro;
    private int frequencia_rotacao;
    private boolean modo_ataque;

    public BB_8(int diametro, int frequencia_rotacao, int posicaox, int posicaoy, String nome, int velocidadeMaxima, boolean modo_ataque) {
        super(posicaox, posicaoy, nome, velocidadeMaxima, 0);
        this.diametro = diametro;
        this.frequencia_rotacao = frequencia_rotacao;
        this.modo_ataque = modo_ataque;
        setVelocidade(velocidade());
    }

    private int velocidade() {
        //metodo velocidade sobrecarregado da super classe RoboTerrestre,
        //calcula a velocidade do BB_8 com base no diametro e na frequencia angular
        //velocidade = f * d * pi
        return this.frequencia_rotacao * this.diametro * (int) Math.PI;
    }

    public void atacar() {
        if (this.modo_ataque)
            System.out.printf("O BB_8 atacou o alvo na sua posicao: (%d, %d)\n", getPosicaox(), getPosicaoy());
        else
            System.out.println("O robo nao atacou. O modo ataque esta desligado.");
    }

    public void ligar_modo_ataque() {
        if (this.modo_ataque) 
            System.out.println("O modo ataque ja esta ligado.");
        else {
            this.modo_ataque = true;
            System.out.println("O modo ataque foi ligado!");
        }
    }

    public void desligar_modo_ataque() {
        if (!this.modo_ataque) 
            System.out.println("O modo ataque ja esta desligado.");
        else {
            this.modo_ataque = false;
            System.out.println("O modo ataque foi desligado!");
        }
    }

    public int getDiametro() {
        return diametro;
    }

    public int getFrequencia_rotacao() {
        return frequencia_rotacao;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public void setFrequencia_rotacao(int frequencia_rotacao) {
        this.frequencia_rotacao = frequencia_rotacao;
    }

    public boolean isModo_ataque() {
        return modo_ataque;
    }

    public void setModo_ataque(boolean modo_ataque) {
        this.modo_ataque = modo_ataque;
    }
}
