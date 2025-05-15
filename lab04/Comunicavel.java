public interface Comunicavel {
    String enviarMensagem(Comunicavel destinatario, String mensagem);
    String receberMensagem(String mensagem);  //pode lancar robodesligadoexception
}