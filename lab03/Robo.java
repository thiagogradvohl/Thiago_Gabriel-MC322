import java.util.List;
import java.util.ArrayList;

public class Robo 
{
    private String nome;
    private int posicaox;
    private int posicaoy;
    private List<Sensor> sensores;
    

    public Robo(int posicaox, int posicaoy, String nome, Sensor sensor) {
        //Método construtor: Define o nome, a posicao x e a posicao y do robô.
        this.nome = nome;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
        this.sensores = new ArrayList<Sensor>();
        this.sensores.add(sensor);
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
        int novo_x = this.posicaox + deltaX;
        int novo_y = this.posicaoy + deltaY; 
        if (novo_x >= 0 && novo_y >= 0) {
            this.posicaox = novo_x;
            this.posicaoy = novo_y; 
            System.out.println("O robo se moveu!");
        }
        else if (novo_x < 0 && novo_y < 0)
            System.out.println("O robo nao se moveu, pois iria para coordenadas negativas.");
    }
    
    public void exibirPosicao() {
        //imprime as posições x e y do robô.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", this.posicaox, this.posicaoy);
    }
    
    public void adicionarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    public void usarSensores() {
        for (Sensor s : sensores) {
            s.monitorar(this);
        }
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void removerSensor(Sensor sensor) {
        this.sensores.remove(sensor);
    }

    public String toString() {
        String out = "";
        out += "Robo " + getNome() + " esta na posicao " + "(" + getPosicaox() + ", " + getPosicaoy() + "):\n";
        if (getSensores() == null) 
            out += "        |-->Ele nao possui sensores.";
        else {
            out += "        |-->Sensores:\n";
            for (Sensor s : getSensores())
                out += "          |-->" + s.toString() + "\n";
        }
        return out;
    } 
}
