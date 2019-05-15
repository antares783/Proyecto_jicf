package com.telcel.gam.siev;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.telcel.gam.siev.client.CreditCheckClient;
import com.telcel.gam.siev.client.SafinClient;

@Configuration
@Qualifier("CreditCheckConfig")
public class CreditCheckConfig {

	@Bean
    public Jaxb2Marshaller marshallerC() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.telcel.gam.siev.ws");
        return marshaller;
    }
 
    @Bean
    public CreditCheckClient soapConnector(Jaxb2Marshaller marshaller) {
    	CreditCheckClient client = new CreditCheckClient();
        client.setDefaultUri("http://localhost:8088/mockCreditCheckWSPortBinding?WSDL");
//        client.setDefaultUri("http://191.9.3.249:9080/CreditCheckWS/service/CreditCheckWS.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
	
}
