

package Entity;

import ConManager.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;




public class PatientRegistration extends connection{
     

    public int insertPatientRegistration(String ID,String PatientType,String FirstName,String MiddleName,String LastName,String Sex,String BirthDate,String Mobile,
            String RegistrationDate,String STATUS)  {
            Integer checkInsert=0;

    String select = "insert into tbl_Patient(Id, Patient_Type, FirstName, MiddleName, LastName, Sex, BirthDate, MobileNo, RegistrationDate, Status)" +
             " values (?,?,?,?,?,?,?,?,?,?)";
              
                
                   


        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setString(1, ID);
             ps.setString(2, PatientType);
              ps.setString(3, FirstName);
               ps.setString(4, MiddleName);
                ps.setString(5, LastName);
                 ps.setString(6, Sex);
                  ps.setString(7, BirthDate);
                   ps.setString(8, Mobile);
                   ps.setString(9, RegistrationDate);
                   ps.setString(10, STATUS);
                   checkInsert= ps.executeUpdate();
                 return checkInsert;
      } catch (Exception ex) {
                ex.printStackTrace();
    }
        return 0;
}

public int updatePatientRegistration(int patientId,String ID,String PatientType,String FirstName,String MiddleName,String LastName,String Sex,String BirthDate,String Mobile,
            String RegistrationDate,String STATUS)  {
Integer checkInsert=0;

    String select = "update  tbl_Patient set Id=?, Patient_Type=?, FirstName=?, MiddleName=?, LastName=?, Sex=?, BirthDate=?, MobileNo=?, RegistrationDate=?, Status=? where Patient_id=?" ;
            
              
                
                   


        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setString(1, ID);
             ps.setString(2, PatientType);
              ps.setString(3, FirstName);
               ps.setString(4, MiddleName);
                ps.setString(5, LastName);
                 ps.setString(6, Sex);
                  ps.setString(7, BirthDate);
                   ps.setString(8, Mobile);
                   ps.setString(9, RegistrationDate);
                   ps.setString(10, STATUS);
                   ps.setInt(11, patientId);
                   
                   checkInsert= ps.executeUpdate();
                 return checkInsert;
      } catch (Exception ex) {
                ex.printStackTrace();
    }
        return 0;
}

public DefaultTableModel ReadPatientTable(String sql)  {
    
    

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Patient_Id");
        model.addColumn("FirstName");
        model.addColumn("MiddleName");
        model.addColumn("LastName");
        model.addColumn("BirthDate");
        model.addColumn("MobileNo");
        model.addColumn("Patient_Type");
        model.addColumn("RegistrationDate");
       model.addColumn("Sex");
       model.addColumn("Status");
    
        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, emp_id);
            rs = ps.executeQuery();
              String[] row = new String[11];
            while (rs.next()) {

         row[0] = rs.getString("Id");//0
        row[1] = rs.getString("Patient_Id");
        row[2] = rs.getString("FirstName");
        row[3] = rs.getString("MiddleName");
        row[4] = rs.getString("LastName");
        row[5] = rs.getString("BirthDate");
         row[6] = rs.getString("MobileNo");
        row[7] = rs.getString("Patient_Type");
        row[8] = rs.getString("RegistrationDate");
       row[9] = rs.getString("SEx");
       row[10] = rs.getString("Status");
      
                model.addRow(row);
            }

            return model;

        } catch (Exception ex) {
                ex.printStackTrace();
    }
        return null;
}


 



 
       
}
