package com.telcel.gam.siev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.telcel.gam.siev.client.SafinClient;

@Configuration
public class SafinConfig {

	@Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.telcel.gam.siev.ws");
        return marshaller;
    }
 
    @Bean
    public SafinClient soapConnector(Jaxb2Marshaller marshaller) {
        SafinClient client = new SafinClient();
        client.setDefaultUri("http://localhost:8098/mockSafinServicesSoapBinding?WSDL");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
	
}