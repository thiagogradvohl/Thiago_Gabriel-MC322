public class DroneFotografico extends RoboAereo{
    private boolean camera_ligada;
    private int fotos_tiradas; //quantidade de fotos tiradas

    public DroneFotografico(int posicaox, int posicaoy, int altitude, int altitudeMaxima, String nome, boolean tem_camera) {
        super(posicaox, posicaoy, altitude, altitudeMaxima, nome);
        this.camera_ligada = false;
        this.fotos_tiradas = 0;
    }

    public boolean isCamera_ligada() {
        return camera_ligada;
    }

    public int getFotos_tiradas() {
        return fotos_tiradas;
    }

    public void tirar_foto() {
        if (this.camera_ligada) {
            System.out.printf("Foto tirada na posição: (%d, %d, %d).\n", getPosicaox(), getPosicaoy(), getAltitude());
            this.fotos_tiradas++;
        }
        else 
            System.out.printf("Não foi possível tirar a foto. A câmera está desligada.\n");
    }   

    public void ligar_camera() {
        if (!this.camera_ligada) { //se a camera estiver desligada
            this.camera_ligada = true;
            System.out.printf("A câmera foi ligada.\n");
        }
        else   
            System.out.printf("A câmera já está ligada.\n");
    }

    public void desligar_camera() {
        if (this.camera_ligada) {
            this.camera_ligada = false;
            System.out.printf("A câmera foi desligada.\n");
        }
        else
            System.out.printf("A câmera já está desligada.\n");
    }
}
