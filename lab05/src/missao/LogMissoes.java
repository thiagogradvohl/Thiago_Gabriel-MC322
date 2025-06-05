package missao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import sensores.*;
import entidade.*;

public class LogMissoes {
    Missao[] missoes;

    public LogMissoes(Missao[] missoes) {
        this.missoes = missoes;
    }

    public void registrarLog(String caminho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Missao missao : missoes) {
                writer.write("====== LOG DA " + missao + " ======\n\n");
                
                if (missao.isExecutada())
                    writer.write("Status: Executada\n");
                else
                    writer.write("Status: Nao Executada\n");

                writer.write("\nPosicoes Visitadas:\n");
                if (missao.getPosicoesVisitadas() != null && !missao.getPosicoesVisitadas().isEmpty())
                    for (String pos : missao.getPosicoesVisitadas()) {
                        writer.write("- " + pos + "\n");
                    }
                else
                    writer.write("- Ainda nao foram visitadas posicoes\n");
                    
                writer.write("\nSensores Ativados:\n");
                if (missao.getSensoresAtivados() != null && !missao.getSensoresAtivados().isEmpty()) {
                    for (Sensor sensor : missao.getSensoresAtivados()) {
                        writer.write("- " + sensor + "\n");
                    }
                }
                else
                    writer.write("- Nenhum sensor foi ativado\n");

                writer.write("\nObstaculos Detectados:\n");
                if (missao.getObstaculosDetectados() != null && !missao.getObstaculosDetectados().isEmpty()) {
                    for (Entidade obstaculo : missao.getObstaculosDetectados()) {
                        writer.write("- " + obstaculo.getDescricao() + "\n");
                    }
                }
                else   
                    writer.write("- Nenhum obstaculo foi detectdo\n");
                
                writer.write("\n#####################################################################################################################################\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o log: " + e.getMessage());
        }
    }
}