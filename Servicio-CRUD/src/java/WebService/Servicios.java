package WebService;

import Modelos.User;
import Dao.UserDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Servicios")
public class Servicios {

  UserDAO daoUsuario = new UserDAO();

  @WebMethod(operationName = "listar")
  public List<User> listar() {
    List datos = daoUsuario.listar();
    return datos;
  }

  @WebMethod(operationName = "agregar")
  public String agregar(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos) {
    String datos = daoUsuario.add(nombres, apellidos);
    return datos;
  }

  @WebMethod(operationName = "listarID")
  public User listarID(@WebParam(name = "id") int id) {
    User user = daoUsuario.listarID(id);
    return user;
  }

  @WebMethod(operationName = "actualizar")
  public String actualizar(@WebParam(name = "id") int id, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos) {
    String datos = daoUsuario.edit(id, nombres, apellidos);
    return datos;
  }

  @WebMethod(operationName = "eliminar")
  public String eliminar(@WebParam(name = "id") int id) {
    String datos = daoUsuario.delete(id);
    return datos;
  }
}
