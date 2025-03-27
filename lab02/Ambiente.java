public class Ambiente {
    private int comprimento;
    private int largura;

    public Ambiente(int comprimento, int largura) {
        //Método construtor: Define a comprimento e a largura do ambiente de movimentação do robô.
        this.comprimento = comprimento;
        this.largura = largura;
    }
    
    public int getcomprimento() {
        //retorna a comprimento do ambiente de movimentação do robô.
        return comprimento;
    }

    public int getLargura() {
        //retorna a largura do ambiente de movimentação do robô.
        return largura;
    }

    public boolean dentroDosLimites(int x, int y) {
        //retorna se o robô está, ou não, nos limites do ambiente.
        return x <= this.largura && x >= 0 && y >= 0 && y <= this.comprimento;
    }
}
