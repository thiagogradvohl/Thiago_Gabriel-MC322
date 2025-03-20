public class Robo 
{
    private String nome;
    private int posicaox;
    private int posicaoy;

    public Robo(int posicaox, int posicaoy, String nome) {
        //Método construtor: Define o nome, a posicao x e a posicao y do robô.
        this.nome = nome;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
    }

    public String getNome() {
        //retorna o nome do robô.
        return nome;
    }

    public int getPosicaox() {
        //retorna a posição x do robô.
        return posicaox;
    }

    public int getPosicaoy() {
        //retorna a posição y do robô.
        return posicaoy;
    }

    public void mover(int deltaX, int deltaY) {
        //move as posições x e y do robô de acordo com um delta x e um delta y.
        this.posicaox += deltaX;
        this.posicaoy += deltaY; 
    }
    
    public void exibirPosicao() {
        //imprime as posições x e y do robô.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", posicaox, posicaoy);
    }
}
