import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######### Iniciando as classes #########");

        Ambiente a = new Ambiente(20, 20, 20, 30, 10);

        //Instanciando os sensores:
        SensorProximidade sp1 = new SensorProximidade(5);
        SensorProximidade sp2 = new SensorProximidade(10);
        SensorOxigenio so1 = new SensorOxigenio(5, 30, 20);
        SensorOxigenio so2 = new SensorOxigenio(10, 30, 20);
        SensorTemperatura st1 = new SensorTemperatura(5, 100, 20);
        SensorTemperatura st2 = new SensorTemperatura(10, 10, 0);
        
        //Instanciando os obstaculos:
        Obstaculo o1 = new Obstaculo(1, 1, TipoObstaculo.PAREDE);
        Obstaculo o2 = new Obstaculo(5, 15, TipoObstaculo.CACHOEIRA);
        Obstaculo o3 = new Obstaculo(5, 5, TipoObstaculo.RIO);
        Obstaculo o4 = new Obstaculo(14, 14, TipoObstaculo.VULCAO);
        Obstaculo o5 = new Obstaculo(8, 13, TipoObstaculo.ARVORE);
        Obstaculo[] obstaculos = {o1, o2, o3, o4, o5};

        //Instanciando os robôs:
        BB_8 bb_8 = new BB_8(3, 20, true, 15, 2, 0, "BB8-01", 100, 30, sp1, EstadoRobo.LIGADO);
        DestruidorObstaculos dos = new DestruidorObstaculos(1, 19, 0, "DO01", 100, 30, 10, 20, sp2, EstadoRobo.DESLIGADO);
        DroneEntregador der = new DroneEntregador(19, 19, 18, 50, "DE01", 0, 0, 0, so2, EstadoRobo.LIGADO, "Bolsa");
        //drone fotografico fora do ambiente inicialmente
        DroneFotografico df = new DroneFotografico(60, 60, 60, 60, "DF01", so1, EstadoRobo.LIGADO);
        Robo[] robos = {bb_8, dos, der, df};

        System.out.println("######### Adicionando Obstaculos ao Ambiente #########");
        for (Obstaculo obs : obstaculos) {
            try {
                a.adicionarEntidade(obs);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }   
        System.out.println();

        System.out.println("######### Tentando mover Obstaculo no Ambiente #########"); //objeto estatico exception
        try {
            a.moverEntidade(o1, 10, 10, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("######### Adicionando novos sensores aos robos #########");
        bb_8.adicionarSensor(st1);
        der.adicionarSensor(st2);
        System.out.println(bb_8.getDescricao());
        System.out.println(der.getDescricao());

        System.out.println("######### Tentando adicionar os Robos ao Ambiente #########");
        for (Robo robo : robos) {
            try {
                a.adicionarEntidade(robo);
            } catch (Exception e) {
                System.out.println(robo.getId() + " --> " + e.getMessage());
            }
        }   
        
        System.out.println();
        
        System.out.println("######## Movendo o DroneFotografico (DF01) para dentro dos limites (posicao ocupada) do Ambiente e tentando adiciona-lo #########");
        try {
            df.moverPara(2, 2, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        try {
            a.adicionarEntidade(df); //colisaoexception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            System.out.println();

        System.out.println("######## Movendo o DroneFotografico (DF01) para posicao livre do Ambiente e adicionando-o #########");
        try {
            df.moverPara(2, 18, 18); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { 
            a.adicionarEntidade(df);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("######## Tentando mover o DestruidorObstaculos (DO01) (desligado) #########");
        try {
            a.moverEntidade(dos,15, 15, 18); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("######## Ligando e tentando mover o DestruidorObstaculos (DO01) (bateria insuficiente) #########");
        dos.ligar();
        try {
            a.moverEntidade(dos, 15, 15, 18);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("######## Recarregando e movendo o DestruidorObstaculos (DO01) #########");
        dos.recarregarBateria(20);
        try {
            a.moverEntidade(dos, 15, 15, 18);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("######## Tentando mover o DroneEntregador (DE01) para posicao ocupada #########");
        try {
            a.moverEntidade(der, 2, 2, 0); //colisao exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("######## Testando os sensores #########");
        try {
            System.out.println("Sensores BB8:");
            bb_8.acionarSensores(a);
            System.out.println();
            System.out.println("Sensores DroneFotografico:");
            df.acionarSensores(a);
            System.out.println();
            System.out.println("Sensores DroneEntregador:");
            der.acionarSensores(a);
            System.out.println();
            System.out.println("Sensores DestruidorObstaculos:");
            dos.acionarSensores(a);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("######## Vizualizando ambiente #########");
        a.visualizarAmbiente();
        System.out.println();
        System.out.println(a);
        System.out.println();

        System.out.println("######## Removendo Obstaculo ARVORE do Ambiente #########");
        a.removerEntidade(o5);
        System.out.println();

        System.out.println("######## Vizualizando ambiente #########");
        a.visualizarAmbiente();
        System.out.println();

        //MENU INTERATIVO:
        /*
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
    */
    }
}
