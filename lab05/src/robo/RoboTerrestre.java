package robo;
import ambiente.Ambiente;
import exceptions.*;
import missao.Missao;
import sensores.*;

public abstract class RoboTerrestre extends AgenteInteligente {
    //Essa subclasse representa os robos terrestres (metodo mover sobescrito depende da velocidade) e herda da classe Robo
    private int velocidadeMaxima;
    private int velocidade;
    
    public RoboTerrestre(int X, int Y, int Z, String id, int velocidadeMaxima, int velocidade, Sensor sensor, EstadoRobo estado, Missao missao) {
        super(X, Y, Z, id, sensor, estado, missao);
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
    public void moverPara(int X, int Y, int Z) throws Exception{
        //metodo sobrescrito do Robo, move o robo se a sua velocidade for menor que a velocidade maxima
        if (this.velocidade < this.velocidadeMaxima) {
            try {
                super.moverPara(X, Y, Z);
            } catch (RoboDesligadoException e) {
                throw new RoboDesligadoException();
            }
        }
        else   
            throw new VelocidadeExcedidaException();
    }

    @Override
    public void executarMissao(Ambiente a) throws Exception {
        if (this.getEstado() == EstadoRobo.LIGADO) {
            if (this.temMissao())
                this.missao.executar(this, a);
            else 
                throw new SemMissaoException();
        }
        else 
            throw new RoboDesligadoException();
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
