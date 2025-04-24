import java.util.ArrayList;
import java.util.List;
//Falta adicionar obstaculos e ler entradas + testar o sensor de proximidade para robos aereos
public class Main {
    public static void main(String[] args) {
        System.out.println("######### Iniciando as classes #########\n");

        Ambiente a = new Ambiente(20, 20, 20, 30, 10);
        System.out.println(a);

        SensorProximidade sp1 = new SensorProximidade(5, a);
        SensorProximidade sp2 = new SensorProximidade(5, a);
        SensorOxigenio so = new SensorOxigenio(5, a, 30, 20);
        SensorTemperatura st = new SensorTemperatura(5, a, 100, 20);
        
        RoboTerrestre rt = new RoboTerrestre(10, 10, "CR7", 100, 50, sp1);
        RoboAereo ra = new RoboAereo(13, 10, 30, 50, "R10", sp2);
        System.out.println(ra);
        System.out.println(rt);

        System.out.println("######### Adicionando novos sensores aos robos #########");
        ra.adicionarSensor(st);
        rt.adicionarSensor(so);
        System.out.println(ra);
        System.out.println(rt);

        System.out.println("######### Tentando adicionar os Robos Terrestre e Aereo ao ambiente (respectivamente) #########");
        a.adicionarRobo(rt);
        a.adicionarRobo(ra);
        System.out.println();    
        
        System.out.println("######## Movendo o Robo Aereo para dentro dos limites do Ambiente e adicionando-o #########");
        ra.descer(10);
        System.out.println(ra);
        a.adicionarRobo(ra);
        System.out.println();

        System.out.println("######## Testando os sensores do Robo Terrestre (CR7) #########");
        rt.usarSensores();

        System.out.println(a);
    }
}
