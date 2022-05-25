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
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
}
