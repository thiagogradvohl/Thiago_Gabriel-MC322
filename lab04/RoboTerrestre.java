public abstract class RoboTerrestre extends Robo {
    //Essa subclasse representa os robos terrestres (metodo mover sobescrito depende da velocidade) e herda da classe Robo
    private int velocidadeMaxima;
    private int velocidade;
    
    public RoboTerrestre(int X, int Y, int Z, String id, int velocidadeMaxima, int velocidade, Sensor sensor, EstadoRobo estado) {
        super(X, Y, Z, id, sensor, estado);
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidade = velocidade;
    }
    
    public int getVelocidadeMaxima() {
        return velocidadeMaxima;    
    }
    
    public int getVelocidade() {
        return velocidade;
    }

    
    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }


    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void moverPara(int X, int Y, int Z) throws RoboDesligadoException{
        //metodo sobrescrito do Robo, move o robo se a sua velocidade for menor que a velocidade maxima
        if (this.velocidade < this.velocidadeMaxima) {
            try {
                super.moverPara(X, Y, Z);
            } catch (RoboDesligadoException e) {
                throw new RoboDesligadoException();
            }
        }
        //exception velocidade maxima
    }

    @Override
    public String getDescricao() {
        String out = "";
        out += "Robo terrestre " + getId() + " esta na posicao " + "(" + getX() + ", " + getY() + "), ";
        out += "com Velocidade = " + getVelocidade() + " x Velocidade Maxima = " + getVelocidadeMaxima() + ":\n";
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
