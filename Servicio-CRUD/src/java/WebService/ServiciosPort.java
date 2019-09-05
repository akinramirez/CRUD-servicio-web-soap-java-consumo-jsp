/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Akin Ramirez
 */
@Path("serviciosport")
public class ServiciosPort {

  private WebService_client.Servicios port;

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of ServiciosPort
   */
  public ServiciosPort() {
    port = getPort();
  }

  /**
   * Invokes the SOAP method listar
   * @return an instance of javax.xml.bind.JAXBElement<WebService_client.ListarResponse>
   */
  @GET
  @Produces("application/xml")
  @Consumes("text/plain")
  @Path("listar/")
  public JAXBElement<WebService_client.ListarResponse> getListar() {
    try {
      // Call Web Service Operation
      if (port != null) {
        java.util.List<WebService_client.User> result = port.listar();

        class ListarResponse_1 extends WebService_client.ListarResponse {

          ListarResponse_1(java.util.List<WebService_client.User> _return) {
            this._return = _return;
          }
        }
        WebService_client.ListarResponse response = new ListarResponse_1(result);
        return new WebService_client.ObjectFactory().createListarResponse(response);
      }
    } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    return null;
  }

  /**
   * Invokes the SOAP method listarID
   * @param id resource URI parameter
   * @return an instance of javax.xml.bind.JAXBElement<WebService_client.User>
   */
  @GET
  @Produces("application/xml")
  @Consumes("text/plain")
  @Path("listarid/")
  public JAXBElement<WebService_client.User> getListarID(@QueryParam("id")
          @DefaultValue("0") int id) {
    try {
      // Call Web Service Operation
      if (port != null) {
        WebService_client.User result = port.listarID(id);
        return new JAXBElement<WebService_client.User>(new QName("http//WebService_client/", "user"), WebService_client.User.class, result);
      }
    } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    return null;
  }

  /**
   * Invokes the SOAP method agregar
   * @param nombres resource URI parameter
   * @param apellidos resource URI parameter
   * @return an instance of java.lang.String
   */
  @GET
  @Produces("text/plain")
  @Consumes("text/plain")
  @Path("agregar/")
  public String getAgregar(@QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos) {
    try {
      // Call Web Service Operation
      if (port != null) {
        java.lang.String result = port.agregar(nombres, apellidos);
        return result;
      }
    } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    return null;
  }

  /**
   * Invokes the SOAP method eliminar
   * @param id resource URI parameter
   * @return an instance of java.lang.String
   */
  @GET
  @Produces("text/plain")
  @Consumes("text/plain")
  @Path("eliminar/")
  public String getEliminar(@QueryParam("id")
          @DefaultValue("0") int id) {
    try {
      // Call Web Service Operation
      if (port != null) {
        java.lang.String result = port.eliminar(id);
        return result;
      }
    } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    return null;
  }

  /**
   * Invokes the SOAP method actualizar
   * @param id resource URI parameter
   * @param nombres resource URI parameter
   * @param apellidos resource URI parameter
   * @return an instance of java.lang.String
   */
  @GET
  @Produces("text/plain")
  @Consumes("text/plain")
  @Path("actualizar/")
  public String getActualizar(@QueryParam("id")
          @DefaultValue("0") int id, @QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos) {
    try {
      // Call Web Service Operation
      if (port != null) {
        java.lang.String result = port.actualizar(id, nombres, apellidos);
        return result;
      }
    } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    return null;
  }

  /**
   *
   */
  private WebService_client.Servicios getPort() {
    try {
      // Call Web Service Operation
      WebService_client.Servicios_Service service = new WebService_client.Servicios_Service();
      WebService_client.Servicios p = service.getServiciosPort();
      return p;
    } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    return null;
  }
}
