/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.casoexamen.dao;

import java.util.List;
import pe.edu.upeu.casoexamen.model.Usuario;
/**
 *
 * @author USUARIO
 */
public interface UsuarioDao {
    int create(Usuario user);
    int update(Usuario user);
    int delete(int id);
    Usuario read(int id);
    List<Usuario>readAll();
}
