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

    public void dentroDosLimites(Robo robo) {
        //retorna se o robô está, ou não, nos limites do ambiente.
        if (robo.getPosicaox() <= this.largura && robo.getPosicaox() >= 0 && robo.getPosicaoy() >= 0 && robo.getPosicaoy() <= this.comprimento)
            System.out.println("O robo esta dentro dos limites.");
        else
            System.out.println("O robo nao esta dentro dos limites.");
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }
}
