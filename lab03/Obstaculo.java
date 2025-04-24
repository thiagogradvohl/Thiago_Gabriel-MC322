public class Obstaculo {
    private int posicao_x1;
    private int posicao_y1;
    private int altura;
    private int posicao_x2;
    private int posicao_y2;
    private TipoObstaculo tipo;
    
    public Obstaculo(int posicao_x1, int posicao_y1, int altura, int posicao_x2, int posicao_y2, TipoObstaculo tipo) {
        //Metodo construtor: Nao utiliza o padrao do tipo do obstaculo
        this.posicao_x1 = posicao_x1;
        this.posicao_y1 = posicao_y1;
        this.posicao_x2 = posicao_x2;
        this.posicao_y2 = posicao_y2;
        this.altura = altura;
        this.tipo = tipo;
    }

    public Obstaculo(int posicao_x1, int posicao_y1, TipoObstaculo tipo) {
        //Método construtor: utiliza a altura, largura e comprimento padrao do tipo do obstaculo
        //posicao x1 e y1 sao o inicio do obstaculo
        this.posicao_x1 = posicao_x1;
        this.posicao_y1 = posicao_y1;
        this.posicao_x2 = posicao_x1 + tipo.getComprimentoPadrao();
        this.posicao_y2 = posicao_y1 + tipo.getLarguraPadrao();
        this.altura = tipo.getAlturaPadrao();
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

    public String toString() {
        String out = "";
        out += "Obstaculo do tipo " + getTipo();
        out += " ocupa o espaco (" + getPosicao_x1() + ", " + getPosicao_y1() + ") x (" + getPosicao_x2() + ", " + getPosicao_y2() + ") x (0, " + getAltura() + ")\n";
        return out;
    }
}

