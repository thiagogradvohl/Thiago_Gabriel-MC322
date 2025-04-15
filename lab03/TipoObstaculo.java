public enum TipoObstaculo {
    
    PAREDE (3 , true, "Sólido" ) ,
    ARVORE (5 , true, "Sólido" ) ,
    PREDIO (10 , true, "Sólido" ) ,
    VULCAO (10, true, "Sólido" ) ,
    RIO (0, true, "Líquido") ,
    CACHOEIRA (8 , true, "Líquido") ,
    H2S (10, true, "Gás") ;

    private final int alturaPadrao;
    private final boolean bloqueiaPassagem;
    private final String estadoFisico; //determina o estado fisico do obstaculo
    
    TipoObstaculo (int alturaPadrao, boolean bloqueiaPassagem, String estadoFisico) {
        this.alturaPadrao = alturaPadrao;  //altura do obstaculo
        this.bloqueiaPassagem = bloqueiaPassagem;  
        this.estadoFisico = estadoFisico;
    }
    
    public int getAlturaPadrao() {
        return alturaPadrao ;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public boolean isBloqueiaPassagem() {
        return bloqueiaPassagem;
    }
}