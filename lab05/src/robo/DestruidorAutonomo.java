package robo;

import sensores.SensorProximidade;
import ambiente.*;

public interface DestruidorAutonomo{
   void atualizar_ambiente(Ambiente ambiente);
   SensorProximidade identificar_sp();
   void recarregarBateria(int energia_adicionada);
   void atualizar_entidades_proximas(Ambiente a);
}
