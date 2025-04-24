//Falta adicionar obstaculos e ler entradas + testar o sensor de proximidade para robos aereos
public class Main {
    public static void main(String[] args) {
        System.out.println("######### Iniciando as classes #########");

        Ambiente a = new Ambiente(30, 30, 20, 30, 10);
        System.out.println(a);

        SensorProximidade sp1 = new SensorProximidade(5, a);
        SensorProximidade sp2 = new SensorProximidade(10, a);
        SensorOxigenio so = new SensorOxigenio(5, a, 30, 20);
        SensorTemperatura st = new SensorTemperatura(5, a, 100, 20);
        
        Obstaculo o1 = new Obstaculo(2, 2, TipoObstaculo.PAREDE);
        Obstaculo o2 = new Obstaculo(7, 8, TipoObstaculo.CACHOEIRA);
        Obstaculo o3 = new Obstaculo(20, 20, TipoObstaculo.RIO);
        Obstaculo o4 = new Obstaculo(15, 15, TipoObstaculo.VULCAO);

        RoboTerrestre rt = new RoboTerrestre(10, 10, "CR7", 100, 50, sp1);
        RoboAereo ra = new RoboAereo(13, 10, 30, 50, "R10", sp2);
        System.out.println(ra);
        System.out.println(rt);

        System.out.println("######### Tentando adicionar Obstaculos ao Ambiente #########");
        a.adicionarObstaculo(o1);
        a.adicionarObstaculo(o2);
        a.adicionarObstaculo(o3);
        a.adicionarObstaculo(o4);
        System.out.println();

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
        ra.descer(20);
        System.out.println(ra);
        a.adicionarRobo(ra);
        System.out.println();

        System.out.println("######## Testando os sensores (de Proximidade e de Oxigenio) do Robo Terrestre #########");
        rt.usarSensores();
        System.out.println();

        System.out.println("######## Testando os sensores (de Proximidade e de Temperatura) do Robo Aereo #########");
        ra.usarSensores();
        System.out.println();

        System.out.println(a);
    }
}
