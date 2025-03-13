package lab01;

public class Ambiente {
    private int altura;
    private int largura;

    public Ambiente(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public boolean dentroDosLimites(int x, int y) {
        return this.largura >= x && this.altura >= y;
    }
}