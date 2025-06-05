import java.util.ArrayList;

public class CentralComunicacao {
    private ArrayList<String[]> mensagens;  //lista cujos elementos sao listas de 2 elementos (posicao 0 = remetente e posicao 1 = mensagem)

    public CentralComunicacao() {
        this.mensagens = new ArrayList<String[]>();
    }

    public void setMensagens(ArrayList<String[]> mensagens) {
        this.mensagens = mensagens;
    }

    public void registrarMensagem(String remetente, String msg) {
        String[] mensagem = {remetente, msg};
        mensagens.add(mensagem);
    }

    public void exibirMensagens() {
        int i;
        if (this.mensagens.isEmpty())
            System.out.println("Ainda nao ha mensagens trocadas.");
        for (i = 0; i < this.mensagens.size(); i++)
            System.out.println(mensagens.get(i)[0] + ": " + mensagens.get(i)[1]);
    }

    public ArrayList<String[]> getMensagens() {
        return mensagens;
    }

}