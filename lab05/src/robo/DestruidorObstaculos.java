package robo;
import java.util.List;
import java.util.ArrayList;
import entidade.*;
import sensores.*;
import ambiente.*;
import missao.*;
import obstaculo.*;
import exceptions.*;


public class DestruidorObstaculos extends RoboTerrestre implements DestruidorAutonomo {
    //Subclasse de robos terrestres que percorre trechos de modo autonomo, usando uma bateria que descarrega pelo caminho
    private int energia;
    private int energia_minima;
    private List<Entidade> entidades_proximas;
    private List<Entidade> entidades_removidas = new ArrayList<>();
    
    
    public DestruidorObstaculos(int X, int Y, int Z, String id, int velocidadeMaxima, int velocidade, int energia, int energia_minima, Sensor sensor, EstadoRobo estado, Missao missao)
    {
        super(X, Y, Z, id, velocidadeMaxima, velocidade, sensor, estado, missao);
        this.energia = energia;
        this.energia_minima = energia_minima;
    }

    @Override
    public void atualizar_ambiente(Ambiente ambiente)
    {
        if (this.entidades_removidas.isEmpty())
            return;
        
        for(Entidade entidade : this.entidades_removidas)
            ambiente.removerEntidade(entidade);
    }

    @Override
    public void atualizar_entidades_proximas(Ambiente a) {
        SensorProximidade sp = this.identificar_sp();
        if (sp != null)
            this.entidades_proximas = sp.identificarEntidades(this, a);
        else 
            System.out.println("Nao foi possivel atualizar as entidades. Sensor de proximidade nao identificado.");
    }

    public int getEnergia(){
        return this.energia;
    }
    
    @Override
    public SensorProximidade identificar_sp()
    {
        for (Sensor s : getSensores()) {
            if (s instanceof SensorProximidade) {
                return (SensorProximidade) s;
            }
        }
    
        System.out.println("Sensor de proximidade não localizado");
        return null; 
    }
    
    @Override
    public void executarTarefa() throws Exception {
        if (this.getEstado() == EstadoRobo.LIGADO) {
            if (this.energia >= this.energia_minima) {
                boolean tem_obstaculo = false;
                for (Entidade e: this.entidades_proximas) {
                    if (e instanceof Obstaculo)
                        tem_obstaculo = true;
                }
                if (!tem_obstaculo)
                {
                    System.out.println("Não há obstáculos próximos a serem destruídos.");
                    return;
                }

                this.energia -= this.energia_minima;   //perde energia  
                for (Entidade entidade : this.entidades_proximas) {
                    if (entidade instanceof Obstaculo) {
                        this.entidades_removidas.add(entidade);
                    }
                }
            }
            else
                throw new BateriaInsuficienteException();
        }
        else
            throw new RoboDesligadoException();
        
    }
    
    @Override
    public void recarregarBateria(int energia_adicionada){
        //recarrega a bateria do robo por uma quantidade especificada
        this.energia += energia_adicionada;
        if(getEnergia() > 100)
        {
            System.out.println("Carga concluída. Bateria completamente carregada.\n");
            return;
        }
        System.out.printf("Status da bateria: %d\n(Bateria minima: %d)\n", getEnergia(), getEnergia_minima());
    }

    @Override
    public void moverPara(int X, int Y, int Z) throws Exception {
        //move o robo em uma distancia especificada em cada eixo do plano, seguindo uma pré-determinada velocidade.
        //perde 10 de energia a cada movimento
        if (this.energia < this.energia_minima) 
            throw new BateriaInsuficienteException();
        else {
            try {
                super.moverPara(X, Y, Z);
                if (energia >= 10)
                    this.energia -= 10;
                else
                    this.energia = 0;
            } catch (RoboDesligadoException rde) {
                throw new RoboDesligadoException();
            } catch (VelocidadeExcedidaException vee) {
                throw new VelocidadeExcedidaException();
            }
        }
        
    }

    public List<Entidade> getEntidades_proximas() {
        return entidades_proximas;
    }
    
    public List<Entidade> getEntidades_removidas() {
        return entidades_removidas;
    }

    public int getEnergia_minima() {
        return energia_minima;
    }

    @Override
    public String getDescricao() {
        String out = "";
        out += "DestruidorObstaculos " + getId();
        out += " (" + getEstado() + ")";
        out += " esta na posicao " + "(" + getX() + ", " + getY() + ", " + getZ() + "), ";
        out += "com energia = " + getEnergia() + " X energia minima = " + getEnergia_minima() ;
        out += ", com Velocidade = " + getVelocidade() + " x Velocidade Maxima = " + getVelocidadeMaxima() + ":\n";
        if (getEntidades_proximas() != null) {
            out += "        |-->Entidades proximas:\n";
            for (Entidade e : getEntidades_proximas())
                out += "          |-->" + e.getDescricao() + "\n";
        }
        if (getSensores() == null) 
            out += "        |-->Ele nao possui sensores.";
        else {
            out += "        |-->Sensores:\n";
            for (Sensor s : getSensores())
                out += "          |-->" + s.toString() + "\n";
        }
        return out;
    }

    public void setEnergia_minima(int energia_minima) {
        this.energia_minima = energia_minima;
    } 
}
