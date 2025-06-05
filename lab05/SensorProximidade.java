import java.util.ArrayList;
import java.util.List;

public class SensorProximidade extends Sensor{
    //Esse sensor identifica entidades dentro do raio de busca e os imprime,
    //bem como verifica colisoes do robo com os entidades do ambiente
    public SensorProximidade(double raio){
        super(raio);
    }

    protected double distancia3D(Robo robo, Entidade ent) {
        //calcula a distancia entre o robo e uma dada entidade
        double distancia_x;
        double distancia_y;
        if (ent.getTipo() == TipoEntidade.OBSTACULO) {
            distancia_x = distancia1D(robo.getX(), ((Obstaculo)ent).getX1(), ent.getX());
            distancia_y = distancia1D(robo.getY(), ((Obstaculo)ent).getY1(), ent.getY());
        }
        else {  //entidade for robo
            distancia_x = distancia1D(robo.getX(), ent.getX(), ent.getX());
            distancia_y = distancia1D(robo.getY(), ent.getY(), ent.getY());  
        }
        double distancia_z = distancia1D(robo.getZ(), 0, ent.getZ());
        return  Math.sqrt(Math.pow(distancia_x, 2) + Math.pow(distancia_y, 2) + Math.pow(distancia_z, 2));
    }

    protected double distancia1D(double ponto, double min, double max) {
        //Essa funcao calcula a distancia de um ponto para outro em uma dimensao
        //sera usada para calcular a distancia de um robo ate um obstaculo 
        if (ponto < min) 
            return min - ponto;
        if (ponto > max) 
            return ponto - max;
        return 0;
    }

    public List<Entidade> identificarEntidades(Robo robo, Ambiente ambiente){
        
        List<Entidade> entidades_vizinhas = new ArrayList<>();

        for(Entidade ent : ambiente.getEntidades())
        {   
            if (ent != robo) {
            double distancia = distancia3D(robo, ent);

            if(distancia == 0)   //robo colidiu
                System.out.printf("Robô colidiu com o %s!\nPosição da colisão: (%d, %d, %d)", ent.getTipo(), robo.getX(), robo.getY(), robo.getZ());
            
            else if(distancia <= getRaio())
                entidades_vizinhas.add(ent);
            }
        }

        return entidades_vizinhas;
    }

    public void exibirEntidades(List<Entidade> entidades) {
        for(Entidade ent : entidades)
            System.out.printf("    |-> %s", ent.getDescricao());
    }

    @Override
    public void monitorar(Robo robo, Ambiente ambiente) {
        List<Entidade> entidades_vizinhas = identificarEntidades(robo, ambiente);
        if (!entidades_vizinhas.isEmpty()) {
            System.out.printf("->Entidades encontrados pelo Sensor de Proximidade (no raio de proximidade igual a %.1f):\n", getRaio());
            exibirEntidades(entidades_vizinhas);
        }
        else   
            System.out.println("->O Sensor de Proximidade nao encontrou entidades");
    }

    @Override
    public String toString() {
        String out = "Sensor de Proximidade: ";
        out += "Raio de varredura = " + getRaio();
        return out;
    }
}
