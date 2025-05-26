import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######### Iniciando as classes #########");

        Ambiente a = new Ambiente(50, 50, 50, 30, 10);
        System.out.println(a);

        //Instanciando os sensores:
        SensorProximidade sp1 = new SensorProximidade(5);
        SensorProximidade sp2 = new SensorProximidade(20);
        SensorOxigenio so1 = new SensorOxigenio(5, 30, 20);
        SensorOxigenio so2 = new SensorOxigenio(10, 30, 20);
        SensorTemperatura st1 = new SensorTemperatura(5, 100, 20);
        SensorTemperatura st2 = new SensorTemperatura(10, 10, 0);
        
        //Instanciando os obstaculos:
        Obstaculo o1 = new Obstaculo(2, 2, TipoObstaculo.PAREDE);
        Obstaculo o2 = new Obstaculo(7, 8, TipoObstaculo.CACHOEIRA);
        Obstaculo o3 = new Obstaculo(20, 20, TipoObstaculo.RIO);
        Obstaculo o4 = new Obstaculo(15, 15, TipoObstaculo.VULCAO);

        //Instanciando os robôs:
        BB_8 bb_8 = new BB_8(3, 20, true, 13, 13, 0, "BB8", 100, 30, sp1, EstadoRobo.LIGADO);
        DestruidorObstaculos dos = new DestruidorObstaculos(30, 30, 30, "DO01", 100, 30, 30, sp2, EstadoRobo.DESLIGADO);
        DroneEntregador der = new DroneEntregador(40, 40, 40, 50, "DE01", 0, 0, 0, so2, EstadoRobo.LIGADO, "Bolsa");
        DroneFotografico df = new DroneFotografico(43, 43, 43, 48, "DF01", so1, EstadoRobo.LIGADO);
        System.out.println(bb_8.getDescricao());
        System.out.println(dos.getDescricao());

        System.out.println("######### Tentando adicionar Obstaculos ao Ambiente #########");
        a.adicionarEntidade(o1);
        a.adicionarEntidade(o2);
        a.adicionarEntidade(o3);
        a.adicionarEntidade(o4);
        System.out.println();

        System.out.println("######### Adicionando novos sensores aos robos #########");
        bb_8.adicionarSensor(st1);
        ra.adicionarSensor(so1);
        rt.adicionarSensor(so2);
        rt.adicionarSensor(st2);
        System.out.println(ra);
        System.out.println(rt);

        System.out.println("######### Tentando adicionar as Entidades ao Ambiente #########");
        a.adicionarEntidade(bb_8);
        a.adicionarEntidade(ra);
        System.out.println();    
        
        System.out.println("######## Movendo o Robo Aereo para dentro dos limites do Ambiente e adicionando-o #########");
        ra.descer(20);
        System.out.println(ra);
        a.adicionarRobo(ra);
        System.out.println();

        System.out.println("######## Testando os sensores (de Proximidade e de Oxigenio) do Robo Terrestre #########");
        rt.usarSensores(a);
        System.out.println();

        System.out.println("######## Testando os sensores (de Proximidade e de Temperatura) do Robo Aereo #########");
        ra.usarSensores(a);
        System.out.println();

        System.out.println(a);

    
        //MENU INTERATIVO:

        Scanner scanner = new Scanner(System.in);        
        //Robôs e Ambiente
        while (true) {
            System.out.println("########### Menu Interativo ###########");
            System.out.println("Escolha o que deseja fazer:\n(1) Visualizar status dos robôs\n(2) Visualizar status do ambiente\n(3) Mover robôs\n(4) Utilizar sensores\n(5) Encerrar programa");
            int resposta_1 = scanner.nextInt();
            if(resposta_1 == 1)
            //usuário deseja visualizar os robôs.
            {
                System.out.println("Escolha qual robô deseja ver o status:\n(1) Robô terrestre\n(2) Robô aéreo\n(3) Ambos robôs");
                int resposta_2 = scanner.nextInt();
                if(resposta_2 == 1)
                {
                    System.err.println("Status do robô terrestre");
                    System.out.println(rt);
                }
                else if(resposta_2 == 2)
                {
                    System.err.println("Status do robô aéreo");
                    System.out.println(ra);
                }
                else
                {
                    System.out.println("Status do robô terrestre:");
                    System.out.println(rt);

                    System.out.println("Status do robô aéreo:");
                    System.out.println(ra);
                }
            }

            else if(resposta_1 == 2)
            {
                System.out.println("Status do ambiente:");
                System.out.println(a);
            }
            //movimentação dos robôs
            else if(resposta_1 == 3)
            {
                System.out.println("Escolha o robô que deseja mover:\n(1) Robô terrestre\n(2) Robô aéreo");
                int resposta_2 = scanner.nextInt();

                int delta_x;
                int delta_y;
                

                if(resposta_2 == 1)
                {
                    int pos_x_antiga = rt.getPosicaox();
                    int pos_y_antiga = rt.getPosicaoy();

                    System.out.printf("Escolha por qual distância deseja movimentar o robô terrestre:\nNo eixo X: ");
                    delta_x = scanner.nextInt();
                    System.out.print("No eixo Y: ");
                    delta_y = scanner.nextInt();
                    rt.mover(delta_x, delta_y);
                    System.out.printf("O robô terrestre se moveu da posição (%d,%d) para a posição (%d,%d)\n",pos_x_antiga,pos_y_antiga,rt.getPosicaox(),rt.getPosicaoy());
                }
                else if(resposta_2 == 2)
                {
                    int pos_x_antiga = ra.getPosicaox();
                    int pos_y_antiga = ra.getPosicaoy();
                    int pos_altitude_antiga = ra.getAltitude();
                    int delta_Z;

                    System.out.printf("Escolha por qual distância deseja movimentar o robô aéreo:\nNo eixo X: ");
                    delta_x = scanner.nextInt();

                    System.out.print("No eixo Y: ");
                    delta_y = scanner.nextInt();

                    System.out.print("No eixo Z: ");
                    delta_Z= scanner.nextInt();
                    if(delta_Z > 0)
                    {
                        ra.subir(delta_Z);
                    }
                    else
                    {
                        ra.descer(-delta_Z);
                    }

                    ra.mover(delta_x,delta_y);
                
                    System.out.printf("O robô terrestre se moveu da posição (%d,%d,%d) para a posição (%d,%d,%d)\n",pos_x_antiga,pos_y_antiga,pos_altitude_antiga,ra.getPosicaox(),ra.getPosicaoy(),ra.getAltitude());
                }
            }
            
            //uso dos sensores
            else if(resposta_1 == 4)
            {

                System.out.println("Escolha o robô que deseja ver o sensor:\n(1) Robô terrestre\n(2) Robô aéreo");
                int resposta_2 = scanner.nextInt();

                if(resposta_2 == 1)
                {
                    System.out.println("Relatório geral dos sensores para o robô terrestre: ");
                    rt.usarSensores(a);
                }
                else if(resposta_2 == 2)
                {
                    System.out.println("Relatório geral dos sensores para o robô aéreo");
                    ra.usarSensores(a);
                }
            }
            
            else if (resposta_1 == 5) {
                System.out.println("Programa encerrado.");
                break;
            }
        
        }

        scanner.close();
    }
}
