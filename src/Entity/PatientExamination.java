
package Entity;

import ConManager.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class PatientExamination extends connection {
    
    
   public int insertPatientExamination(int Patient_Id ,String strDiagnose,String strPrescription,String strDate,String strReferedTo,String strRemark)
              {
            Integer checkInsert=0;
            
           
           String strDoctor=connection.strUser;

        String select = "insert into patientexamination(Patient_Id, Diagnose,Prescription,Date,ReferedTo,Remark,Doctor)" +
             " values (?,?,?,?,?,?,?)";
            
        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(select);
               ps.setInt(1, Patient_Id);
               ps.setString(2, strDiagnose);
               ps.setString(3, strPrescription);
               ps.setString(4, strDate);
               ps.setString(5, strReferedTo);
               ps.setString(6, strRemark);  
               ps.setString(7, strDoctor);
               
               checkInsert= ps.executeUpdate();
                 return checkInsert;
      } catch (Exception ex) {
                ex.printStackTrace();
    }
        return 0;
}   
     public int deletePatientAppointment(int patientId )
              {
            Integer checkInsert=0;

        String select = "delete frrom tbl_patientappointment where Patient_Id=? and Status='Active'";
        try {
             Connection conn = this.getConnection();
            ResultSet rs=null;
            PreparedStatement ps = conn.prepareStatement(select);
               ps.setInt(1, patientId);
               
              
                   checkInsert= ps.executeUpdate();
                 return checkInsert;
      } catch (Exception ex) {
                ex.printStackTrace();
    }
        return 0;
}  
     public DefaultTableModel ReadPatientTable(String sql)  {



    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Patient_Id");
    model.addColumn("Diagnose");
    model.addColumn("Prescription");
    model.addColumn("Date");
    model.addColumn("ReferedTo");


    try {
         Connection conn = this.getConnection();
        ResultSet rs=null;
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setString(1, emp_id);
        rs = ps.executeQuery();
          String[] row = new String[11];
        while (rs.next()) {

     row[0] = rs.getString("Patient_Id");//0
    row[1] = rs.getString("Diagnose");
    row[2] = rs.getString("Prescription");
    row[3] = rs.getString("Date");
    row[4] = rs.getString("ReferedTo");


            model.addRow(row);
        }

        return model;

    } catch (Exception ex) {
            ex.printStackTrace();
}
    return null;
}
}
