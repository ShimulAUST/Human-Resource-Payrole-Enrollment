
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class salaryGenerated extends javax.swing.JFrame {
    
    /**
     * Creates new form salaryGenerated
     */
    
    private int empId;
    private String name;
    public salaryGenerated() {
        initComponents();
    }
    public salaryGenerated(int id,long hours,String name){
    initComponents();
        

        
          try {  
              
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             Connection conn = DriverManager  
                     .getConnection(  
                             "jdbc:sqlserver://localhost:1433;databaseName=HumanResource_payroll;selectMethod=cursor",   "sa", "123456");  
              String sql ="Select BasicSalary,MedicalAllownce,HourlyRate from employee_salary where EmployeeId='"+id+"'";
              
              System.out.println(sql);
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(sql);
             System.out.println("Success");
             
             if(hours==240){
             while(rs.next())
             {
                 System.out.println(rs.getInt("BasicSalary"));
                 System.out.println("Success");
                 SalaryTA.setText("  ----------- SALARY FOR EMPLOYEE : "+id+" -----------\n\n"+
                         "  BasicSalary :  "+rs.getInt(1)+"\n"+
                         "  Medical Allownce : "+rs.getInt(2)+"\n"+
                         "  Deduction/Bonus : N/A"+"\n\n"+
                         "  ------------------------------------------------\n"+
                         "  Total : "+"\\-"
                         
                 
                 
                 );
                 
             }
             }
             
             else if(hours<240){
                 
                 long hour =240-hours;
                 
                 long deduction;
             while(rs.next())
             {
                    deduction=(240-hour)*rs.getInt(3);
                  long total=rs.getInt(1)+rs.getInt(2)-deduction;
                 
                 System.out.println(rs.getInt("BasicSalary"));
                 System.out.println("Success");
                 SalaryTA.setText("  ----------- SALARY FOR EMPLOYEE : "+id+" -----------\n\n"+
                         "  BasicSalary :  "+rs.getInt(1)+"\n"+
                         "  Medical Allownce : "+rs.getInt(2)+"\n"+
                         "  Deduction : "+deduction+"\n\n"+
                         "  ------------------------------------------------\n"+
                         "  Total : "+total+"\\-"
                         
                 
                 
                 );
                 
             }
             }
             
               else if(hours>240){
                 
                 long hour =hours-240;
                 
                 long bonus;
             while(rs.next())
             {
                    bonus=(hour-240)*rs.getInt(3);
                 
                 long total=rs.getInt(1)+rs.getInt(2)+bonus;
                 System.out.println(rs.getInt("BasicSalary"));
                 System.out.println("Success");
                 SalaryTA.setText("  ----------- SALARY FOR EMPLOYEE : "+id+" -----------\n\n"+
                         "  BasicSalary :  "+rs.getInt(1)+"\n"+
                         "  Medical Allownce : "+rs.getInt(2)+"\n"+
                         "  Bonus : "+bonus+"\n\n"+
                         "  ------------------------------------------------\n"+
                         "  Total : "+total+"\\-"
                         
                 
                 
                 );
                 
             }
             }
             
             
               else if(hours<=0){
                 
                 long hour =hours-240;
                 
                 long bonus;
             while(rs.next())
             {
                   
                 
                 long total=rs.getInt(1)+rs.getInt(2);
                 System.out.println(rs.getInt("BasicSalary"));
                 System.out.println("Success");
                 SalaryTA.setText("  ----------- SALARY FOR EMPLOYEE : "+id+" -----------\n\n"+
                         "  BasicSalary :  "+rs.getInt(1)+"\n"+
                         "  Medical Allownce : "+rs.getInt(2)+"\n"+
                        
                         "  ------------------------------------------------\n"+
                         "  Total : "+total+"\\-"
                         
                 
                 
                 );
                 
             }
             }
             
          
          }catch(Exception E){
              System.out.println(E);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        SalaryTA = new javax.swing.JTextArea();
        ButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SalaryTA.setEditable(false);
        SalaryTA.setColumns(20);
        SalaryTA.setRows(5);
        jScrollPane1.setViewportView(SalaryTA);

        ButtonBack.setText("Back");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonBack)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(ButtonBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
      
        new EmployeeLoggedIn(name,empId).setVisible(true);
        setVisible(false);
        
        
        
    }//GEN-LAST:event_ButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(salaryGenerated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salaryGenerated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salaryGenerated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salaryGenerated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salaryGenerated().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JTextArea SalaryTA;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
