

package Entity;
import ConManager.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class UserLogin extends connection {

  public Integer checkUser(String username,String pass) {
        String value="";
        PreparedStatement Ps = null;
        ResultSet _rs = null;
        Connection _con;
   int ret=0;

    //  String _select = "SELECT * From tblBook  where ? like '" + "?%'"  ;
        String str = "SELECT * From tbl_user where UserName=? and PassWord=? "  ;
        try {
           _con=getConnection();
            Ps = _con.prepareStatement(str);
             Ps.setString(1, username);
              Ps.setString(2, pass);

            _rs = Ps.executeQuery();
            if (_rs.next())
            {ret=1;
           // connection.strUser=username;
            }
            
             _rs.close();
        } catch (Exception ex) {
          //  ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            value="";
        }

return ret;

    }
  //
//   public Integer checkUserPrivilage(String username) {
//        String value="";
//        PreparedStatement Ps = null;
//        ResultSet _rs = null;
//        Connection _con;
//
//
//    
//        String _select = "SELECT * From TBL_PRIVILAGE  where USERNAME=? "  ;
//        try {
//           _con=getConnection();
//            Ps = _con.prepareStatement(_select);
//             Ps.setString(1, username);
//
//            _rs = Ps.executeQuery();
//            if (_rs.next())
//               return 1;
//
//
//             _rs.close();
//        } catch (Exception ex) {
//          //  ErrorLogWriter.writeError(ex);
//            ex.printStackTrace();
//            value="";
//        }
//
//return 0;
//
//    }
 public Integer UserChange(String username,String pass) {
     
        PreparedStatement Ps = null;
        ResultSet _rs = null;
        Connection _con;


    //  String _select = "SELECT * From tblBook  where ? like '" + "?%'"  ;
        String _select = "Update  TBL_USER set  PASSWORD =? where USERNAME=? "  ;
        try {
           _con=getConnection();
            Ps = _con.prepareStatement(_select);
             Ps.setString(1, pass);
              Ps.setString(2, username);

        return     Ps.executeUpdate();

            
             
        } catch (Exception ex) {
          //  ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            
        }

return 0;

    }
public String [] readTable(String user)  {


    String select = "SELECT * from tbl_user  WHERE  UserName = '" +user + "'" ;
        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(select);
        
            rs = ps.executeQuery();
              String[] row = new String[2];
            if (rs.next()) {
                row[0] = rs.getString("FullName");
                row[1] = rs.getString("UserType");
  
                
            }

            return row;

        } catch (Exception ex) {
                ex.printStackTrace();
    }
        return null;
}
 public Integer checkCon() {
     
        PreparedStatement Ps = null;
        ResultSet _rs = null;
        Connection _con;

  int ret=1;
    //  String _select = "SELECT * From tblBook  where ? like '" + "?%'"  ;
        String _select = "SELECT * from tbl_user "  ;
        try {
           _con=getConnection();
            Ps = _con.prepareStatement(_select);
          
            _rs= Ps.executeQuery();
            if(_rs.next())
                ret=1;
            else
                ret=0;
                
           
             
        } catch (Exception ex) {
          //  ErrorLogWriter.writeError(ex);
            //ex.printStackTrace();
            ret= 0;
        }

return ret;

    }
}
