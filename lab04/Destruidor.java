import java.util.List;

public interface Destruidor{
   public List<Entidade> DestruirObstaculos();
   public void atualizar_entidades(Ambiente ambiente);
   public SensorProximidade identificar_sp();
   
}
