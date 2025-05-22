public class Obstaculo
{
    private String nome_obstaculo;
    private int pos_x;
    private int pos_y;
    
    public Obstaculo(int pos_x, int pos_y, String nome_obstaculo){
        //Método construtor: Define o nome, a posicao x e a posicao y e a posicao z do obstaculo.
        this.nome_obstaculo = nome_obstaculo;
        this.pos_x = pos_x;
        this.pos_y=pos_y;
    }
    public String getNome() {
        //retorna o nome do Obstaculo.
        return nome_obstaculo;
    }

    public int getPosicaox() {
        //retorna a posição x do Obstaculo.
        return pos_x;
    }

    public void setNome_obstaculo(String nome_obstaculo) {
        this.nome_obstaculo = nome_obstaculo;
    }
    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }
    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
    public int getPosicaoy() {
        //retorna a posição y do Obstaculo.
        return pos_y;
    }
    
    public void exibirPosicao() {
        //imprime as posições x e y do Obstaculo.
        System.out.printf("Posicao X: %d\nPosicao Y: %d\n", pos_x, pos_y);
    }
    
}
