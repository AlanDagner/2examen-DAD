/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.casoexamen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.casoexamen.config.Conexion;
import pe.edu.upeu.casoexamen.dao.PostDao;
import pe.edu.upeu.casoexamen.model.Post;

/**
 *
 * @author USUARIO
 */
public class PostDaoImpl implements PostDao {
    private PreparedStatement ps;
    private ResultSet rs; 
    private Connection cx;
    @Override
    public int create(Post post) {
        int x = 0;
        String SQL="Insert into post(titulo, descripción) values(?,?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, post.getTitulo());
            ps.setString(2, post.getDescripcion());
            x = ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Post post) {
        int x = 0;
        String SQL="update post set titulo=?, descripción=? where idpost=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, post.getTitulo());
            ps.setString(2, post.getDescripcion());
            ps.setInt(3, post.getIdpost());
            x = ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL="delete from post where idpost=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Post read(int id) {
        Post p = new Post();
        String SQL ="select *from where idpost=?"; 
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt (1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setIdpost(rs.getInt("idpost"));
                p.setTitulo(rs.getString("titulo"));
                p.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }
        return p;
    }

    @Override
    public List<Post> readAll() {
        List<Post> lista = new ArrayList<>();
        String SQL="Select *from post";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Post p = new Post();
                p.setIdpost(rs.getInt("idpost"));
                p.setTitulo(rs.getString("titulo"));
                p.setDescripcion(rs.getString("descripcion"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return lista;
    }
    
}
