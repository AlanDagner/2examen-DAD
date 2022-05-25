package pe.edu.upeu.casoexamen.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    private static final String URL="jdbc:postgresql://ec2-44-194-117-205.compute-1.amazonaws.com:5432/d1s8hleqtlgp9o";
    private static final String USER="zligbblqcuogqm";
    private static final String PASS="70823aee833da61d98a67391254ebe123949508d4819a6edf86c55fbc2dbcd26";
    private static final String DRIVER ="org.postgresql.Driver";
    private static Connection cx = null;
    
    public static Connection getConexion(){
        try {
                Class.forName(DRIVER);
                if(cx==null){
                        cx = DriverManager.getConnection(URL, USER, PASS);
                }
        } catch (Exception e) {
                System.out.println(e);
        }
        return cx;
    }
}