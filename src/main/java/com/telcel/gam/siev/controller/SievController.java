package com.telcel.gam.siev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;

import org.assertj.core.util.DateUtil;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.telcel.gam.siev.SievConfig;
import com.telcel.gam.siev.client.SievClient;
import com.telcel.gam.siev.modelo.TcCredcheckEstados;
import com.telcel.gam.siev.modelo.TcCredcheckFuerzasVenta;
import com.telcel.gam.siev.modelo.TcCredcheckRegiones;
import com.telcel.gam.siev.modelo.TcMarca;
import com.telcel.gam.siev.modelo.TcModelo;
import com.telcel.gam.siev.modelo.TcSafinCanales;
import com.telcel.gam.siev.modelo.TcSistemasCatalogos;
import com.telcel.gam.siev.modelo.TtWsLlamadaRespuesta;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.repository.TcCredcheckEstadosRepository;
import com.telcel.gam.siev.repository.TcCredcheckFuerzasVentaRepository;
import com.telcel.gam.siev.repository.TcCredcheckRegionesRepository;
import com.telcel.gam.siev.repository.TcMarcaRepository;
import com.telcel.gam.siev.repository.TcModeloRepository;
import com.telcel.gam.siev.repository.TcSafinCanalesRepository;
import com.telcel.gam.siev.repository.TcSistemasCatalogosRepository;
import com.telcel.gam.siev.repository.TtWsLlamadaRespuestaRepository;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;

/**
 *
 * @author VI8G023
 */

@Scope(scopeName = "session")
@Component(value = "sievController")
@ELBeanName("sievController")
public class SievController {
 
	public static final Short SAFiN = 1;
	public static final Short CREDITCHECK= 2;
	
	
	/***************************Beans, variables****************************/
	private SievPojo sievPojo = new SievPojo();
	
	private String responseWS = "";
	
	private String claveMarca = "";
	
	private TcSafinCanales canales = new TcSafinCanales();
	
	private List<TcSafinCanales> lista = new ArrayList<TcSafinCanales>();
	
	private List<TcCredcheckEstados> listaEstados = new ArrayList<TcCredcheckEstados>();
	
	private List<TcCredcheckFuerzasVenta> listaFuerzaVentas = new ArrayList<TcCredcheckFuerzasVenta>();
	
	private List<TcCredcheckRegiones> listaRegiones = new ArrayList<TcCredcheckRegiones>();
	
	private List<TcMarca> listaMarca = new ArrayList<TcMarca>();
	
	private List<TcModelo> listaModelo =  new ArrayList<TcModelo>();
	
	private TtWsLlamadaRespuesta ttWsLlamadaRespuesta;
	/**
	 * Lista general para todos los catalogos
	 */
	private List<TcSistemasCatalogos> listaCatalogos = new ArrayList<TcSistemasCatalogos>();
	
	private List<TcSistemasCatalogos> listaCveBanco = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaCredAutomotriz = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaCredBancario = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaFormaPago = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaMercado = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaModalidadInvest = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaProyecto = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaSexo = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaTipoLinea = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaTipoPersona = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaTramite = new ArrayList<TcSistemasCatalogos>();
	private List<TcSistemasCatalogos> listaVentaPlazos = new ArrayList<TcSistemasCatalogos>();
	
	@Autowired
	private TcSafinCanalesRepository canalesRepository;
	@Autowired
	private TcCredcheckEstadosRepository estadosRepository;
	@Autowired
	private TcCredcheckFuerzasVentaRepository fuerzaVentasRepository;
	@Autowired
	private TcCredcheckRegionesRepository regionesRepository;
	@Autowired
	private TcMarcaRepository marcaRepository;
	@Autowired
	private TcModeloRepository modeloRepository;
	@Autowired
	private TtWsLlamadaRespuestaRepository llamadaRespuestaRepository;
	@Autowired
	private TcSistemasCatalogosRepository catalogosSistemaRepository;
	
	@PostConstruct
	private void init () {
		lista = canalesRepository.findAll();
		listaEstados = estadosRepository.findAll();
		listaFuerzaVentas = fuerzaVentasRepository.findAll();
		listaRegiones = regionesRepository.findAll();
		listaMarca = marcaRepository.findByParams('1');
		listaCatalogos = catalogosSistemaRepository.findAll();
		llenadoCatalogos();
	}
	
	public void llenadoCatalogos() {
		System.out.println("Pasando por el llenado de catalogos");
		listaCatalogos.forEach((TcSistemasCatalogos pivot) -> {
			switch (pivot.getTcSistemasCatalogosPK().getCampo()) {
				case "CLAVE_BANCO":
					listaCveBanco.add(pivot);
				break;
				case "CREDITO_AUTOMOTRIZ":
					listaCredAutomotriz.add(pivot);
				break;
				case "CREDITO_BANCARIO":
					listaCredBancario.add(pivot);
				break;
				case "FORMA_PAGO":
					listaFormaPago.add(pivot);
				break;
				case "MERCADO":
					listaMercado.add(pivot);
				break;
				case "MODALIDAD_INVESTIGACION":
					listaModalidadInvest.add(pivot);
				break;
				case "PROYECTO":
					listaProyecto.add(pivot);
				break;
				case "SEXO":
					listaSexo.add(pivot);
				break;
				case "TIPO_LINEA":
					listaTipoLinea.add(pivot);
				break;
				case "TIPO_PERSONA":
					listaTipoPersona.add(pivot);
				break;
				case "TIPO_TRAMITE":
					listaTramite.add(pivot);
				break;
				case "VENTA_PLAZOS":
					listaVentaPlazos.add(pivot);
				break;
				default:
				break;
			}
		});
	}

	public void getModelosByMarca() {
		System.out.println("Get modelos by marca");
		System.out.println(sievPojo.getCveMarca());
		if(sievPojo.getCveMarca() != null || sievPojo.getCveMarca() != 0) {
			System.out.println(listaModelo);
			listaModelo = modeloRepository.findByMarca('1', marcaRepository.findById(sievPojo.getCveMarca()).get());
			
		}
		
	}
	
	public String submit() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SievConfig.class);
		SievClient client = context.getBean(SievClient.class);
		
		@SuppressWarnings("unchecked")
		JAXBElement<ConsultarCreditoResponse> responseConsultarCredito = (JAXBElement<ConsultarCreditoResponse>) client.callWebServiceConsultaCliente(sievPojo);
		
		ttWsLlamadaRespuesta = new TtWsLlamadaRespuesta(1);
		ttWsLlamadaRespuesta.setClaveSistema(SAFiN);
		ttWsLlamadaRespuesta.setFecha(DateUtil.now());
		ttWsLlamadaRespuesta.setUsuario("EX406063");
//		ttWsLlamadaRespuesta.setLlamada(responseConsultarCredito.getValue().getConsultarCreditoResponse().);
		
		llamadaRespuestaRepository.saveAndFlush(ttWsLlamadaRespuesta);
		
		responseWS = com.telcel.gam.siev.util.SievResponseUtil.getResponseConsultarCredito(responseConsultarCredito);
//		
//		@SuppressWarnings("unchecked")
//		JAXBElement<OfertarClienteResponse> responseOfertaCliente = (JAXBElement<OfertarClienteResponse>) client.callWebServiceOfertaCliente(sievPojo);
//		
//		responseWS = responseWS + com.telcel.gam.siev.util.SievResponseUtil.getResponseOfertaCliente(responseOfertaCliente);
//		
//		@SuppressWarnings("unchecked")
//		JAXBElement<RecalcularOfertaResponse> responseRecalcular = (JAXBElement<RecalcularOfertaResponse>) client.callWebServiceRecalcularOferta(sievPojo);
//
//		responseWS = responseWS + com.telcel.gam.siev.util.SievResponseUtil.getResponseRecalcularOferta(responseRecalcular);
		
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

		public List<TcCredcheckRegiones> getListaRegiones() {
			return listaRegiones;
		}

		public void setListaRegiones(List<TcCredcheckRegiones> listaRegiones) {
			this.listaRegiones = listaRegiones;
		}

		public List<TcMarca> getListaMarca() {
			return listaMarca;
		}

		public void setListaMarca(List<TcMarca> listaMarca) {
			this.listaMarca = listaMarca;
		}

		public List<TcModelo> getListaModelo() {
			return listaModelo;
		}

		public void setListaModelo(List<TcModelo> listaModelo) {
			this.listaModelo = listaModelo;
		}

		public String getClaveMarca() {
			return claveMarca;
		}

		public void setClaveMarca(String claveMarca) {
			this.claveMarca = claveMarca;
		}

		public TtWsLlamadaRespuesta getTtWsLlamadaRespuesta() {
			return ttWsLlamadaRespuesta;
		}

		public void setTtWsLlamadaRespuesta(TtWsLlamadaRespuesta ttWsLlamadaRespuesta) {
			this.ttWsLlamadaRespuesta = ttWsLlamadaRespuesta;
		}

		public List<TcSistemasCatalogos> getListaCatalogos() {
			return listaCatalogos;
		}

		public void setListaCatalogos(List<TcSistemasCatalogos> listaCatalogos) {
			this.listaCatalogos = listaCatalogos;
		}

		public List<TcSistemasCatalogos> getListaCveBanco() {
			return listaCveBanco;
		}

		public void setListaCveBanco(List<TcSistemasCatalogos> listaCveBanco) {
			this.listaCveBanco = listaCveBanco;
		}

		public List<TcSistemasCatalogos> getListaCredAutomotriz() {
			return listaCredAutomotriz;
		}

		public void setListaCredAutomotriz(List<TcSistemasCatalogos> listaCredAutomotriz) {
			this.listaCredAutomotriz = listaCredAutomotriz;
		}

		public List<TcSistemasCatalogos> getListaCredBancario() {
			return listaCredBancario;
		}

		public void setListaCredBancario(List<TcSistemasCatalogos> listaCredBancario) {
			this.listaCredBancario = listaCredBancario;
		}

		public List<TcSistemasCatalogos> getListaFormaPago() {
			return listaFormaPago;
		}

		public void setListaFormaPago(List<TcSistemasCatalogos> listaFormaPago) {
			this.listaFormaPago = listaFormaPago;
		}

		public List<TcSistemasCatalogos> getListaMercado() {
			return listaMercado;
		}

		public void setListaMercado(List<TcSistemasCatalogos> listaMercado) {
			this.listaMercado = listaMercado;
		}

		public List<TcSistemasCatalogos> getListaModalidadInvest() {
			return listaModalidadInvest;
		}

		public void setListaModalidadInvest(List<TcSistemasCatalogos> listaModalidadInvest) {
			this.listaModalidadInvest = listaModalidadInvest;
		}

		public List<TcSistemasCatalogos> getListaProyecto() {
			return listaProyecto;
		}

		public void setListaProyecto(List<TcSistemasCatalogos> listaProyecto) {
			this.listaProyecto = listaProyecto;
		}

		public List<TcSistemasCatalogos> getListaSexo() {
			return listaSexo;
		}

		public void setListaSexo(List<TcSistemasCatalogos> listaSexo) {
			this.listaSexo = listaSexo;
		}

		public List<TcSistemasCatalogos> getListaTipoLinea() {
			return listaTipoLinea;
		}

		public void setListaTipoLinea(List<TcSistemasCatalogos> listaTipoLinea) {
			this.listaTipoLinea = listaTipoLinea;
		}

		public List<TcSistemasCatalogos> getListaTipoPersona() {
			return listaTipoPersona;
		}

		public void setListaTipoPersona(List<TcSistemasCatalogos> listaTipoPersona) {
			this.listaTipoPersona = listaTipoPersona;
		}

		public List<TcSistemasCatalogos> getListaTramite() {
			return listaTramite;
		}

		public void setListaTramite(List<TcSistemasCatalogos> listaTramite) {
			this.listaTramite = listaTramite;
		}

		public List<TcSistemasCatalogos> getListaVentaPlazos() {
			return listaVentaPlazos;
		}

		public void setListaVentaPlazos(List<TcSistemasCatalogos> listaVentaPlazos) {
			this.listaVentaPlazos = listaVentaPlazos;
		}

		
}
