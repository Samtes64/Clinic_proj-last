

package Entity;

import ConManager.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;




public class UserClass extends connection{

   Connection _con;
    public int insertUser(String Id,String UserName,String FullName,String MobileNo,String UserType,String PassWord,String Status){

    String user=this.strUser;
    String select = "insert into tbl_user(ID, UserName, FullName, MobileNo, UserType, PassWord, Status,InsertedBy) values (  '" +Id +
                    
     "','" + UserName +"','" + FullName + "','" +  MobileNo +"','" + UserType +"','" + PassWord +"','"+   Status + "','"+ user +"')";
    
              



        try {
              _con=getConnection();
             
    System.out.println(select);
            PreparedStatement ps = _con.prepareStatement(select);
//            ps.setString(1, Id);
//             ps.setString(2, UserName);
//              ps.setString(3, FullName);
//               ps.setString(4, MobileNo);
//                ps.setString(5, UserType);
//                 ps.setString(6, PassWord);
//                  ps.setString(7, Status);
//                  ps.setString(8, this.strUser);
                  
                   return ps.executeUpdate();
                
      } catch (Exception ex) {
                ex.printStackTrace();
    }
        return 0;
}
 public int updateUser(String Id,String UserName,String FullName,String MobileNo,String UserType,String PassWord,String Status){

    String user=this.strUser;
    //String select = "update tbl_user set (ID, UserName, FullName, MobileNo, UserType, PassWord, Status,InsertedBy) values (  " +
     String select="update tbl_user set MobileNo='"+MobileNo + "' ,UserType='" + UserType + "' ,PassWord ='" + PassWord + "' ,Status='"+Status+ "' where ID='" + Id +"'"; 
    
        try {
              _con=getConnection();
             
            
            PreparedStatement ps = _con.prepareStatement(select);
//            ps.setString(1, Id);
//             ps.setString(2, UserName);
//              ps.setString(3, FullName);
//               ps.setString(4, MobileNo);
//                ps.setString(5, UserType);
//                 ps.setString(6, PassWord);
//                  ps.setString(7, Status);
//                  ps.setString(8, this.strUser);
                  
                   return ps.executeUpdate();
                
      } catch (Exception ex) {
                ex.printStackTrace();
    }
        return 0;
}

public String[] getUser(String str)  {

   String[] row = new String[6];
   String select="select * from tbl_user where UserName = '"+str + "'" ;
        try {
            Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(select);
            rs=  ps.executeQuery();

            if(rs.next())
   {

     
        row[0] = rs.getString("Id");
        row[1] = rs.getString("UserName");
        row[2] = rs.getString("FullName");
        row[3] = rs.getString("MobileNo");
        row[4] = rs.getString("UserType");
         row[5] = rs.getString("Status");
        


}
    return row;
        } catch (Exception ex) {
                ex.printStackTrace();
    }
        return null;
}
public DefaultTableModel ReadUserTable(String sql)  {
    
    

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("FullName");
        model.addColumn("MobileNo");
        model.addColumn("PassWord");
        model.addColumn("Status");
        model.addColumn("UserName");
        model.addColumn("UserType");
        
    
        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, emp_id);
            rs = ps.executeQuery();
              String[] row = new String[11];
            while (rs.next()) {

         row[0] = rs.getString("Id");//0
        row[1] = rs.getString("FullName");
        row[2] = rs.getString("MobileNo");
        row[3] = rs.getString("PassWord");
        row[4] = rs.getString("Status");
        row[5] = rs.getString("UserName");
         row[6] = rs.getString("UserType");
        
      
                model.addRow(row);
            }

            return model;

        } catch (Exception ex) {
                ex.printStackTrace();
    }
        return null;
}

}
