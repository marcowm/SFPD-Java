package sfpd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sfpd.pojo.RegistroPOJO;


import java.text.Normalizer;

@Service
public class RegistroService {

    private static final Logger log = LoggerFactory.getLogger(RegistroService.class);

    @Autowired
    public QueueService queueService;

    public void converterEmRegistroEncaminhaFila(RegistroPOJO registro) {

        try {
                // realiza transformacoes caso necessarias e encaminha mensagem
                // ....

                this.enviarRegistroFila(registro);

            } catch (Exception e) {
                log.error("não foi possivel processar o atributo : " + registro.toString() + " do objeto ");
                log.error(e.toString());
            }
    }

    private Object ajusteValor(String nomeCampo, Object valorCampo) {
        // precisa que seja um espaço ==> " "
        if ((valorCampo == null) || valorCampo.toString().isEmpty()) {
            return " ";
        }

        if (nomeCampo.equalsIgnoreCase("id") || nomeCampo.equalsIgnoreCase("name")) {
            String valor = valorCampo.toString();
            valor = valor.replaceAll("[,|:|{|}]", "");
            valor = Normalizer.normalize(valor, Normalizer.Form.NFD);
            return valor.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        }

        return valorCampo;
    }

    public void enviarRegistroFila(RegistroPOJO registro) {

        try {
            queueService.enviar(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
