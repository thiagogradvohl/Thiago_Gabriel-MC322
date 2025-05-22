public class RoboTerrestre extends Robo {
        //Essa subclasse representa os robos terrestres (metodo mover sobescrito depende da velocidade) e herda da classe Robo
    private int velocidadeMaxima;
    private int velocidade;
    
    public RoboTerrestre(int posicaox, int posicaoy, String nome, int velocidadeMaxima, int velocidade, Sensor sensor) {
        super(posicaox, posicaoy, nome, sensor);
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
    public void mover(int delta_x, int delta_y) {
        //metodo sobrescrito do Robo, move o robo se a sua velocidade for menor que a velocidade maxima
        if (getVelocidade() > this.velocidadeMaxima || getPosicaox() + delta_x < 0 || getPosicaoy() + delta_y < 0)
            System.out.printf("Não foi possível realizar o movimento.\n");
        else {
            setPosicaox(getPosicaox()+delta_x); 
            setPosicaoy(getPosicaoy()+delta_y); 
        } 
    }

    @Override
    public String toString() {
        String out = "";
        out += "Robo terrestre " + getNome() + " esta na posicao " + "(" + getPosicaox() + ", " + getPosicaoy() + "), ";
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
