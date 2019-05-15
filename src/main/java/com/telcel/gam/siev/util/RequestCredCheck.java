/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.util;

import com.telcel.gam.siev.pojos.SievPojo;

/**
 *
 * @author VI8G01R
 */
public class RequestCredCheck {

    public static String getRequestCreditCheck(SievPojo sievPojo) {

        StringBuilder requestCredCheck = new StringBuilder();
//        String CAMPO = "";

        requestCredCheck.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.ccsws.dapmov.gsac.sds.di.telcel.com.mx/\">\n");
        requestCredCheck.append("   <soapenv:Header/>\n");
        requestCredCheck.append("   <soapenv:Body>\n");
        requestCredCheck.append("      <ws:evaluacionTramite>\n");
        requestCredCheck.append("         <!--Optional:-->\n");
        requestCredCheck.append("         <xml><![CDATA[\n");
        requestCredCheck.append("           <evaluacionTramite>\n");
        requestCredCheck.append("               <controlData>\n");
        requestCredCheck.append("                  <messageUUID>" + "" + "</messageUUID>\n");
        requestCredCheck.append("                  <requestDate>" + "" + "</requestDate>\n");
        requestCredCheck.append("                  <sendBy>" + "" + "</sendBy>\n");
        requestCredCheck.append("                  <version>" + "" + "</version>\n");
        requestCredCheck.append("                  <ipClient>" + "" + "</ipClient>\n");
        requestCredCheck.append("                  <ipServer>" + "" + "</ipServer>\n");
        requestCredCheck.append("                  <user>" + "" + "</user>\n");
        requestCredCheck.append("               </controlData>\n");
        requestCredCheck.append("               <peticion>\n");
        requestCredCheck.append("                  <accesoWS>\n");
        requestCredCheck.append("                     <clave>" + "" + "</clave>\n");
        requestCredCheck.append("                     <usuario>" + "" + "</usuario>\n");
        requestCredCheck.append("                  </accesoWS>\n");
        requestCredCheck.append("                  <informacionBasica>\n");
        requestCredCheck.append("                     <tipoPersona>" + sievPojo.getTipoPersona() + "</tipoPersona>\n");
        requestCredCheck.append("                     <tipoLinea>" + sievPojo.getTipoLinea() + "</tipoLinea>\n");
        requestCredCheck.append("                     <tipoPlan>" + sievPojo.getTipoPlan() + "</tipoPlan>\n");
        requestCredCheck.append("                     <tipoPlazo>" + sievPojo.getTipoPlazo() + "</tipoPlazo>\n");
        requestCredCheck.append("                     <tipoTramite>" + sievPojo.getTipoTramite() + "</tipoTramite>\n");
        requestCredCheck.append("                     <marca>" + sievPojo.getMarca() + "</marca>\n");
        requestCredCheck.append("                     <fuerzaVenta>" + sievPojo.getFuerzaVenta() + "</fuerzaVenta>\n");
        requestCredCheck.append("                     <proyecto>" + sievPojo.getProyecto() + "</proyecto>\n");
        requestCredCheck.append("                     <formaPago>" + sievPojo.getFormaPago() + "</formaPago>\n");
        requestCredCheck.append("                     <modelo>" + sievPojo.getModelo() + "</modelo>\n");
        requestCredCheck.append("                     <canalVenta>" + sievPojo.getCanalVenta() + "</canalVenta>\n");
        requestCredCheck.append("                     <mercado>" + sievPojo.getMercado() + "</mercado>\n");
        requestCredCheck.append("                     <modalidadInves>" + sievPojo.getModalidadInvestigacion() + "</modalidadInves>\n");
        requestCredCheck.append("                     <region>" + com.telcel.gam.siev.util.SievUtil.getRegionBySistema(sievPojo.getRegion(), 1) + "</region>\n");
        requestCredCheck.append("                     <ventaPlazos>" + sievPojo.getParcialidades() + "</ventaPlazos>\n");
        requestCredCheck.append("                  </informacionBasica>\n");
        requestCredCheck.append("                  <solicitud>\n");
        requestCredCheck.append("                     <datosCliente>\n");
        requestCredCheck.append("                        <razonSocial>" + sievPojo.getRazonSocial() + "</razonSocial>\n");
        requestCredCheck.append("                        <nombre>" + sievPojo.getNombre() + "</nombre>\n");
        requestCredCheck.append("                        <apellidoPaterno>" + sievPojo.getApellidoPaterno() + "</apellidoPaterno>\n");
        requestCredCheck.append("                        <apellidoMaterno>" + sievPojo.getApellidoMaterno() + "</apellidoMaterno>\n");
        requestCredCheck.append("                        <fechaNacimiento>" + sievPojo.getFechaNacimiento() + "</fechaNacimiento>\n");
        requestCredCheck.append("                        <sexo>" + sievPojo.getSexo() + "</sexo>\n");
        requestCredCheck.append("						 <rfc>" + sievPojo.getRfc() + "</rfc>\n");
        requestCredCheck.append("                        <estado>" + sievPojo.getEstado() + "</estado>\n");
        requestCredCheck.append("                        <delegacionMunicipio>" + sievPojo.getDelegacionMunicipio() + "</delegacionMunicipio>\n");
        requestCredCheck.append("                        <calle>" + sievPojo.getCalle() + "</calle>\n");
        requestCredCheck.append("                        <numExterior>" + sievPojo.getNumeroExterior() + "</numExterior>\n");
        requestCredCheck.append("                        <coloniaPoblacion>" + sievPojo.getColoniaPoblacion() + "</coloniaPoblacion>\n");
        requestCredCheck.append("                        <ciudad>" + sievPojo.getCiudad() + "</ciudad>\n");
        requestCredCheck.append("                        <codigoPostal>" + sievPojo.getCodigoPostal() + "</codigoPostal>\n");
        requestCredCheck.append("                        <telefonoCasa>" + sievPojo.getTelefonoCasa() + "</telefonoCasa>\n");
        requestCredCheck.append("                        <telefonoOficina>" + sievPojo.getTelefonoOficina() + "</telefonoOficina>\n");
        requestCredCheck.append("                        <telefonoReferencia>" + sievPojo.getTelefonoReferencia() + "</telefonoReferencia>\n");
        requestCredCheck.append("                        <nombreReferencia>" + sievPojo.getNombreReferencia() + "</nombreReferencia>\n");
        requestCredCheck.append("                        <creditoAutomotriz>" + sievPojo.getCreditoAutomotriz() + "</creditoAutomotriz>\n");
        requestCredCheck.append("                        <creditoBancario>" + sievPojo.getCreditoBancario() + "</creditoBancario>\n");
        requestCredCheck.append("                        <tarjetaCredito>" + sievPojo.getTarjetaCredito() + "</tarjetaCredito>\n");
        requestCredCheck.append("                        <vigenciaTarjeta>" + sievPojo.getVigenciaTarjeta() + "</vigenciaTarjeta>\n");
        requestCredCheck.append("                        <claveBanco>" + sievPojo.getClaveBanco() + "</claveBanco>\n");
        requestCredCheck.append("                        <digitosTC>" + sievPojo.getDigitosTC() + "</digitosTC>\n");
        requestCredCheck.append("                        <cvv>" + sievPojo.getCvv() + "</cvv>\n");
        requestCredCheck.append("                        <folioSistema>" + sievPojo.getFolioSistema() + "</folioSistema>\n");
        requestCredCheck.append("			 <idSistema>" + sievPojo.getIdSistema() + "</idSistema>\n");
        requestCredCheck.append("			 <userBC>" + ""+ "</userBC>\n");
        requestCredCheck.append("			 <passBC>" + "" + "</passBC>\n");
        requestCredCheck.append("                     </datosCliente>\n");
        requestCredCheck.append("                     <datosEquipo>\n");
        requestCredCheck.append("                        <depositoInicial>" + sievPojo.getDepositoInicial() + "</depositoInicial>\n");
        requestCredCheck.append("                        <renta>" + sievPojo.getRenta() + "</renta>\n");
        requestCredCheck.append("                        <montoServicio>" + sievPojo.getMontoServicio() + "</montoServicio>\n");
        requestCredCheck.append("                        <precioLista>" + sievPojo.getPrecioLista() + "</precioLista>\n");
        requestCredCheck.append("                        <precioKit>" + sievPojo.getPrecioKit() + "</precioKit>\n");
        requestCredCheck.append("                        <anticipo>" + sievPojo.getAnticipo() + "</anticipo>\n");
        requestCredCheck.append("                        <costoBaseEquipo>" + sievPojo.getCostoBaseEquipo() + "</costoBaseEquipo>\n");
        requestCredCheck.append("                        <numParcialidades>" + sievPojo.getParcialidades() + "</numParcialidades>\n");
        requestCredCheck.append("                        <sobrePrecio>" + sievPojo.getSobreprecio() + "</sobrePrecio>			\n");
        requestCredCheck.append("                     </datosEquipo>\n");
        requestCredCheck.append("                  </solicitud>\n");
        requestCredCheck.append("               </peticion>\n");
        requestCredCheck.append("            </evaluacionTramite>]]> \n");
        requestCredCheck.append("            </xml>\n");
        requestCredCheck.append("      </ws:evaluacionTramite>\n");
        requestCredCheck.append("   </soapenv:Body>\n");
        requestCredCheck.append("</soapenv:Envelope>\n");
        
        return requestCredCheck.toString();
    }
    
    
}
