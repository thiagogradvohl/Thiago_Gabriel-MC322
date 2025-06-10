import exceptions.CameraDesligadaException;

public class DroneFotografico extends RoboAereo implements Fotografico {
    private boolean camera_ligada;
    private int fotos_tiradas; //quantidade de fotos tiradas

    public DroneFotografico(int X, int Y, int altitude, int altitudeMaxima, String Id, Sensor sensor, EstadoRobo estado) {
        super(X, Y, altitude, altitudeMaxima, Id, sensor, estado);
        this.camera_ligada = false;
        this.fotos_tiradas = 0;
    }

    @Override
    public boolean isCamera_ligada() {
        return camera_ligada;
    }

    public int getFotos_tiradas() {
        return fotos_tiradas;
    }

    @Override
    public void executarTarefa() throws Exception {
        //essa funcao faz o drone tirar uma foto aerea de sua posicao 
        if (this.camera_ligada && this.getEstado() == EstadoRobo.LIGADO) {  
            System.out.printf("Foto tirada na posição: (%d, %d, %d).\n", getX(), getY(), getAltitude());
            this.fotos_tiradas++;
        }
        else if (!this.camera_ligada)
            throw new CameraDesligadaException();
        else
            throw new RoboDesligadoException();    
    }   

    @Override
    public void ligar_camera() {
        if (!this.camera_ligada) { //se a camera estiver desligada
            this.camera_ligada = true;
            System.out.printf("A câmera foi ligada.\n");
        }
        else   
            System.out.printf("A câmera já está ligada.\n");
    }

    @Override
    public void desligar_camera() {
        if (this.camera_ligada) {
            this.camera_ligada = false;
            System.out.printf("A câmera foi desligada.\n");
        }
        else
            System.out.printf("A câmera já está desligada.\n");
    }

    @Override
    public String getDescricao() {
        String out = "";
        out += "DroneFotografico " + getId() + " (" + getEstado();
        if (isCamera_ligada())
            out += " e camera LIGADA)";
        else
            out += " e camera DESLIGADA)";

        out += " esta na posicao " + "(" + getX() + ", " + getY() + ", " + getAltitude() + "), ";
        out += "com Altura maxima = " + getAltitudeMaxima() + " e " + getFotos_tiradas() + " fotos tiradas:\n";
        if (getSensores() == null)  
            out += "        |->Ele nao possui sensores.";
        else {
            out += "        |-->Sensores:\n";
            for (Sensor s : getSensores())
                out += "          |-->" + s.toString() + "\n";
        }
        return out;
    } 

}