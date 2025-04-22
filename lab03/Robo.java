import java.util.List;
import java.util.ArrayList;

public class Robo 
{
    private String nome;
    private int posicaox;
    private int posicaoy;
    private List<Sensor> sensores = new ArrayList<>();
    

    public Robo(int posicaox, int posicaoy, String nome) {
        //Método construtor: Define o nome, a posicao x e a posicao y do robô.
        this.nome = nome;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
    }

    public String getNome() {
        //retorna o nome do robô.
        return nome;
    }

    public int getPosicaox() {
        //retorna a posição x do robô.
        return posicaox;
    }

    public int getPosicaoy() {
        //retorna a posição y do robô.
        return posicaoy;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPosicaox(int posicaox){
        this.posicaox = posicaox;
    }
    public void setPosicaoy(int posicaoy){
        this.posicaoy = posicaoy;
    }
    
    public void mover(int deltaX, int deltaY) {
        //move as posições x e y do robô de acordo com um delta x e um delta y.
        if (this.posicaox + deltaX >= 0 && this.posicaoy >= 0) {
            this.posicaox += deltaX;
            this.posicaoy += deltaY; 
            System.out.println("O robo se moveu!");
        }
        else
            System.out.println("O robo nao se moveu, pois iria para coordenadas negativas.");
    }
    
    public void exibirPosicao() {
        //imprime as posições x e y do robô.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", this.posicaox, this.posicaoy);
    }
    
    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void usarSensores(String local) {
        for (Sensor s : sensores) {
            s.monitorar(local);
        }
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }
}
