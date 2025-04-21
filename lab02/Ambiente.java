import java.util.ArrayList;

public class Ambiente {
    private int comprimento;
    private int largura;
    private int altitude;
    ArrayList<Robo> robos;
    ArrayList<Obstaculo> obstaculos;

    public Ambiente(int comprimento, int largura, int altitude) {
        //Método construtor: Define a comprimento, a largura e cria os arrays que armazenam robos e obstaculos do ambiente.
        this.comprimento = comprimento;
        this.largura = largura;
        this.altitude = altitude;
        this.robos = new ArrayList<Robo>();
        this.obstaculos = new ArrayList<Obstaculo>();
    }
    
    public int getcomprimento() {
        //retorna a comprimento do ambiente de movimentação do robô.
        return comprimento;
    }
    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    
    public ArrayList<Robo> getRobos() {
        return robos;
    }
    public void setRobos(ArrayList<Robo> robos) {
        this.robos = robos;
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return obstaculos;
    }
    public void setObstaculos(ArrayList<Obstaculo> obstaculos) {
        this.obstaculos = obstaculos;
    }

    public int getLargura() {
        //retorna a largura do ambiente de movimentação do robô.
        return largura;
    }
    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltitude(){
        return altitude;
    }
    public void setAltitude(int altitude){
        this.altitude = altitude;
    }

    public void dentroDosLimites(Robo robo) {
        //retorna se o robô está, ou não, nos limites do ambiente.
        if (robo.getPosicaox() <= this.largura && robo.getPosicaox() >= 0 && robo.getPosicaoy() >= 0 && robo.getPosicaoy() <= this.comprimento)
            System.out.println("O robo esta dentro dos limites.");
        else
            System.out.println("O robo nao esta dentro dos limites.");
    }
    
    public void adicionarRobo(Robo r) {
        this.robos.add(r);
    }

    public void removerRobo(Robo r) {
        this.robos.remove(r);
    }
    
}