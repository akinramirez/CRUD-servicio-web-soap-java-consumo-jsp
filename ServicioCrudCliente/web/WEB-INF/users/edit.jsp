<%-- 
    Document   : add
    Created on : 01-sep-2019, 7:42:18
    Author     : Akin Ramirez
--%>
<%@page import="java.util.List"%>
<%@page import="webservice.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </head>
  <%
    User user = (User) request.getAttribute("usuario");
  %>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"> 
          <div class="card">
            <div class="card-header">
              <h6>Actualizar Usuario</h6>
            </div>
            <div class="card-body">
              <form role="form" action="user" method="post">
                <input type="hidden" name="accion" value="actualizar">
                <input type="hidden" name="idUser" value="<%= user.getId()%>">
                <label>Nombres</label>
                <input type="text" name="txtNombres" class="form-control form-control-sm" value="<%= user.getFname()%>" autocomplete="off">
                <label>Apellidos</label>
                <input type="text" name="txtApellidos" class="form-control form-control-sm" value="<%= user.getLname()%>" autocomplete="off">
                <br>
                <a href="user" class="btn btn-secondary btn-sm">Regresar</a>
                <button type="submit" class="btn btn-success btn-sm">Guardar</button>
              </form>
            </div>
          </div>      
        </div>
      </div>
    </div>
  </body>
</html>
