/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.casoexamen.ws;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.casoexamen.dao.PostDao;
import pe.edu.upeu.casoexamen.dao.UsuarioDao;
import pe.edu.upeu.casoexamen.daoImpl.PostDaoImpl;
import pe.edu.upeu.casoexamen.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.casoexamen.model.Usuario;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "Usuario2WebService")
public class Usuario2WebService {
   private UsuarioDao udao=new UsuarioDaoImpl();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "create")
    public int create (@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol, @WebParam(name = "fechacreacion") String fechacreacion, @WebParam(name = "estado") boolean estado) {
        return udao.create(new Usuario(0,username,password,idpersona,idrol,fechacreacion,estado));
    }
    
    @WebMethod(operationName = "update")
    public int update(@WebParam(name = "idusuario") int idusuario, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "idrol") int idrol, @WebParam(name = "idpersona") int idpersona, @WebParam(name = "fechacreacion") String fechacreacion, @WebParam(name = "estado") boolean estado) {
        //TODO write your implementation code here:
        return udao.update(new Usuario(idusuario,username,password,idrol,idpersona,fechacreacion,estado));
    }
    
    @WebMethod(operationName = "delete")
    public int delete(@WebParam(name = "idusuario") int idusuario){
        return udao.delete(idusuario);
    }
    
    @WebMethod(operationName = "read")
    public Usuario read(@WebParam(name = "id") int idusuario) {
        //TODO write your implementation code here:
        return udao.read(idusuario);
    }
    
    @WebMethod(operationName = "readAll")
    public List<Usuario> readAll() {
        //TODO write your implementation code here:
        return udao.readAll();
    }

    
}
