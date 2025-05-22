public enum TipoEntidade {
    VAZIO('#') ,
    OBSTACULO('o') ,
    ROBO('r') ,
    DESCONHECIDO('?') ;

    private final char representacao;

    TipoEntidade (char representacao) {
        this.representacao = representacao;
    }

    public char getRepresentacao() {
        return representacao;
    }
}