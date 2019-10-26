
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class EMPLOYEELOGIN extends javax.swing.JFrame {

    /**
     * Creates new form EMPLOYEELOGIN
     */
    public EMPLOYEELOGIN() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userEmailTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        userPasswordTF = new javax.swing.JPasswordField();
        ButtonUserLogIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Employee Login");

        jLabel2.setText("User Email:");

        userEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailTFActionPerformed(evt);
            }
        });

        jLabel3.setText("Password: ");

        userPasswordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPasswordTFActionPerformed(evt);
            }
        });

        ButtonUserLogIn.setText("Log in");
        ButtonUserLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUserLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userEmailTF)
                            .addComponent(userPasswordTF, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonUserLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(ButtonUserLogIn)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailTFActionPerformed

    private void userPasswordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPasswordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPasswordTFActionPerformed

    private void ButtonUserLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUserLogInActionPerformed
        // TODO add your handling code here:
        
         try {  
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             Connection conn = DriverManager  
                     .getConnection(  
                             "jdbc:sqlserver://localhost:1433;databaseName=HumanResource_payroll;selectMethod=cursor",   "sa", "123456");  
               String username=userEmailTF.getText().trim();
               String password =userPasswordTF.getText().trim();
               
              System.out.println(username+","+password);
             
            String sql ="select * from user_profiles where Email='"+username+"'";
              
              
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(sql);
          String pass="";
          
          int empID=0;
          while(rs.next()){
           pass=rs.getString("Pass");
           empID=rs.getInt("EmployeeId");
          }
          
          if(pass.equals(password))
          {
             JOptionPane.showMessageDialog(null,"Login Successful");
             
             //select employee.FirstName  from employee  full join user_profiles on employee.EmployeeId=user_profiles.EmployeeId where user_profiles.EmployeeId ='1'
             
             
             String sqll="select employee.* from employee  full join user_profiles on employee.EmployeeId=user_profiles.EmployeeId where user_profiles.EmployeeId='"+empID+"'";
             Statement smt1 = conn.createStatement();
             ResultSet rs1 = smt.executeQuery(sqll);
             String Fname="";
             while(rs1.next())
             {
               Fname=rs1.getString("FirstName");
             
             }
             new EmployeeLoggedIn(Fname,empID).setVisible(true);
              setVisible(false);
          }
          else{
          JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
          userEmailTF.setText("");
          userPasswordTF.setText("");
          }  
            conn.close();  
         }catch (Exception e) {  
             e.printStackTrace();  
         }
    }//GEN-LAST:event_ButtonUserLogInActionPerformed

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
            java.util.logging.Logger.getLogger(EMPLOYEELOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EMPLOYEELOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EMPLOYEELOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EMPLOYEELOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EMPLOYEELOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonUserLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField userEmailTF;
    private javax.swing.JPasswordField userPasswordTF;
    // End of variables declaration//GEN-END:variables
}
