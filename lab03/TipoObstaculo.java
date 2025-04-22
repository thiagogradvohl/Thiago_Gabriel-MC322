public enum TipoObstaculo {
    
    PAREDE (3, 2, 10, true) ,
    ARVORE (5, 2, 2, true) ,
    PREDIO (10, 10, 10, true) ,
    VULCAO (12, 12, 12, true) ,
    RIO (0, 4, 15, true) ,
    CACHOEIRA (8, 4, 1, true) ,
    OUTRO (-1, -1, -1, true) ;  //-1 representa dimensoes variaveis

    private final int alturaPadrao;
    private final int larguraPadrao;
    private final int comprimentoPadrao;
    private final boolean bloqueiaPassagem;
    
    TipoObstaculo (int alturaPadrao, int larguraPadrao, int comprimentoPadrao, boolean bloqueiaPassagem) {
        this.alturaPadrao = alturaPadrao;  //altura do obstaculo
        this.larguraPadrao = larguraPadrao;  //largura do obstaculo
        this.comprimentoPadrao = comprimentoPadrao;  //comprimento do obstaculo
        this.bloqueiaPassagem = bloqueiaPassagem;  
    }
    
    public int getAlturaPadrao() {
        return alturaPadrao ;
    }

    public int getComprimentoPadrao() {
        return comprimentoPadrao;
    }

    public int getLarguraPadrao() {
        return larguraPadrao;
    }

    public boolean isBloqueiaPassagem() {
        return bloqueiaPassagem;
    }
}

