package Controlador;

import DaoServicio.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.User;

@WebServlet(name = "UserControllers", urlPatterns = {"/user"})
public class UserControllers extends HttpServlet {

  UserService userService = new UserService();
  private String accion;
  private int idUser;
  private String nombres;
  private String apellidos;
  private String mensaje;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    this.accion = request.getParameter("accion") == null ? "listar" : request.getParameter("accion");

    switch (this.accion) {
      case "listar":
        List<User> listaUsuarios = userService.listar();
        request.setAttribute("usuarios", listaUsuarios);
        request.getRequestDispatcher("/WEB-INF/users/index.jsp").forward(request, response);
        break;
      case "agregar":
        request.getRequestDispatcher("/WEB-INF/users/add.jsp").forward(request, response);
        break;
      case "insertar":
        this.nombres = request.getParameter("txtNombres");
        this.apellidos = request.getParameter("txtApellidos");
        this.mensaje = userService.agregar(nombres, apellidos);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("user");
        break;
      case "mostrar":
        this.idUser = Integer.parseInt(request.getParameter("id"));
        User usuario = userService.listarID(idUser);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/WEB-INF/users/edit.jsp").forward(request, response);
        break;
      case "actualizar":
        this.idUser = Integer.parseInt(request.getParameter("idUser"));
        this.nombres = request.getParameter("txtNombres");
        this.apellidos = request.getParameter("txtApellidos");
        this.mensaje = userService.actualizar(idUser, nombres, apellidos);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("user");
        break;
      case "eliminar":
        this.idUser = Integer.parseInt(request.getParameter("id"));
        this.mensaje = userService.eliminar(idUser);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("user");
        break;
      default:
        break;
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

}
