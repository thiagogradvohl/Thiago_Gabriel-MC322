import java.util.List;
import java.util.ArrayList;
public class DestruidorObstaculos extends RoboTerrestre implements Destruidor {
    //Subclasse de robos terrestres que percorre trechos de modo autonomo, usando uma bateria que descarrega pelo caminho
    private int energia;
    private List<Entidade> entidades_proximas;
    private List<Entidade> entidades_removidas = new ArrayList<>();
    
    
    public DestruidorObstaculos(int X, int Y, int Z, String id, int velocidadeMaxima, int velocidade, int energia, Sensor sensor, EstadoRobo estado)

    {
        super(X, Y, Z, id, velocidadeMaxima, velocidade, sensor, estado);
        this.energia = energia;
    }
    public void atualizar_entidades(Ambiente ambiente)
    {
        //put try/except later on
        if (this.entidades_removidas.isEmpty())
        {
            return;
        }
        
        for(Entidade entidade : this.entidades_removidas)
        {
            ambiente.removerEntidade(entidade);
        }
        SensorProximidade sp = this.identificar_sp();
        entidades_removidas = sp.identificarEntidades(this, ambiente);

    }
    public int getEnergia(){
        return this.energia;
    }
    
    public SensorProximidade identificar_sp()
    {
        for (Sensor s : getSensores()) {
            if (s instanceof SensorProximidade) {
                System.out.println("Sensor de proximidade localizado...");
                return (SensorProximidade) s;
            }
        }
    
        System.out.println("Sensor de proximidade não localizado");
        return null; 
    }
    
    public void setEnergia(int energia){
        this.energia = energia;
    }
    @Override
    public void executarTarefa() {
    
        if (this.entidades_proximas.isEmpty())
        {
            System.out.println("Não há obstáculos próximos a serem destruídos.");
            return;
        }

    
        for (Entidade entidade : this.entidades_proximas) {
            if (entidade instanceof Obstaculo) {
                entidades_removidas.add(entidade);
            }
        }
        
    }
    
    public void recarregarBateria(int energia_adicionada){
        //recarrega a bateria do robo por uma quantidade especificada
        setEnergia(getEnergia()+energia_adicionada);
        if(getEnergia() > 100)
        {
            System.out.println("Carga concluída. Bateria completamente carregada.\n");
            return;
        }
        System.out.printf("Status da bateria: %d\n", getEnergia());
    }

    @Override
    public void moverPara(int X, int Y, int Z) {
        //move o robo em uma distancia especificada em cada eixo do plano, seguindo uma pré-determinada velocidade.
        //computa o consumo de bateria do trajeto e verifica se ela será ou nao suficiente para o trajeto
        int consumo = Math.abs(X - getX()) + Math.abs(Y - getY()) + Math.abs(Z - getZ()); 
        if (energia < consumo) {
            System.out.println("Bateria insuficiente para o movimento.\nFavor carregar.");
            return;
        }
        else if (getX() + X >= 0 && getY() >= 0) {
            setX(X);
            setY(Y);
            setZ(Z);
            this.energia -= consumo;
        }
        else
            System.out.println("O robo nao se moveu, pois iria para coordenadas negativas.");

        System.out.printf("Movimento realizado.\nBateria restante: %d\n", getEnergia());
    }

    public List<Entidade> getEntidades_proximas() {
        return entidades_proximas;
    }
    
    public List<Entidade> getEntidades_removidas() {
        return entidades_removidas;
    }

    @Override
    public String getDescricao() {
        String out = "";
        out += "Robo DestruidorObstaculos " + getId();
        out += " (" + getEstado() + ")";
        out += " esta na posicao " + "(" + getX() + ", " + getY() + ", " + getZ() + "), ";
        out += "com energia = " + getEnergia();
        out += ", com Velocidade = " + getVelocidade() + " x Velocidade Maxima = " + getVelocidadeMaxima() + ":\n";
        if (getEntidades_proximas() != null)
            out += "        |-->Entidades proximas:\n";
            for (Entidade e : getEntidades_proximas())
                out += "          |-->" + e.getDescricao() + "\n";
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
