public class Main {
    public static void main(String[] args) {

        Robo robo = new Robo(0, 0, "CR7");
        Ambiente ambiente = new Ambiente(50, 50);

        robo.exibirPosicao();

        robo.mover(10, 10);

        robo.exibirPosicao();
        
        if (ambiente.dentroDosLimites(robo.getPosicaox(), robo.getPosicaoy()))  //Se robo esta dentro dos limites
            System.out.printf("Está dentro dos limites\n");
        else
            System.out.printf("Não está dentro dos limites\n");
        
    }
}
