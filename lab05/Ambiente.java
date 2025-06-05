import java.util.ArrayList;

public class Ambiente {
    //Essa classe representa o ambiente onde sao adicionadas entidades
    private final int profundidade;
    private final int largura;
    private final int altura;
    private final int concentracao_o2;
    private final int temperatura;
    private TipoEntidade[][][] mapa;
    private ArrayList<Entidade> entidades;

    public Ambiente(int profundidade, int largura, int altura, int concentracao_o2, int temperatura) {
        //Método construtor: Define a profundidade, a largura e cria os arrays que armazenam robos e obstaculos do ambiente.
        this.profundidade = profundidade;
        this.largura = largura;
        this.altura = altura;
        this.entidades = new ArrayList<>();
        inicializarMapa();
        this.concentracao_o2 = concentracao_o2;
        this.temperatura = temperatura;
    }

    private void inicializarMapa() {
        //inicializa o mapa com TipoEntidade Vazio
        this.mapa = new TipoEntidade[largura][profundidade][altura];
        int i, j, k;
        for (i = 0; i < largura; i++)
            for (j = 0; j < profundidade; j++)
                for (k = 0; k < altura; k++)
                    this.mapa[i][j][k] = TipoEntidade.VAZIO;
    }

    public void moverEntidade(Entidade e, int novoX, int novoY, int novoZ) throws Exception {
        if (e.getTipo() == TipoEntidade.ROBO) {  //só robo é movimentado
            if (((Robo)e).getEstado() == EstadoRobo.LIGADO) {
                if (dentroDosLimites(novoX, novoY, novoY)) {
                    if (!estaOcupado(novoX, novoY, novoZ)) {
                        try {
                            this.mapa[e.getX()][e.getY()][e.getZ()] = TipoEntidade.VAZIO; 
                            this.mapa[novoX][novoY][novoZ] = e.getTipo();  //atualiza o mapa para entidades pontuais
                            ((Robo)e).moverPara(novoX, novoY, novoZ);
                        } catch (Exception err) {
                            this.mapa[e.getX()][e.getY()][e.getZ()] = e.getTipo(); 
                            this.mapa[novoX][novoY][novoZ] = TipoEntidade.VAZIO;  //reatualiza o mapa para entidades em caso de exception
                            throw err;
                        }
                    }
                    else 
                        throw new ColisaoException();
                }
                else 
                    throw new ForaDosLimitesException();
            }
            else
                throw new RoboDesligadoException();
        }
        else
            throw new EntidadeEstaticaException();
    }

    public TipoEntidade[][][] getMapa() {
        return mapa;
    }

    public ArrayList<Entidade> getEntidades() {
        return entidades;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getConcentracao_o2() {
        return concentracao_o2;
    }
    
    public int getProfundidade() {
        //retorna a profundidade do ambiente de movimentação do robô.
        return profundidade;
    }

    public int getLargura() {
        //retorna a largura do ambiente de movimentação do robô.
        return largura;
    }

    public int getAltura(){
        return altura;
    }

    private boolean dentroDosLimites(int x, int y, int z) {
        //retorna se o robo/obstaculo esta, ou nao, nos limites do ambiente.
        return (x <= this.getLargura() && y <= this.getProfundidade() && z <= this.getAltura());
    }

    public void visualizarAmbiente() {
        int i, j, k;
        for (i = 0; i < this.largura; i++) {
            for (j = 0; j < this.profundidade; j++) {
                for (k = altura - 1; k >= 0; k--) {
                    if (this.mapa[i][j][k] != TipoEntidade.VAZIO) {
                        System.out.printf(" %c ", this.mapa[i][j][k].getRepresentacao()); 
                        break;
                    }
                    else if (k == 0)
                        System.out.printf(" %c ", this.mapa[i][j][k].getRepresentacao());
                }
            }
            System.out.println();
        }           
    }

    private void atualizarEspacoMapa(int X1, int X2, int Y1, int Y2, int Z, TipoEntidade tipo) {
        //Essa funcao eh utilizada para atualizar o mapa quando um obstaculo (tridimensional) eh removido ou adicionado
        //as posicoes de X1 ate X2, Y1 ate Y2 e de 0 ate Z sao atualizadas para o TipoEntidade tipo
        int i, j, k;
        for (i = X1; i <= X2; i++)
            for (j = Y1; j <= Y2; j++)
                for (k = 0; k <= Z; k++)
                    this.mapa[i][j][k] = tipo;
    }

    private boolean espacoOcupado(int X1, int X2, int Y1, int Y2, int Z) {
        int i, j, k;
        for (i = X1; i <= X2; i++)
            for (j = Y1; j <= Y2; j++)
                for (k = 0; k <= Z; k++)
                    if (this.mapa[i][j][k] != TipoEntidade.VAZIO)
                        return true;
        return false; 
    }

    public void adicionarEntidade(Entidade e) throws ColisaoException, ForaDosLimitesException {
        if (dentroDosLimites(e.getX(), e.getY(), e.getZ())) {
            if (e.getTipo() != TipoEntidade.OBSTACULO && !estaOcupado(e.getX(), e.getY(), e.getZ())) {
                this.mapa[e.getX()][e.getY()][e.getZ()] = e.getTipo();  //atualiza o mapa para entidades pontuais
                this.entidades.add(e);
            }
            else if (e.getTipo() == TipoEntidade.OBSTACULO && !espacoOcupado(((Obstaculo)e).getX1(), e.getX(), ((Obstaculo)e).getY1(), e.getY(), e.getZ())) {  //obstaculo é 3D
                atualizarEspacoMapa(((Obstaculo)e).getX1(), e.getX(), ((Obstaculo)e).getY1(), e.getY(), e.getZ(), e.getTipo());
                this.entidades.add(e);
            }
            else 
                throw new ColisaoException();
        }
        else 
            throw new ForaDosLimitesException();
    }

    public void removerEntidade(Entidade e) {
        this.entidades.remove(e);
        if (e.getTipo() == TipoEntidade.OBSTACULO)
            atualizarEspacoMapa(((Obstaculo)e).getX1(), e.getX(), ((Obstaculo)e).getY1(), e.getY(), e.getZ(), TipoEntidade.VAZIO);
        else
            this.mapa[e.getX()][e.getY()][e.getZ()] = TipoEntidade.VAZIO;  //atualiza o mapa
    }

    private boolean estaOcupado(int x, int y, int z) {
        return this.mapa[x][y][z] != TipoEntidade.VAZIO;
    }
    
    @Override
    public String toString() {
        String out = "";
        out += "Ambiente com dimensoes " + getLargura() + " x " + getProfundidade() + " x " + getAltura();
        out += ", Temperatura = " + getTemperatura() + " C e Concentracao de O2 = " + getConcentracao_o2() + " mol/l:\n";
        
        if (entidades.isEmpty())
            out += "  |-->O ambiente nao possui Entidades.\n";
        else {
            out += "  |-->Entidades: \n";
            for (int i = 0; i < entidades.size(); i++)
                out += "    ### " + entidades.get(i).getDescricao();         
        }

        return out;
    }
}