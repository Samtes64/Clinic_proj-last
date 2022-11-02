
package ConManager;



import java.sql.Connection;
import java.sql.DriverManager;


public class connection {
    
    static public String strUser; 
    
 public Connection getConnection() {
           Connection conn = null;
           try{
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               if(conn==null)  conn= DriverManager.getConnection("jdbc:sqlserver://SAMMY\\SQLEXPRESS; databaseName=db_clinic;integratedSecurity=true;" +
                       "trustServerCertificate=true;IntegratedSecurity=true;");
          
               }


            catch (Exception ex) {
              ex.printStackTrace();

           }
        return conn;
    }
    


}

