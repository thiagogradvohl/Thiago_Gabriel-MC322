public class ObstaculoAereo extends Obstaculo{
    private int altitude;

    public ObstaculoAereo(int pos_x, int pos_y, String nome_obstaculo, int altitude){
        super(pos_x,pos_y,nome_obstaculo);
        this.altitude = altitude;
    }
    public int getAltitudeObs(){
        return this.altitude;
    }
    public void setAltitudeObs(int altitude){
        this.altitude = altitude;
    }
    
}
