public enum TipoObstaculo {
    
    PAREDE (3 , true ) ,
    ARVORE (5 , true ) ,
    PREDIO (10 , true ) ,
    BURACO (0 , true ) ,
    VULCAO (10, true ),
    METEORO (5, true ),
    GAIVOTA (2, true ),
    PEIXE (1, true),
    OUTRO (-1 , false); // Altura -1 representa valor variavel
        
    private final int alturaPadrao;
    private final boolean bloqueiaPassagem;
    
    TipoObstaculo (int alturaPadrao, boolean bloqueiaPassagem ) {
        this.alturaPadrao = alturaPadrao;  //altura do obstaculo
        this.bloqueiaPassagem = bloqueiaPassagem;  
    }
    
    public int getAlturaPadrao () {
        return alturaPadrao ;
    }

    public boolean isBloqueiaPassagem () {
        return bloqueiaPassagem;
    }
}