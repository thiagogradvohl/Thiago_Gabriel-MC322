public class Ambiente {
    private int altura;
    private int largura;

    public Ambiente(int altura, int largura) {
        //Método construtor: Define a altura e a largura do ambiente de movimentação do robô.
        this.altura = altura;
        this.largura = largura;
    }
    
    public int getAltura() {
        //retorna a altura do ambiente de movimentação do robô.
        return altura;
    }

    public int getLargura() {
        //retorna a largura do ambiente de movimentação do robô.
        return largura;
    }

    public boolean dentroDosLimites(int x, int y) {
        //retorna se o robô está, ou não, nos limites do ambiente.
        return x <= this.largura && x >= 0 && y >= 0 && y <= this.altura;
    }
}
