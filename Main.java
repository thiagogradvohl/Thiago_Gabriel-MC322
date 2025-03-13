import lab01.Ambiente;

class Main {
    public static void main(String[] args) {

        Robo robo = new Robo(0, 0, "CR7");
        Ambiente ambiente = new Ambiente(50, 50);

        robo.exibirPosicao();

        robo.mover(10, 10);
        
        System.out.printf("Está dentro do limite %b\n", ambiente.dentroDosLimites(20, 20));
        
        robo.exibirPosicao();
    }
}