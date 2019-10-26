
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class EmployeeLoggedIn extends javax.swing.JFrame {
private String user_name,countsql,date; private int empId,count;
    /**
     * Creates new form EmployeeLoggedIn
     */

private LocalTime inTime,outTime;
private LocalDate date1,date2;
    public EmployeeLoggedIn() {
        initComponents();
    }
    
    public EmployeeLoggedIn(String name,int EmpId){
        initComponents();
        
        user_name=name;
        empId=EmpId;
        empNameJBL.setText(user_name);
        
        
        
   
   
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                         "jdbc:sqlserver://localhost:1433;databaseName=HumanResource_payroll;selectMethod=cursor", "sa", "123456");
       countsql="select count(distinct DateOfWork) as countValue from Employee_Working_Hours where EmployeeId='"+empId+"'";
           
       Statement smt = conn.createStatement();
       ResultSet rs1 = smt.executeQuery(countsql);
       
       Calendar cal = Calendar.getInstance();
      int res = cal.getActualMaximum(Calendar.DATE);
       
       if(rs1.next()){
           count=rs1.getInt("countValue");  
       }
      
       LocalDate now = LocalDate.now(); // 2015-11-24
       LocalDate earlier = now.minusMonths(1); // 2015-10-24
       earlier.getMonth(); // java.time.Month = OCTOBER
       earlier.getMonth().getValue(); // 10
       earlier.getYear(); // 2015
       
        LocalDate now1 = LocalDate.now(); 
        
        int t=now1.getMonth().compareTo(earlier.getMonth());
        System.out.println(now1.getMonth());
        System.out.println(earlier.getMonth());
        System.out.println(t);
        
        
       
       
       
       if (res!=count){
          
            System.out.println(res);
           
       }
       else{
       ButtonPayment.setEnabled(true);
       }
       
           System.out.println(count);
          
       }catch(Exception e){
       
       
       }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonLogOut = new javax.swing.JButton();
        empNameJBL = new javax.swing.JLabel();
        ButtonCheckIn = new javax.swing.JButton();
        ButtonCheckout = new javax.swing.JButton();
        ButtonPayment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonLogOut.setText("Log Out");
        ButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLogOutActionPerformed(evt);
            }
        });

        ButtonCheckIn.setText("CheckIn");
        ButtonCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCheckInActionPerformed(evt);
            }
        });

        ButtonCheckout.setText("CheckOut");
        ButtonCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCheckoutActionPerformed(evt);
            }
        });

        ButtonPayment.setText("Payment");
        ButtonPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(empNameJBL, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonLogOut)
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                .addComponent(ButtonPayment)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(empNameJBL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(ButtonCheckIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCheckout)
                    .addComponent(ButtonPayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(ButtonLogOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCheckInActionPerformed
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        
        inTime=LocalTime.parse(dtf.format(now));
        System.out.println(inTime);
        
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
        
        date1=localDate;
	System.out.println(dtf1.format(localDate)); //2016/11/16
      
       
        
        try{
       
// long elapsedMinutes = Duration.between(l1,) ).toMillis();
        
        
//            System.out.println(elapsedMinutes);
       
        
        }catch(Exception e){
        
        }
        
    }//GEN-LAST:event_ButtonCheckInActionPerformed

    private void ButtonCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCheckoutActionPerformed
        // TODO add your handling code here:
        
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
        
       outTime=LocalTime.parse(dtf.format(now));
       System.out.println(dtf.format(now));
      
       
        
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
        
        date2=localDate;
	System.out.println(dtf1.format(localDate)); //2016/11/16
        date= dtf1.format(date2);
       
        
        
    }//GEN-LAST:event_ButtonCheckoutActionPerformed

    private void ButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogOutActionPerformed
        // TODO add your handling code here:
        
        if(date2.equals(date1))
        {
            System.out.println("Same");
          
              try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                         "jdbc:sqlserver://localhost:1433;databaseName=HumanResource_payroll;selectMethod=cursor", "sa", "123456");
                         
            long elapsedMinutes = Duration.between(inTime,outTime).toMillis();
            
          String sql="Insert into Employee_working_Hours (EmployeeId,WorkingHours,DateOfWork) values (?,?,?)";
          PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,empId);
            pst.setLong(2, elapsedMinutes);
            pst.setString(3, date);
            pst.executeUpdate();
            
                  System.out.println("Success");
                   System.out.println(count);
                   System.out.println(countsql);
            
             }catch(Exception E){
            
            }
            
            
            
        }
        else{
            System.out.println("Not same");
        }
        
    }//GEN-LAST:event_ButtonLogOutActionPerformed

    private void ButtonPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPaymentActionPerformed
        new salary_generated_time(empId,user_name).setVisible(true);
        setVisible(false);

        
    }//GEN-LAST:event_ButtonPaymentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLoggedIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCheckIn;
    private javax.swing.JButton ButtonCheckout;
    private javax.swing.JButton ButtonLogOut;
    private javax.swing.JButton ButtonPayment;
    private javax.swing.JLabel empNameJBL;
    // End of variables declaration//GEN-END:variables
}