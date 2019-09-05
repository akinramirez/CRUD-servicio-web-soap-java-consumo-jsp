package Interfaces;

import Modelos.User;
import java.util.List;

/**
 *
 * @author Akin Ramirez
 */
public interface ICRUD {
  public List listar();
  
  public User listarID(int i);
  
  public String add(String nombre, String apellido);
  
  public String edit(int id, String nombre, String apellido);
  
  public String delete(int id); 
  
}
