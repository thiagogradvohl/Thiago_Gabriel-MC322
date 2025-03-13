class Robo 
{
    private String nome;
    private int posicaox;
    private int posicaoy;

    public Robo(int posicaox, int posicaoy, String nome) {
        this.nome = nome;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicaox() {
        return posicaox;
    }

    public int getPosicaoy() {
        return posicaoy;
    }

    public void mover(int deltaX, int deltaY) {
        this.posicaox += deltaX;
        this.posicaoy += deltaY; 
    }
    
    public void exibirPosicao() {
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", posicaox, posicaoy);
    }
}