import java.util.ArrayList;

public class Ambiente {
    private int comprimento;
    private int largura;
    private int altitude;
    private final int concentracao_o2;
    private final int temperatura;
    private ArrayList<Robo> robos;
    private ArrayList<Obstaculo> obstaculos;

    public Ambiente(int comprimento, int largura, int altitude, int concentracao_o2, int temperatura) {
        //Método construtor: Define a comprimento, a largura e cria os arrays que armazenam robos e obstaculos do ambiente.
        this.comprimento = comprimento;
        this.largura = largura;
        this.altitude = altitude;
        this.concentracao_o2 = concentracao_o2;
        this.temperatura = temperatura;
        this.robos = new ArrayList<Robo>();
        this.obstaculos = new ArrayList<Obstaculo>();
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getConcentracao_o2() {
        return concentracao_o2;
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

    public boolean dentroDosLimites(Robo robo) {
        //retorna se o robô está, ou não, nos limites do ambiente.
        if (robo.getPosicaox() <= this.largura && robo.getPosicaox() >= 0 && robo.getPosicaoy() >= 0 && robo.getPosicaoy() <= this.comprimento)
            if (!(robo instanceof RoboAereo) || (robo instanceof RoboAereo && ((RoboAereo)robo).getAltitude() <= this.getAltitude()))  //se robo nao for aereo e se robo for aereo (downcasting) e estiver dentro da altura
                return true;
        return false;
    }
    
    public void adicionarRobo(Robo r) {
        //adiciona o robo ao ambiente se ele estiver dentro dos limites
        if (dentroDosLimites(r)) {
            this.robos.add(r);
            System.out.println("O robo foi adicionado ao ambiente!");
        }

        else
            System.out.println("O robo nao foi adicionado ao ambiente! Ele esta fora dos limites.");
    }

    public void removerRobo(Robo r) {
        this.robos.remove(r);
    }
    
    public void adicionarObstaculo(Obstaculo o) {
        this.obstaculos.add(o);
    }

    public void removerObstaculo(Obstaculo o) {
        this.obstaculos.remove(o);
    }

    public String toString() {
        String out = "";
        out += "Ambiente com dimensoes " + getcomprimento() + " x " + getLargura() + " x " + getAltitude();
        out += ", Temperatura = " + getTemperatura() + " C e Concentracao de O2 = " + getConcentracao_o2() + " mol/l:\n";
        
        if (robos.size() == 0)
            out += "  |-->O ambiente nao possui Robos.\n";
        else {
            out += "  |-->Robos: \n";
            for (int i = 0; i < robos.size(); i++)
                out += "    ### " + robos.get(i);         
        }

        if (obstaculos .size() == 0)
            out += "  |-->O ambiente nao possui obstaculos.\n";
        
        else {
            out += "  |-->Obstaculos: \n";
            for (int i = 0; i < obstaculos.size(); i++) 
                out += "  " + obstaculos.get(i);
        }

        return out;
    }
}