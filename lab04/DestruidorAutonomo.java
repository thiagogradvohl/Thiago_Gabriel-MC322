public interface DestruidorAutonomo{
   void atualizar_entidades(Ambiente ambiente);
   SensorProximidade identificar_sp();
   void recarregarBateria(int energia_adicionada);
}
