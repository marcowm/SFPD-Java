package sfpd.service;

import sfpd.pojo.RegistroPOJO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QueueService {

    @Autowired
    private JmsTemplate jmsTemplate;

    ObjectMapper mapper = new ObjectMapper();

    public QueueService() {

        SimpleModule module = new SimpleModule();
        module.addSerializer(RegistroPOJO.class, new EventoSerializer());
        mapper.registerModule(module);
    }

    public void producerSend(RegistroPOJO registro){
        jmsTemplate.convertAndSend("fila2",
                new RegistroPOJO(registro.getId(),
                                 registro.getData(),
                                 registro.getArquivoId(),
                                 registro.getArquivoPath(),
                                 registro.getLinha()
                                 ));
    }

    public void enviar(RegistroPOJO registro) throws Exception {
        String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(registro);
        jmsTemplate.convertAndSend("fila2", message);
    }
}

class EventoSerializer extends StdSerializer<RegistroPOJO> {
    public EventoSerializer() {
        super(RegistroPOJO.class);
    }

    protected EventoSerializer(Class<RegistroPOJO> t) {
        super(t);
    }

    @Override
    public void serialize(RegistroPOJO value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        ObjectMapper om = new ObjectMapper().disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        om.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        SimpleModule module = new SimpleModule("jackson-page-with-jsonview", Version.unknownVersion());

        om.registerModule(module);

        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeFieldName("data");
        gen.writeObject(value.getData());
        gen.writeNumberField("arquivoId", value.getArquivoId());
        gen.writeStringField("arquivoPath", value.getArquivoPath());
        // gen.writeFieldName("linha");
        // gen.writeRawValue(om.writerWithView(provider.getActiveView()).writeValueAsString( value.getLinha()));
        gen.writeStringField("linha", value.getLinha());

        gen.writeEndObject();
    }
}