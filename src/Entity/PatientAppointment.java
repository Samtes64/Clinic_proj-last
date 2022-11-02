
package Entity;

import ConManager.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class PatientAppointment extends connection {


public int insertPatientAppointment(int patientId ,String strAppointDate,String strAssignedto)
          {
        Integer checkInsert=0;
        String strStatus="Active";

    String select = "insert into tbl_patientappointment(Patient_Id,AppointmentDate,AssignedTo,Status)" +
         " values (?,?,?,?)";

    try {
         Connection conn = this.getConnection();
        ResultSet rs=null;
        PreparedStatement ps = conn.prepareStatement(select);
           ps.setInt(1, patientId);
           ps.setString(2, strAppointDate);
           ps.setString(3, strAssignedto);
           ps.setString(4, strStatus);


               checkInsert= ps.executeUpdate();
             return checkInsert;
  } catch (Exception ex) {
            ex.printStackTrace();
}
    return 0;
}   
 public int FinishPatientAppointment(int patientId )
          {
        Integer checkInsert=0;

    String select = "update tbl_patientappointment set Status='Inactive' where Patient_Id=?";

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
    model.addColumn("AppointmentDate");
    model.addColumn("AssignedTo");


    try {
         Connection conn = this.getConnection();
        ResultSet rs=null;
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setString(1, emp_id);
        rs = ps.executeQuery();
          String[] row = new String[11];
        while (rs.next()) {

     row[0] = rs.getString("Patient_Id");//0
    row[1] = rs.getString("AppointmentDate");
    row[2] = rs.getString("AssignedTo");


            model.addRow(row);
        }

        return model;

    } catch (Exception ex) {
            ex.printStackTrace();
}
    return null;
}
}
