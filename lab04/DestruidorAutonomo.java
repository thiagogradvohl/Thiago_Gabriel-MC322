public interface DestruidorAutonomo{
   public void atualizar_entidades(Ambiente ambiente);
   public SensorProximidade identificar_sp();
   public void recarregarBateria(int energia_adicionada);
}
