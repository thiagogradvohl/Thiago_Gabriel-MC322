public class Obstaculo implements Entidade {
    //Essa classe representa os obstaculos que serao colocados em um ambiente
    
    private int X1;
    private int Y1;
    private int Z;
    private int X;
    private int Y;
    private char representacao;
    private TipoObstaculo tipo_obs;
    private TipoEntidade tipo;

    public Obstaculo(int X1, int Y1, int Z, int X, int Y, TipoObstaculo tipo_obs) {
        //Metodo construtor: Nao utiliza o padrao do tipo do obstaculo
        this.X1 = X1;
        this.Y1 = Y1;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.tipo = TipoEntidade.OBSTACULO;
        this.tipo_obs = tipo_obs;
        this.representacao = TipoEntidade.OBSTACULO.getRepresentacao();
    }

    public Obstaculo(int X1, int Y1, TipoObstaculo tipo_obs) {
        //Método construtor: utiliza a Z, largura e comprimento padrao do tipo do obstaculo
        //posicao x1 e y1 sao o inicio do obstaculo
        this.X1 = X1;
        this.Y1 = Y1;
        this.X = X1 + tipo_obs.getComprimentoPadrao();
        this.Y = Y1 + tipo_obs.getLarguraPadrao();
        this.Z = tipo_obs.getAlturaPadrao();
        this.tipo = TipoEntidade.OBSTACULO;
        this.tipo_obs = tipo_obs;
    }

    public int getZ() {
        return Z;
    }

    public char getRepresentacao() {
        return representacao;
    }

    public TipoObstaculo getTipo_obs() {
        return tipo_obs;
    }

    public TipoEntidade getTipo() {
        return tipo;
    }

    public int getX1() {
        return X1;
    }

    public int getY1() {
        return Y1;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public TipoObstaculo getTipoObs() {
        return tipo_obs;
    }
    
    public String getDescricao() {  //getDescricao == toString?
        String out = "";
        out += "Obstaculo do tipo " + getTipo();
        out += " ocupa o espaco (" + getX1() + ", " + getY1() + ") x (" + getX() + ", " + getY() + ") x (0, " + getZ() + ")\n";
        return out;
    }
}

