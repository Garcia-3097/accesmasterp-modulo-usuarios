package accesmasterp;
//importar el paquete de java.sql 
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accesmasterp {

public static void main(String[] args) {
    //DEFINIR VARIABLES DE ALMACENAMIENTO
    String usuario = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/accesmasterp";
    Connection conexion; 
    Statement st;
    ResultSet rs;
    try {
        //CREAR UNA CONEXION PARA CAPTURAR LOS DATOS
        conexion = DriverManager.getConnection(url, usuario, password);
        
        //CONSULTA DE DATOS
        st = conexion.createStatement();
        /*rs = st.executeQuery("SELECT *FROM USUARIOS");
        rs.next();
        do{
        System.out.println(rs.getInt("id") + " : " + rs.getString("correo_usu"));
        }while(rs.next()); */
        
        //INSERCION DE DATOS 
        st.executeUpdate("INSERT INTO USUARIOS (cedula_usu, correo_usu, contraseña_usu, roll_usu) VALUES (987654323, 'pruebadesdejava3@gmail.com', 'pruebacontrajava3', 'Usuario estandar')");
        rs = st.executeQuery("SELECT * FROM usuarios");
        rs.next();
        do{
        System.out.println(rs.getInt("id") + " : " +rs.getNString("correo_usu"));
        }while(rs.next());
        
        //ACTUALIZACION DE DATOS 
        /*st.executeUpdate("UPDATE usuarios SET correo_usu='pruebadesdejava4@gmail.com' WHERE id=5");
        System.out.println(" ");
        rs = st.executeQuery("SELECT * FROM usuarios");
        rs.next();
        do{
        System.out.println(rs.getInt("id") + " : " +rs.getNString("correo_usu"));
        }while(rs.next());*/
        
        //ELIMINAR DATOS 
        st.executeUpdate("DELETE FROM usuarios WHERE id=4");
        System.out.println(" ");
        rs = st.executeQuery("SELECT * FROM usuarios");
        rs.next();
        do{
        System.out.println(rs.getInt("id") + " : " +rs.getNString("correo_usu"));
        }while(rs.next());
        
    } catch (SQLException ex) {
        Logger.getLogger(Accesmasterp.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Accesmasterp.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
}
