public class BB_8 extends RoboTerrestre implements Atacante {
    //esse robo se locomove como uma bola, com frequencia angular, diametro e velocidade caracteristicos
    private int diametro;
    private int frequencia_rotacao;
    private boolean modo_ataque;
    private int municao;

    public BB_8(int diametro, int frequencia_rotacao, boolean modo_ataque, int X, int Y, int Z, String id, int velocidadeMaxima, int municao, Sensor sensor, EstadoRobo estado) {
        super(X, Y, Z, id, velocidadeMaxima, 0, sensor, estado);
        this.diametro = diametro;
        this.frequencia_rotacao = frequencia_rotacao;
        this.modo_ataque = modo_ataque;
        this.municao = municao;
        setVelocidade(velocidade());
    }

    private int velocidade() {
        //metodo velocidade sobrecarregado da super classe RoboTerrestre,
        //calcula a velocidade do BB_8 com base no diametro e na frequencia angular
        //velocidade = f * d * pi
        return this.frequencia_rotacao * this.diametro * (int) Math.PI;
    }

    public int getMunicao() {
        return municao;
    }

    @Override
    public void executarTarefa() throws RoboDesligadoException {  
        //atacar a posicao em que esta
        if (this.getEstado() == EstadoRobo.LIGADO) {
            if (this.modo_ataque && this.municao > 0) {
                if (this.municao >= 10)
                    this.municao -= 10;   //perda de 10 municoes por ataque
                else   
                    this.municao = 0;
                System.out.printf("O BB_8 atacou o alvo na sua posicao: (%d, %d, %d)\n", getX(), getY(), getZ());
            }
            else
                System.out.println("O robo nao atacou. O modo ataque esta desligado.");  //exception no ammo or exception offattack
        }
        else
            throw new RoboDesligadoException();    
    }

    @Override
    public void recarregarMunicao(int municao) {
        this.municao += municao;
    }

    @Override
    public void ligarModoAtaque() {
        if (this.modo_ataque) 
            System.out.println("O modo ataque ja esta ligado.");
        else {
            this.modo_ataque = true;
            System.out.println("O modo ataque foi ligado!");
        }
    }

    @Override
    public void desligarModoAtaque() {
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

    @Override
    public String getDescricao() {
        String out = "";
        out += "BB8 " + getId();
        out += " (" + getEstado(); 
        if (this.modo_ataque)
            out += " e modo ataque: LIGADO)";
        else   
            out += " e modo ataque: DESLIGADO)";
        out += " esta na posicao " + "(" + getX() + ", " + getY() + ", " + getZ() + "), ";
        out += "com Municao = " + getMunicao();
        out += ", com Diametro = " + getDiametro(); 
        out += ", com  frequencia de rotacao = " + getFrequencia_rotacao();
        out += ", e com Velocidade = " + getVelocidade() + " x Velocidade Maxima = " + getVelocidadeMaxima() + ":\n";
        if (getSensores() == null) 
            out += "        |-->Ele nao possui sensores.";
        else {
            out += "        |-->Sensores:\n";
            for (Sensor s : getSensores())
                out += "          |-->" + s.toString() + "\n";
        }
        return out;
    } 
}
