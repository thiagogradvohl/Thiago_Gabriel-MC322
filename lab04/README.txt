Equipe:
    Thiago Gradvohl de Oiveira(RA: 281378) & Gabriel Lopes de Barros(RA: 281198)


1)Explicando a main:
    1.1) Menu nao-interativo:
        Primeiro, define-se e instancia-se os objetos de todas as classes do lab03, imprimindo os status do que esta sendo feito.

        Após isso, testa-se se os métodos básicos inerentes à classe robo terrestre, robo aereo e ambiente.
        Adicionando sensores aos robos; e obstaculos e robos ao ambiente. 

        Em seguida, testa-se se todos os sensores dos robos.

    1.2) Menu interativo
        O usuario pode mover os robos, verificar os status dos robos e do ambiente, e utilizar sensores dos robos.
        Ou seja, ele nao consegue criar e instanciar novos objetos.
    
2)Explicando o Diagrama UML (PNG na pasta lab03 do repositorio):
    2.1) Heranca: 
        -RoboTerrestre e RoboAereo herdam de Robo
        -SensorTemperatura, SensorProximidade e SensorOxigenio herdam de Sensor
    2.2) Dependencia:
        -Sensor depende de Robo e de Ambiente
    2.3) Composicao:
        -Ambiente contem Robo (1 para 1..*) e Obstaculo (1 para 1..*)
        -Obstaculo contem TipoObstaculo (1 para 1)
    2.4) Agregacao:
        -Robos podem ter Sensor (1 para 0..*)

3)Versao Java: openjdk 17.0.4

4)IDE: VsCode
