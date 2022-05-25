/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.casoexamen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.casoexamen.config.Conexion;
import pe.edu.upeu.casoexamen.dao.UsuarioDao;
import pe.edu.upeu.casoexamen.model.Usuario;

/**
 *
 * @author USUARIO
 */
public class UsuarioDaoImpl implements UsuarioDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int create(Usuario user) {
        int x = 0;
        String SQL="Insert into usuarios(username, password,) values(?,?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            x = ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Usuario user) {
        int x = 0;
        String SQL="update usuarios set username=?, password=? where idusuario=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdusuario());
            x = ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL="delete from usuarios where idusuario=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Usuario read(int id) {
        Usuario p = new Usuario();
        String SQL ="select *from where idusuario=?"; 
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt (1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setIdusuario(rs.getInt("idusuario"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }
        return p;
    }
    @Override
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<>();
        String SQL="Select *from usuarios";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario p = new Usuario();
                p.setIdusuario(rs.getInt("idusuario"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("pasword"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }

        return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2() {     
        List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "select u.idusuario, u.username, p.apellidos, p.nombres, r.nombre from usuarios as u " +
                     "inner join roles as r on u.idrol = r.idrol " +
                     "inner join personas as p on u.idpersona =p.idpersona";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("idusuario",rs.getInt("idusuario"));
                map.put("username",rs.getString("username"));
                map.put("apellidos",rs.getString("apellidos"));
                map.put("nombres",rs.getString("nombres"));
                map.put("rol",rs.getString("nombre"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
