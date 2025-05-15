import java.util.List;
import java.util.ArrayList;

public abstract class Robo implements Entidade {
    //rever exceprtions para usar sensores e mover
    private String id;
    private TipoEntidade tipo;
    private EstadoRobo estado;
    private int X;
    private int Y;
    private int Z;
    private List<Sensor> sensores;

    public Robo(int X, int Y, int Z, String id, Sensor sensor, EstadoRobo estado) {
        //Método construtor: Define o id, a posicao x e a posicao y do robô.
        this.id = id;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.sensores = new ArrayList<Sensor>();
        this.sensores.add(sensor);
        this.tipo = TipoEntidade.ROBO;
        this.estado = estado;
    }

    public String getId() {
        //retorna o id do robô.
        return id;
    }

    public int getX() {
        //retorna a posição x do robô.
        return X;
    }

    public TipoEntidade getTipo() {
        return tipo;
    }

    public EstadoRobo getEstado() {
        return estado;
    }

    public int getZ() {
        return Z;
    }

    public int getY() {
        //retorna a posição y do robô.
        return Y;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setX(int X){
        this.X = X;
    }
    public void setY(int Y){
        this.Y = Y;
    }
    
    public void setTipo(TipoEntidade tipo) {
        this.tipo = tipo;
    }

    public void setEstado(EstadoRobo estado) {
        this.estado = estado;
    }

    public void setZ(int z) {
        Z = z;
    }

    public void moverPara(int X, int Y, int Z) {
        if (X >= 0 && Y >= 0 && Z >= 0 && this.estado == EstadoRobo.LIGADO) {
            this.X = X;
            this.Y = Y;
            this.Z = Z;
        }
        //exception robo desligado
    }
    
    public void exibirPosicao() {
        //imprime as posições x e y do robô.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", this.X, this.Y);
    }
    
    public void adicionarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    public void usarSensores(Ambiente ambiente) {
        for (Sensor s : sensores) {
            s.monitorar(this, ambiente);
        }
        //exception robo desligado
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void removerSensor(Sensor sensor) {
        this.sensores.remove(sensor);
    }

    public void desligar() {
        if (this.estado == EstadoRobo.LIGADO)
            this.estado = EstadoRobo.DESLIGADO;
    }

    public void ligar() {
        if (this.estado == EstadoRobo.DESLIGADO)
            this.estado = EstadoRobo.LIGADO;
    }

    public abstract void executarTarefa();

    public String toString() {
        String out = "";
        out += "Robo " + getId() + " esta na posicao " + "(" + getX() + ", " + getY() + "):\n";
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
