public enum TipoObstaculo {
    //Essa classe representa os tipos de obstaculo com dimensoes predefinidas
    //Sera usada pela classe Obstaculo

    PAREDE (6, 2, 3, true) ,
    ARVORE (8, 2, 1, true) ,
    PREDIO (15, 5, 5, true) ,
    VULCAO (15, 5, 5, true) ,
    RIO (0, 4, 10, true) ,
    CACHOEIRA (15, 4, 1, true) ,
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

