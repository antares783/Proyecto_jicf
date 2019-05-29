package com.telcel.gam.siev.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.stream.StreamResult;

import org.assertj.core.util.DateUtil;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.WebServiceMessageSender;

import com.telcel.gam.siev.SievConfig;
import com.telcel.gam.siev.client.SievClient;
import com.telcel.gam.siev.modelo.TcCredcheckCanalesVenta;
import com.telcel.gam.siev.modelo.TcCredcheckEstados;
import com.telcel.gam.siev.modelo.TcCredcheckFuerzasVenta;
import com.telcel.gam.siev.modelo.TcCredcheckRegiones;
import com.telcel.gam.siev.modelo.TcMarca;
import com.telcel.gam.siev.modelo.TcModelo;
import com.telcel.gam.siev.modelo.TcPlan;
import com.telcel.gam.siev.modelo.TcSafinCanales;
import com.telcel.gam.siev.modelo.TcSafinMovimientos;
import com.telcel.gam.siev.modelo.TcSafinSistemas;
import com.telcel.gam.siev.modelo.TcSafinTiposProducto;
import com.telcel.gam.siev.modelo.TcSistemas;
import com.telcel.gam.siev.modelo.TcSistemasCatalogos;
import com.telcel.gam.siev.modelo.TcTipoPlan;
import com.telcel.gam.siev.modelo.TcTipoPlazo;
import com.telcel.gam.siev.modelo.TtWsLlamadaRespuesta;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.repository.TcCredcheckCanalesVentaRepository;
import com.telcel.gam.siev.repository.TcCredcheckEstadosRepository;
import com.telcel.gam.siev.repository.TcCredcheckFuerzasVentaRepository;
import com.telcel.gam.siev.repository.TcCredcheckRegionesRepository;
import com.telcel.gam.siev.repository.TcMarcaRepository;
import com.telcel.gam.siev.repository.TcModeloRepository;
import com.telcel.gam.siev.repository.TcPlanRepository;
import com.telcel.gam.siev.repository.TcSafinCanalesRepository;
import com.telcel.gam.siev.repository.TcSafinMovimientosRepository;
import com.telcel.gam.siev.repository.TcSafinSistemasRepository;
import com.telcel.gam.siev.repository.TcSafinTiposProductoRepository;
import com.telcel.gam.siev.repository.TcSistemasCatalogosRepository;
import com.telcel.gam.siev.repository.TcTipoPlanRepository;
import com.telcel.gam.siev.repository.TcTipoPlazoRepository;
import com.telcel.gam.siev.repository.TtWsLlamadaRespuestaRepository;
import com.telcel.gam.siev.util.MethodWsType;
import com.telcel.gam.siev.util.RequestResponseType;
import com.telcel.gam.siev.ws.ConsultarCredito;
import com.telcel.gam.siev.ws.ConsultarCreditoPetType;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.EvaluacionTramite;
import com.telcel.gam.siev.ws.EvaluacionTramiteResponse;
import com.telcel.gam.siev.ws.ObjectFactory;
import com.telcel.gam.siev.ws.OfertarCliente;
import com.telcel.gam.siev.ws.OfertarClientePetType;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOferta;
import com.telcel.gam.siev.ws.RecalcularOfertaResponse;

/**
 *
 * @author VI8G023
 */

@Scope(scopeName = "session")
@Component(value = "sievController")
@ELBeanName("sievController")
public class SievController extends WebServiceGatewaySupport {

	public static final Short SAFiN = 1;
	public static final Short CREDITCHECK = 2;

	/*************************** Beans, variables ****************************/
	private SievPojo sievPojo = new SievPojo();

	private String responseWS = "";

	private String claveMarca = "";

	private TcSafinCanales canales = new TcSafinCanales();

	private List<TcSafinCanales> lista = new ArrayList<TcSafinCanales>();

	private List<TcCredcheckEstados> listaEstados = new ArrayList<TcCredcheckEstados>();

	private List<TcCredcheckFuerzasVenta> listaFuerzaVentas = new ArrayList<TcCredcheckFuerzasVenta>();

	private List<TcCredcheckRegiones> listaRegiones = new ArrayList<TcCredcheckRegiones>();

	private List<TcMarca> listaMarca = new ArrayList<TcMarca>();

	private List<TcModelo> listaModelo = new ArrayList<TcModelo>();

	private List<TcTipoPlan> listaTipoPlan = new ArrayList<TcTipoPlan>();

	private List<TcTipoPlazo> listaTipoPlazo = new ArrayList<TcTipoPlazo>();

	private List<TcCredcheckCanalesVenta> listaCanalesVenta = new ArrayList<TcCredcheckCanalesVenta>();

	private List<TcPlan> listaPlan = new ArrayList<TcPlan>();

	private List<TcSafinMovimientos> listaMovimientos = new ArrayList<TcSafinMovimientos>();

	private List<TcSafinSistemas> listaSistemas = new ArrayList<TcSafinSistemas>();

	private List<TcSafinTiposProducto> listaProductos = new ArrayList<TcSafinTiposProducto>();

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
	@Autowired
	private TcTipoPlanRepository tipoPlanRepository;
	@Autowired
	private TcTipoPlazoRepository tipoPlazoRepository;
	@Autowired
	private TcCredcheckCanalesVentaRepository canalesVentaRepository;
	@Autowired
	private TcPlanRepository planRepository;
	@Autowired
	private TcSafinMovimientosRepository movimientosRepository;
	@Autowired
	private TcSafinSistemasRepository safinSistemasRepository;
	@Autowired
	private TcSafinTiposProductoRepository safinProductoRepository;
//	@Autowired
//	private SievClient cliente;

	@PostConstruct
	private void init() {
		lista = canalesRepository.findAll();
		listaEstados = estadosRepository.findAll();
		listaFuerzaVentas = fuerzaVentasRepository.findAll();
		listaRegiones = regionesRepository.findAll();
		listaMarca = marcaRepository.findByParams('1');
		listaCatalogos = catalogosSistemaRepository.findAll();
		listaTipoPlan = tipoPlanRepository.findAll();
		listaTipoPlazo = tipoPlazoRepository.findAll();
		listaCanalesVenta = canalesVentaRepository.findAll();
		listaMovimientos = movimientosRepository.findAll();
		listaSistemas = safinSistemasRepository.findAll();
		listaProductos = safinProductoRepository.findAll();
		llenadoCatalogos();
	}

	public void llenadoCatalogos() {
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

	public void getPlanesByTipoPlanTipoPlazo() {
		System.out.println("Get planes by tipo plan, tipo plazo");
		System.out.println("Tipo Plan " + sievPojo.getTipoPlan());
		System.out.println("Tipo Plazo " + sievPojo.getTipoPlazo());
		if (sievPojo.getTipoPlan() != null && sievPojo.getTipoPlazo() != null) {
			listaPlan = new ArrayList<TcPlan>();
			listaPlan = planRepository.findByTipoPlanTipoPlazo(new TcTipoPlan(sievPojo.getTipoPlan()),
					new TcTipoPlazo(sievPojo.getTipoPlazo()), '1');
			System.out.println("Tamaño de los planes" + listaPlan.size());
		}
	}

	public void getModelosByMarca() {
		if (sievPojo.getCveMarca() != null || sievPojo.getCveMarca() != 0)
			listaModelo = (List<TcModelo>) marcaRepository.findById(sievPojo.getCveMarca()).get()
					.getTcModeloCollection();
	}
	@Transactional
	public void saveRequestResponse(TcSistemas claveSistema, String request, String response, String metodoInvocado) {
		TtWsLlamadaRespuesta llamadaRespuesta = new TtWsLlamadaRespuesta();
		Integer sec = llamadaRespuestaRepository.getNextSeriesId();
		System.out.println("La secuencia: " + sec);
		if (sec != null && sec > 0) {
			llamadaRespuesta.setId(sec);
			llamadaRespuesta.setFecha(new Date());
			llamadaRespuesta.setClaveSistema(claveSistema);
			llamadaRespuesta.setUsuario("EX406063");
			llamadaRespuesta.setMetodoInvocado(metodoInvocado);
			llamadaRespuesta.setLlamada(request);
			llamadaRespuesta.setRespuesta(response);
			llamadaRespuestaRepository.saveAndFlush(llamadaRespuesta);
		} else {
			System.out.println("No funciono la puta secuencia de mierda");
		}
	}

	@SuppressWarnings("unchecked")
	public String submit() throws XmlMappingException, IOException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SievConfig.class);
		SievClient cliente = context.getBean(SievClient.class);
		ObjectFactory of = new ObjectFactory();
		// ***********************************************
		// Consulta el ws para el metodo Consultar Credito
		// ***********************************************
		ConsultarCredito consultarCredito = com.telcel.gam.siev.util.SievUtil.getConsultarCredito(sievPojo);
		JAXBElement<ConsultarCredito> requestConsultarCredito = of.createConsultarCredito(consultarCredito);

		JAXBElement<ConsultarCreditoResponse> responseConsultarCredito = (JAXBElement<ConsultarCreditoResponse>) cliente
				.callWebServiceConsultaCliente(requestConsultarCredito);
		saveRequestResponse(new TcSistemas(SAFiN),
				com.telcel.gam.siev.util.SievUtil.getRequestResponse(requestConsultarCredito,
						RequestResponseType.CONSULTAR_CREDITO_REQUEST.getValor(), cliente),
				com.telcel.gam.siev.util.SievUtil.getRequestResponse(responseConsultarCredito,
						RequestResponseType.CONSULTAR_CREDITO_RESPONSE.getValor(), cliente),
				MethodWsType.CONSULTAR_CREDITO_METHOD.getMetodo());
		responseWS = com.telcel.gam.siev.util.SievResponseUtil.getResponseConsultarCredito(responseConsultarCredito);
		// *********************************************
		// Consulta el ws para el metodo Ofertar Cliente
		// *********************************************
		OfertarCliente ofertarCliente = com.telcel.gam.siev.util.SievUtil.getOfertarClientePetType(sievPojo);
		JAXBElement<OfertarCliente> requestOfertarCliente = of.createOfertarCliente(ofertarCliente);
		JAXBElement<OfertarClienteResponse> responseOfertaCliente = (JAXBElement<OfertarClienteResponse>) cliente
				.callWebServiceOfertaCliente(requestOfertarCliente);
		saveRequestResponse(new TcSistemas(SAFiN),
				com.telcel.gam.siev.util.SievUtil.getRequestResponse(requestOfertarCliente,
						RequestResponseType.OFERTAR_CLIENTE_REQUEST.getValor(), cliente),
				com.telcel.gam.siev.util.SievUtil.getRequestResponse(responseConsultarCredito,
						RequestResponseType.OFERTAR_CLIENTE_RESPONSE.getValor(), cliente),
				MethodWsType.OFERTAR_CLIENTE_METHOD.getMetodo());
		responseWS = responseWS
				+ com.telcel.gam.siev.util.SievResponseUtil.getResponseOfertaCliente(responseOfertaCliente);
		// ***********************************************
		// Consulta el ws para el metodo Recalcular Oferta
		// ***********************************************
		RecalcularOferta recalcularOferta = com.telcel.gam.siev.util.SievUtil.getRecalcularOferta(sievPojo);
		JAXBElement<RecalcularOferta> requestRecalcularOferta = of.createRecalcularOferta(recalcularOferta);
		JAXBElement<RecalcularOfertaResponse> responseRecalcularOferta = (JAXBElement<RecalcularOfertaResponse>) cliente
				.callWebServiceRecalcularOferta(requestRecalcularOferta);
		saveRequestResponse(new TcSistemas(SAFiN),
				com.telcel.gam.siev.util.SievUtil.getRequestResponse(requestRecalcularOferta,
						RequestResponseType.RECALCULAR_OFERTA_REQUEST.getValor(), cliente),
				com.telcel.gam.siev.util.SievUtil.getRequestResponse(responseRecalcularOferta,
						RequestResponseType.RECALCULAR_OFERTA_RESPONSE.getValor(), cliente),
				MethodWsType.RECALCULAR_OFERTA_METHOD.getMetodo());
		responseWS = responseWS
				+ com.telcel.gam.siev.util.SievResponseUtil.getResponseRecalcularOferta(responseRecalcularOferta);

		context.close();

		return "/sievpage.xhtml?faces-redirect=true";
	}

	/*************************** Getter y setters ******************************/

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

	public List<TcTipoPlan> getListaTipoPlan() {
		return listaTipoPlan;
	}

	public void setListaTipoPlan(List<TcTipoPlan> listaTipoPlan) {
		this.listaTipoPlan = listaTipoPlan;
	}

	public List<TcTipoPlazo> getListaTipoPlazo() {
		return listaTipoPlazo;
	}

	public void setListaTipoPlazo(List<TcTipoPlazo> listaTipoPlazo) {
		this.listaTipoPlazo = listaTipoPlazo;
	}

	public List<TcCredcheckCanalesVenta> getListaCanalesVenta() {
		return listaCanalesVenta;
	}

	public void setListaCanalesVenta(List<TcCredcheckCanalesVenta> listaCanalesVenta) {
		this.listaCanalesVenta = listaCanalesVenta;
	}

	public List<TcPlan> getListaPlan() {
		return listaPlan;
	}

	public void setListaPlan(List<TcPlan> listaPlan) {
		this.listaPlan = listaPlan;
	}

	public List<TcSafinMovimientos> getListaMovimientos() {
		return listaMovimientos;
	}

	public void setListaMovimientos(List<TcSafinMovimientos> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}

	public List<TcSafinSistemas> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<TcSafinSistemas> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	public List<TcSafinTiposProducto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<TcSafinTiposProducto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
