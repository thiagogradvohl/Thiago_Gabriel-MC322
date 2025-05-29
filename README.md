#Laboratorios MC322
Equipe: Thiago Gradvohl de Oiveira(RA: 281378) & Gabriel Lopes de Barros(RA: 281198)
Este repositório conterá os códigos referentes aos laboratórios da disciplina MC322 (Programação orientada a objetos).

-lab04:
Prinicipais mudancas:
    1) Adicionando interfaces (peremite uma especie de heranca multipla em Java):
        -Entidade: implementada por Robo e Obstaculo;
        -Comunicavel: implementada por Robo;
        -Sensoreavel: implementada por Robo;
        -Fotografico: implementada por DroneFotografico;
        -Atcante: implementada por BB_8;
        -DestruidorAutonomo: implementada por DestruidorObstaculos;
    2) Implementando Exceptions personalizadas;
    3) Robo, RoboTerrestre e RoboAereo sao classes abstratas (metodo executarTarefa())
    4) Visualizacao do Ambiente com mapa
    5) Comunicacao entre Robos -> CentralComunicacao + Comunicavel

Explicando o Diagrama UML (PNG na pasta lab04 do repositorio):
    1) Heranca: 
        -RoboTerrestre e RoboAereo herdam de Robo
        -BB_8 e DestruidorObstaculos herdam de RoboTerrestre 
        -DroneEntregador e DroneFotografico herdam de RoboAereo
        -SensorTemperatura, SensorProximidade e SensorOxigenio herdam de Sensor
    2) Dependencia:
        -Sensor depende de Robo e de Ambiente
        -CentralComunicacao depende de Robo
    3) Composicao:
        -Ambiente contem Entidade (1 para 1..*)
        -Obstaculo contem TipoObstaculo (1 para 1)
        -Obstaculo e Robo contem TipoEntidade (1 para 1)
        -Robo contem EstadoRobo (1 para 1)
    4) Agregacao:
        -Robos podem ter Sensor (1 para 0..*)
    5) Implementacao:
        -Robo e Obstaculo implementam Entidade
        -Robo implementa Sensoreavel e Comunicavel
        -BB_8 implementa Atacante
        -DroneFotografico implementa Fotografico
        -DestruidorObstaculso implementa DestruidorAutonomo
                      
Exceptions adicionadas:
    1) BateriaInsuficienteException: lançada quando DestruidorObstaculo tenta realizar acao (moverPara() e executarTarefa()) sem ter enegia maior que a minima;
    2) CameraDesligadaException: lançada quando DroneFotografico tenta tirar foto (executarTarefa()) sem estar com a camera ligada;
    3) ColisaoException: lançada na classe Ambiente quando tentamos mover ou adicionar Entidade em espaco ocupado;
    4) EntidadeEstaticaException: lançada quando se tenta mover a Entidade Obstaculo na classe Ambiente;
    5) ForaDosLimitesException: lançada quando tenta-se adicionar ou mover Entidade para fora dos limites na classe Ambiente;
    6) RoboDesligadoException: lançada quando tenta-se mover, acionarSensores ou executarTarefa com EstadoRobo DESLIGADO na classe Robo ou Ambiente;

Instrucoes para Compilacao e Execucao:
    1) Clonando o repositorio na sua máquina:
        git clone https://github.com/thiagogradvohl/Thiago_Gabriel-MC322.git

    2) Acesse a pasta lab04 do repositório
        cd Thiago_Gabriel-MC322/lab04

    3) Compile e execute o arquivo Main.java
        3.1) Usando uma IDE (como IntelliJ IDEA, Eclipse, NetBeans, VsCode)
            Importe a pasta lab04 como um novo projeto ou módulo;
            Localize o arquivo Main.java;
            Clique com o botão direito e selecione "Run" ou "Executar".
        3.2) Pelo Terminal:
            Certifique-se de ter o Java Development Kit (JDK) instalado.
            Verifique com:
                java -version
                javac -version
            
            Compile o arquivo Main.java:
                javac Main.java
            
            Execute o programa:
                java Main
