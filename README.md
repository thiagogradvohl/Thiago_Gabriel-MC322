🧪 Laboratórios MC322

Equipe:

    Thiago Gradvohl de Oliveira (RA: 281378)

    Gabriel Lopes de Barros (RA: 281198)

Este repositório contém os códigos referentes aos laboratórios da disciplina MC322 - Programação Orientada a Objetos.
📁 Lab04
Principais mudanças:

    ✅ Adição de interfaces (permite uma espécie de herança múltipla em Java):

        Entidade: implementada por Robo e Obstaculo;

        Comunicavel: implementada por Robo;

        Sensoreavel: implementada por Robo;

        Fotografico: implementada por DroneFotografico;

        Atacante: implementada por BB_8;

        DestruidorAutonomo: implementada por DestruidorObstaculos.

    ✅ Implementação de Exceptions personalizadas.

    ✅ Robo, RoboTerrestre e RoboAereo são classes abstratas com o método executarTarefa().

    ✅ Visualização do ambiente com mapa.

    ✅ Comunicação entre robôs via CentralComunicacao e Comunicavel.

📝 Explicando o Diagrama UML

(Imagem PNG na pasta lab04 do repositório)
1) Herança:

    RoboTerrestre e RoboAereo herdam de Robo.

    BB_8 e DestruidorObstaculos herdam de RoboTerrestre.

    DroneEntregador e DroneFotografico herdam de RoboAereo.

    SensorTemperatura, SensorProximidade e SensorOxigenio herdam de Sensor.

2) Dependência:

    Sensor depende de Robo e de Ambiente.

    CentralComunicacao depende de Robo.

3) Composição:

    Ambiente contém Entidade (1 para 1..*).

    Obstaculo contém TipoObstaculo (1 para 1).

    Obstaculo e Robo contêm TipoEntidade (1 para 1).

    Robo contém EstadoRobo (1 para 1).

4) Agregação:

    Robôs podem ter Sensor (1 para 0..*).

5) Implementação:

    Robo e Obstaculo implementam Entidade.

    Robo implementa Sensoreavel e Comunicavel.

    BB_8 implementa Atacante.

    DroneFotografico implementa Fotografico.

    DestruidorObstaculos implementa DestruidorAutonomo.

❗️ Exceptions adicionadas:

    BateriaInsuficienteException:
    Lançada quando DestruidorObstaculos tenta realizar ação (moverPara() ou executarTarefa()) sem energia suficiente.

    CameraDesligadaException:
    Lançada quando DroneFotografico tenta tirar foto (executarTarefa()) com a câmera desligada.

    ColisaoException:
    Lançada na classe Ambiente ao tentar mover ou adicionar Entidade em espaço ocupado.

    EntidadeEstaticaException:
    Lançada ao tentar mover a entidade Obstaculo na classe Ambiente.

    ForaDosLimitesException:
    Lançada ao tentar adicionar ou mover Entidade para fora dos limites na classe Ambiente.

    RoboDesligadoException:
    Lançada ao tentar mover, acionar sensores ou executarTarefa() com EstadoRobo.DESLIGADO nas classes Robo ou Ambiente.

▶️ Instruções para Compilação e Execução
1) Clonando o repositório na sua máquina:

git clone https://github.com/thiagogradvohl/Thiago_Gabriel-MC322.git

2) Acesse a pasta lab04 do repositório:

cd Thiago_Gabriel-MC322/lab04

3) Compile e execute o arquivo Main.java
✅ Usando uma IDE (IntelliJ IDEA, Eclipse, NetBeans, VS Code):

    Importe a pasta lab04 como um novo projeto ou módulo.

    Localize o arquivo Main.java.

    Clique com o botão direito e selecione "Run" ou "Executar".

✅ Pelo Terminal:

    Verifique se o Java Development Kit (JDK) está instalado:

java -version
javac -version

    Compile o arquivo Main.java:

javac Main.java

    Execute o programa:

java Main
