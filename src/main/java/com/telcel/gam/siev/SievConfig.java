package com.telcel.gam.siev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.telcel.gam.siev.client.SievClient;
/**
 * Clase para configurar los datos de los clientes de los Web Service
 * @author VI8G023
 *
 */
@Configuration
public class SievConfig {

	@Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.telcel.gam.siev.ws");
        return marshaller;
    }
 
    @Bean
    public SievClient soapConnector(Jaxb2Marshaller marshaller) {
    	SievClient client = new SievClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
	
}
