package com.telcel.gam.siev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.telcel.gam.siev.SievConfig;
import com.telcel.gam.siev.client.SievClient;
import com.telcel.gam.siev.modelo.TcCredcheckEstados;
import com.telcel.gam.siev.modelo.TcCredcheckFuerzasVenta;
import com.telcel.gam.siev.modelo.TcSafinCanales;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.repository.TcCredcheckEstadosRepository;
import com.telcel.gam.siev.repository.TcCredcheckFuerzasVentaRepository;
import com.telcel.gam.siev.repository.TcSafinCanalesRepository;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOfertaResponse;

/**
 *
 * @author VI8G023
 */

@Scope(scopeName = "session")
@Component(value = "sievController")
@ELBeanName("sievController")
public class SievController {
 
	/***************************Beans, variables****************************/
	private SievPojo sievPojo = new SievPojo();
	
	private String responseWS = "";
	
	private TcSafinCanales canales = new TcSafinCanales();
	
	private List<TcSafinCanales> lista = new ArrayList<TcSafinCanales>();
	
	private List<TcCredcheckEstados> listaEstados = new ArrayList<TcCredcheckEstados>();
	
	private List<TcCredcheckFuerzasVenta> listaFuerzaVentas = new ArrayList<TcCredcheckFuerzasVenta>();
	
	@Autowired
	private TcSafinCanalesRepository canalesRepository;
	@Autowired
	private TcCredcheckEstadosRepository estadosRepository;
	@Autowired
	private TcCredcheckFuerzasVentaRepository fuerzaVentasRepository;
	
	@PostConstruct
	private void init () {
		lista = canalesRepository.findAll();
		listaEstados = estadosRepository.findAll();
		listaFuerzaVentas = fuerzaVentasRepository.findAll();
	}

	public String submit() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SievConfig.class);
		SievClient client = context.getBean(SievClient.class);
		
		@SuppressWarnings("unchecked")
		JAXBElement<ConsultarCreditoResponse> responseConsultarCredito = (JAXBElement<ConsultarCreditoResponse>) client.callWebServiceConsultaCliente(sievPojo);
		
		responseWS = com.telcel.gam.siev.util.SievResponseUtil.getResponseConsultarCredito(responseConsultarCredito);
		
		@SuppressWarnings("unchecked")
		JAXBElement<OfertarClienteResponse> responseOfertaCliente = (JAXBElement<OfertarClienteResponse>) client.callWebServiceOfertaCliente(sievPojo);
		
		responseWS = responseWS + com.telcel.gam.siev.util.SievResponseUtil.getResponseOfertaCliente(responseOfertaCliente);
		
		@SuppressWarnings("unchecked")
		JAXBElement<RecalcularOfertaResponse> responseRecalcular = (JAXBElement<RecalcularOfertaResponse>) client.callWebServiceRecalcularOferta(sievPojo);

		responseWS = responseWS + com.telcel.gam.siev.util.SievResponseUtil.getResponseRecalcularOferta(responseRecalcular);
		
		context.close();
		
		return "/sievpage.xhtml?faces-redirect=true";
	}
	
	/***************************Getter y setters******************************/
	
		public String limpiarDatos() {
			sievPojo = new SievPojo();
			responseWS = "";
			return "/sievpage.xhtml?faces-redirect=true";
		}
		
		public SievPojo getSievPojo() {
			return sievPojo;
		}
	
		public void setSievPojo(SievPojo sievPojo) {
			this.sievPojo = sievPojo;
		}
	
		public String getResponseWS() {
			return responseWS;
		}
	
		public void setResponseWS(String responseWS) {
			this.responseWS = responseWS;
		}
		
		public TcSafinCanales getCanales() {
			return canales;
		}
	
		public void setCanales(TcSafinCanales canales) {
			this.canales = canales;
		}
	
		public List<TcSafinCanales> getLista() {
			return lista;
		}
	
		public void setLista(List<TcSafinCanales> lista) {
			this.lista = lista;
		}

		public List<TcCredcheckEstados> getListaEstados() {
			return listaEstados;
		}

		public void setListaEstados(List<TcCredcheckEstados> listaEstados) {
			this.listaEstados = listaEstados;
		}

		public List<TcCredcheckFuerzasVenta> getListaFuerzaVentas() {
			return listaFuerzaVentas;
		}

		public void setListaFuerzaVentas(List<TcCredcheckFuerzasVenta> listaFuerzaVentas) {
			this.listaFuerzaVentas = listaFuerzaVentas;
		}
				
}
