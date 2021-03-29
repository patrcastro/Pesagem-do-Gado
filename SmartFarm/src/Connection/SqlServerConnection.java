package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnection {
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //Alterar a string abaixo
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;dataBaseName=SmartFarm;user=user;password=user1234;");
        return con;    
        }
    
    public static boolean testarConexao()
    {        
        try {
            SqlServerConnection SqlCon = new SqlServerConnection();
            Connection con = SqlCon.getConnection();
            if(con != null){
                System.out.println("Sucesso : Conectou no banco");
                return true;
            }else
                return false;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally            
        {
            System.out.println("Teste Finalizado");
        }
    }
}