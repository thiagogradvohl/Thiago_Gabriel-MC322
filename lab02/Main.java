import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //testando robo terrestre:
        Obstaculo obstaculo_terrestre = new Obstaculo(31, 31, "Teste Proximidade 1");
        RoboTerrestre robo_terrestre = new RoboTerrestre(30, 30, "Terrestre", 80, 100);
        
        List<Obstaculo> lista_obstaculos = new ArrayList<>();
        lista_obstaculos.add(obstaculo_terrestre);

        robo_terrestre.exibirObstaculos(robo_terrestre.identificarObstaculos(lista_obstaculos));
        
        robo_terrestre.mover(50, 50);
        robo_terrestre.exibirPosicao();
        robo_terrestre.setVelocidade(50);
        robo_terrestre.mover(50, 50);
        robo_terrestre.exibirPosicao();
        
        //testando robo aereo:
        ObstaculoAereo obstaculo_aereo = new ObstaculoAereo(61, 61, "Teste Proximidade 2", 61);
        RoboAereo robo_aereo = new RoboAereo(60, 60, 60, 80, "Voador");
        
        List<ObstaculoAereo> lista_obstaculos_aereos = new ArrayList<>();
        lista_obstaculos_aereos.add(obstaculo_aereo);

        robo_aereo.exibirObstaculos(robo_aereo.identificarObstaculosAereos(lista_obstaculos_aereos));
        robo_aereo.subir(10);
        robo_aereo.descer(80);
        robo_aereo.exibirPosicao();

        //testando bb-8:
        BB_8 robo_bb8 = new BB_8(20, 20, 30, 30, "BB-8", 300, false);
        robo_bb8.mover(20, 20);
        robo_bb8.atacar();
        robo_bb8.ligar_modo_ataque();
        robo_bb8.atacar();
        robo_bb8.desligar_modo_ataque();
        robo_bb8.exibirPosicao();


        //testando drone fotografo:
        DroneFotografico drone_fotografo = new DroneFotografico(20, 20, 20, 60, "Legal", false);
        drone_fotografo.desligar_camera();
        drone_fotografo.tirar_foto();
        drone_fotografo.tirar_foto();
        drone_fotografo.ligar_camera();
        drone_fotografo.desligar_camera();
        drone_fotografo.exibirPosicao();

        //testando rover autonomo:
        RoverAutonomo rover_autonomo = new RoverAutonomo(10, 10, "Rover", 100, 50, 1000);
        rover_autonomo.mover(500, 500);
        rover_autonomo.mover(10, 10);
        rover_autonomo.Recarregar(20);
        rover_autonomo.mover(10, 11);
        rover_autonomo.mover(10,10);
        
        //testando drone entregador:
        DroneEntregador drone_entrega = new DroneEntregador(10, 10, 10, 20, "Airfood", 40, 40, 40, "Morumbi", "Itaquera", 100, 100, 100);
        drone_entrega.CalculaDistanciaTotal();
        drone_entrega.mover(100, 80);
        drone_entrega.subir(100);
        drone_entrega.CalculaDistanciaRestante();
    
        //testando ambientes:
        Ambiente amb = new Ambiente(50, 50);
        robo_terrestre.exibirPosicao();
        amb.dentroDosLimites(robo_terrestre);
        robo_bb8.exibirPosicao();
        amb.dentroDosLimites(robo_bb8);

        AmbienteAereo amb_aereo = new AmbienteAereo(80, 80, 80);
        robo_aereo.exibirPosicao();
        amb_aereo.dentroDosLimites(robo_aereo);
        drone_entrega.exibirPosicao();
        amb_aereo.dentroDosLimites(drone_entrega);
    }
}