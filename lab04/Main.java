import java.util.List;
import java.util.Scanner;

public class Main {
    public static 
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
        
        CentralComunicacao co = new CentralComunicacao();
        String mensagem1 = "isto é o que os meus sensores estão acusando:";
        String resposta1 = "Ola, eu sou o " + der.getId() + ".";
        String mensagem2 = "Ola, " + df.getId() + ". Qual a sua posicao?";
        String resposta2 = "Ola, " + dos.getId() + ". Estou na posicao: (" + df.getX() + ", " + df.getY() + ", " + df.getAltitude() + ")."; 
        //enviando mensagem 1
        try { 
            bb_8.enviarMensagem(der, mensagem1);
            co.registrarMensagem(bb_8.getId(), mensagem1);
        } catch (RoboDesligadoException e) {
            e.printStackTrace();
        }
        //recebendo mensagem 1
        try { 
            der.receberMensagem(mensagem1);
        } catch (RoboDesligadoException e) {
            e.printStackTrace();
        }


        //  MENU INTERATIVO 

        Scanner scanner = new Scanner(System.in);

        //1)Listar Robôs

        while (true)
        {
            System.out.println("####### Menu Interativo #######");
            System.out.println(
            "Escolha o que deseja fazer:\n"
            + "(1) Listar todos os robôs\n"
            + "(2) Escolher robô para interagir\n"
            + "(3) Visualizar ambiente\n"
            + "(4) Ver status do ambiente\n"
            + "(5)Listar mensagens trocadas"
            );

            int resposta_1 = scanner.nextInt();

            if (resposta_1 == 1) //listando os robôs e seus respectivos estados
            {
                System.out.println("Robôs disponíveis:");
                for(int i = 0; i < robos.length; i++)
                {
                    System.out.printf("%d) %s (Status: %s)\n",i+1,robos[i].getId(),robos[i].getEstado());
                }
            }

            else if (resposta_1 == 2)
            {
                System.out.println("Escolha um robô:");
                for(int i = 0; i < robos.length; i++)
                {
                    System.out.printf("(%d) %s\n",i+1,robos[i].getId());
                }
                int resposta_2 = scanner.nextInt();//qual robo

                System.out.println(
                "Escolha o que deseja fazer com o robô selecionado:\n"
                + "(1) Visualizar status\n"
                + "(2) Executar funcionalidades\n"
                + "(3)Mudar estado do sistema\n"
                + "(4) Mover robô"
                );


                int resposta_3 = scanner.nextInt();//atividade do robo

                if (resposta_3 == 1)//visualizando status
                {
                    robos[resposta_2-1].toString();
                }
                
                else if (resposta_3 == 2)
                {
                    System.out.println(
                    "Escolha qual funcionalidade deseja utilizar:\n"
                    + "(1) Comunicar-se\n"
                    + "(2) Usar sensores\n"
                    + "(3) Executar tarefas próprias\n"
                    );
                    

                    int resposta_4 = scanner.nextInt(); // funcionalidade
                    if (resposta_4 == 1)//comunicação
                    {
                        try 
                        { 
                            System.out.println("Escolha a mensagem que deseja enviar:");
                            System.out.println("(1)Caro <destinatário>, eu estou na posição <(x,y,x)> ");
                            System.out.println("(2) Ola, eu sou o <nome_do_robo>.");
                            int resposta_6 = scanner.nextInt();



                            System.out.println("Escolha o robô que receberá a mensagem:]");
                            for(int j=0; j < robos.length;j++)
                            {
                                if(j != resposta_2)
                                {
                                    System.out.printf("(%d) %s",j+1,robos[resposta_2-1]);
                                }
                            }
                            int resposta_5 = scanner.nextInt();
                            if (resposta_6 == 1)
                            {
                                String msg_1 = String.format("Caro %s,eu estou na posição (%d,%d,%d)",robos[resposta_5-1].getId(),robos[resposta_2-1].getX(),robos[resposta_2-1].getY(),robos[resposta_2-1].getZ());
                                try
                                { 
                                    robos[resposta_2-1].enviarMensagem(robos[resposta_5-1], msg_1);

                                    co.registrarMensagem(robos[resposta_2-1].getId(), msg_1);
                                }
                                catch (RoboDesligadoException e) {
                                    e.printStackTrace();
                                }
                            }
                            else if (resposta_6 == 2)
                            {
                                String msg_2 = String.format("Ola, %s,eu sou o %s",robos[resposta_5-1].getId(),robos[resposta_2-1].getId());
                                try
                                { 
                                    robos[resposta_2-1].enviarMensagem(robos[resposta_5-1], msg_2);

                                    co.registrarMensagem(robos[resposta_2-1].getId(), msg_2);
                                }
                                catch (RoboDesligadoException e) {
                                    e.printStackTrace();
                                }
                            }
                            
                            bb_8.enviarMensagem(der, mensagem1);
                            co.registrarMensagem(bb_8.getId(), mensagem1);
                        } catch (RoboDesligadoException e) {
                            e.printStackTrace();
                        }
                    }

                    else if (resposta_4 == 2)//sensores
                    {
                        try
                        {
                            robos[resposta_2-1].acionarSensores(a);
                        } 
                        
                        catch (RoboDesligadoException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        try
                        {
                            robos[resposta_2-1].executarTarefa();
                        } 
                        
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                else if(resposta_3 == 3)//ligar/desligar
                {
                    if (robos[resposta_2-1].getEstado() == EstadoRobo.DESLIGADO)
                    {
                        robos[resposta_2-1].ligar();
                        System.out.println("O robô está ligado...");
                    }
                    else if (robos[resposta_2-1].getEstado() == EstadoRobo.DESLIGADO)
                    {
                        robos[resposta_2-1].desligar();
                        System.out.println("O robô está desligado...");
                    }
                }
                else//mover
                {
                    int pos_x_antiga = robos[resposta_2-1].getX();
                    int pos_y_antiga = robos[resposta_2-1].getY();
                    int pos_z_antiga = robos[resposta_2-1].getZ();
                    

                    System.out.printf("Escolha por qual distância deseja movimentar o robô %s :\nNo eixo X: ",robos[resposta_2-1].getId());
                    int delta_x = scanner.nextInt();

                    System.out.print("No eixo Y: ");
                    int delta_y = scanner.nextInt();

                    System.out.print("No eixo Z: ");
                    int delta_Z= scanner.nextInt();
                    
                    try 
                    {
                        a.moverEntidade(robos[resposta_2-1], pos_x_antiga+delta_x, pos_y_antiga+delta_y, pos_z_antiga+delta_Z);
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                
                    System.out.printf("O robô terrestre se moveu da posição (%d,%d,%d) para a posição (%d,%d,%d)\n",pos_x_antiga,pos_y_antiga,pos_z_antiga,robos[resposta_2-1].getX(),robos[resposta_2-1].getY(),robos[resposta_2-1].getZ());
                }
                }
            else if (resposta_1 == 3)//visualizar ambiente
            {
                a.visualizarAmbiente();
            }
            else if (resposta_1 == 4)
            {
                a.toString();
            }
            else
            {
                co.exibirMensagens();
            }


            }
            

        }
}

