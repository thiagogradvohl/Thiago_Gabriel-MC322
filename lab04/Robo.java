import java.util.ArrayList;
import java.util.List;

public abstract class Robo implements Entidade, Sensoreavel, Comunicavel {
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
        this.sensores = new ArrayList<>();
        this.sensores.add(sensor);
        this.tipo = TipoEntidade.ROBO;
        this.estado = estado;
    }

    @Override
    public char getRepresentacao() {
        return tipo.getRepresentacao();
    }

    public String getId() {
        //retorna o id do robô.
        return id;
    }

    @Override
    public int getX() {
        //retorna a posição x do robô.
        return X;
    }

    @Override
    public TipoEntidade getTipo() {
        return tipo;
    }

    public EstadoRobo getEstado() {
        return estado;
    }

    @Override
    public int getZ() {
        return Z;
    }

    @Override
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

    public void moverPara(int X, int Y, int Z) throws RoboDesligadoException {
        if (X >= 0 && Y >= 0 && Z >= 0 && this.estado == EstadoRobo.LIGADO) {
            this.X = X;
            this.Y = Y;
            this.Z = Z;
        }
        else
            throw new RoboDesligadoException();
    }
    
    public void exibirPosicao() {
        //imprime as posições x e y do robô.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", this.X, this.Y);
    }
    
    public void adicionarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    @Override
    public void acionarSensores(Ambiente ambiente) throws RoboDesligadoException {
        if (this.estado == EstadoRobo.DESLIGADO)
            throw new RoboDesligadoException();
        for (Sensor s : sensores) {
            s.monitorar(this, ambiente);
        }
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

    @Override
    public String getDescricao() {
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

    @Override
    public String enviarMensagem(Comunicavel destinatario, String mensagem) throws RoboDesligadoException {
        if (this.estado == EstadoRobo.LIGADO)
            return mensagem;
        else 
            throw new RoboDesligadoException();
    }

    @Override
    public void receberMensagem(String mensagem) throws RoboDesligadoException {
        if (this.estado == EstadoRobo.LIGADO)
            System.out.println("Mensagem recebida.");
        else
            throw new RoboDesligadoException();
}
