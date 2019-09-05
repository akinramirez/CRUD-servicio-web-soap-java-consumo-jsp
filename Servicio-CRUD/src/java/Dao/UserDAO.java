package Dao;

import conexion.Conexion;
import Interfaces.ICRUD;
import Modelos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akin Ramirez
 */
public class UserDAO implements ICRUD {

  PreparedStatement ps;
  ResultSet rs;
  Connection con;
  Conexion conex = new Conexion();
  int respuesta;
  String mensaje;

  @Override
  public List listar() {
    List<User> listaUsuarios = new ArrayList<>();
    String sql = "SELECT * FROM USER";

    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        User usr = new User();
        usr.setId(rs.getInt("id"));
        usr.setFname(rs.getString("fname"));
        usr.setLname(rs.getString("lname"));
        listaUsuarios.add(usr);
      }
    } catch (Exception e) {
    }
    return listaUsuarios;
  }

  @Override
  public User listarID(int id) {
    String sql = "SELECT * FROM USER WHERE ID = ?";
    User usr = new User();
    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      rs = ps.executeQuery();

      while (rs.next()) {
        usr.setId(rs.getInt("id"));
        usr.setFname(rs.getString("fname"));
        usr.setLname(rs.getString("lname"));
      }
    } catch (Exception e) {
    }
    return usr;
  }

  @Override
  public String add(String nombre, String apellido) {
    String sql = "INSERT INTO USER(FNAME, LNAME) VALUES (?,?)";
    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, nombre);
      ps.setString(2, apellido);
      respuesta = ps.executeUpdate();
      if (respuesta == 1) {
        mensaje = "USUARIO AGREGADO";
      } else {
        mensaje = "ERROR!";
      }
    } catch (Exception e) {

    }
    return mensaje;
  }

  @Override
  public String edit(int id, String nombre, String apellido) {
    String sql = "UPDATE USER SET FNAME = ?, LNAME = ? WHERE ID =?";
    User usr = new User();
    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, nombre);
      ps.setString(2, apellido);
      ps.setInt(3, id);
      respuesta = ps.executeUpdate();
      if (respuesta == 1) {
        mensaje = "USUARIO ACTUALIZADO";
      } else {
        mensaje = "ERROR!";
      }
    } catch (Exception e) {

    }
    return mensaje;

  }

  @Override
  public String delete(int id) {
    String mensaje = "";
    String sql = "DELETE FROM USER WHERE ID = ?";
    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      respuesta = ps.executeUpdate();
      mensaje = "USUARIO ELIMINADO";
    } catch (Exception ex) {
      mensaje = "ERROR! " + ex.getMessage();
    }
    return mensaje;
  }

}
