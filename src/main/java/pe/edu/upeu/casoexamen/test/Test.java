
package pe.edu.upeu.casoexamen.test;

import com.google.gson.Gson;
import pe.edu.upeu.casoexamen.config.Conexion;
import pe.edu.upeu.casoexamen.dao.PostDao;
import pe.edu.upeu.casoexamen.dao.UsuarioDao;
import pe.edu.upeu.casoexamen.daoImpl.PostDaoImpl;
import pe.edu.upeu.casoexamen.daoImpl.UsuarioDaoImpl;

public class Test {
    static Gson gson = new Gson();
    static PostDao p = new PostDaoImpl();
    static UsuarioDao udao = new UsuarioDaoImpl();
    
    public static void main(String[] args){
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("No Conectado");
        }
        System.out.println(gson.toJson(p.readAll()));
        System.out.println(gson.toJson(udao.readAll2()));
    }
}
