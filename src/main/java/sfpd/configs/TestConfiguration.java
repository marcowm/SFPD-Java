package sfpd.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class TestConfiguration {

//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerFactory() {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory());
//        return factory;
//    }
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return new ActiveMQConnectionFactory(embeddedBroker.getVmURL());
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(connectionFactory());
//    }
}
