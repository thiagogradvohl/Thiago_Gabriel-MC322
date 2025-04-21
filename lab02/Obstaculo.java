public class Obstaculo {
    //coordenadas do obstaculo aereo (possui altura):
    private int posicao_x1;
    private int posicao_y1;
    private int altura;
    //coordenadas do obstaculo terrestre:
    private int posicao_x2;
    private int posicao_y2;
    private TipoObstaculo tipo;
    
    public Obstaculo(int posicao_x1, int posicao_y1, int altura, TipoObstaculo tipo) {
        //Método construtor: Define o a posicao x, a posicao y, a posicao z e o tipo do obstaculo (aereo).
        this.posicao_x1 = posicao_x1;
        this.posicao_y1 = posicao_y1;
        this.altura = altura;
        this.tipo = tipo;
    }

    public Obstaculo(int posicao_x2, int posicao_y2, TipoObstaculo tipo) {
        //Método construtor: Define a posicao x e a posicao y e o tipo do obstaculo (terrestre).
        this.posicao_x2 = posicao_x2;
        this.posicao_y2 = posicao_y2;
        this.tipo = tipo;
    }

    public int getAltura() {
        return altura;
    }

    public int getPosicao_x1() {
        return posicao_x1;
    }

    public int getPosicao_y1() {
        return posicao_y1;
    }

    public int getPosicao_x2() {
        return posicao_x2;
    }

    public int getPosicao_y2() {
        return posicao_y2;
    }

    public TipoObstaculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoObstaculo tipo) {
        this.tipo = tipo;
    }

    public void setPosicao_x1(int posicao_x1) {
        this.posicao_x1 = posicao_x1;
    }

    public void setPosicao_y1(int posicao_y1) {
        this.posicao_y1 = posicao_y1;
    }

    public void setPosicao_x2(int posicao_x2) {
        this.posicao_x2 = posicao_x2;
    }

    public void setPosicao_y2(int posicao_y2) {
        this.posicao_y2 = posicao_y2;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String toString1() {
        //toString para o caso em que o obstaculo eh terrestre
        String out = "";
        out += "Obstaculo " + getTipo() + " esta na posicao (" + getPosicao_x2() + ", " + getPosicao_y2() + ")";
        return out;
    }

    public String toString2() {
        //toString para o caso em que o obstaculo eh aereo
        String out = "";
        out += "Obstaculo " + getTipo() + " esta na posicao (" + getPosicao_x1() + ", " + getPosicao_y1() + ", " + getAltura() + ")";
        return out;
    }
}