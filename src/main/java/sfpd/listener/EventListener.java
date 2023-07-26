package sfpd.listener;

import sfpd.pojo.RegistroPOJO;
import sfpd.service.ArquivoService;
import sfpd.service.RegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    @Autowired
    private RegistroService registroService;

    @Autowired
    private ArquivoService arquivoService;

    @JmsListener(destination = "fila1", containerFactory = "defaultFactory")
    public void recebeMensagemFilaProducerPython(RegistroPOJO mensagem) {

        try {
            // processa registro
            registroService.converterEmRegistroEncaminhaFila(mensagem);

            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }

    @JmsListener(destination = "fila2", containerFactory = "defaultFactory")
    public void recebeMensagemSegundaFila(RegistroPOJO mensagem) {

        try {
             // retorna mensagens da fila2 e salva na base de dados
             arquivoService.adicionarLinhaArquivo(mensagem);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
