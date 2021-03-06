/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatr_client;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Minoj
 */
public class SettingsGUI extends javax.swing.JFrame {
    
    private ThreadsGUI gui;

    /**
     * Creates new form SettingsGUI
     */
    public SettingsGUI() {
        this.setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Store and instance of the ThreadsGUI.
     * @param gui 
     */
    public void setThreadsGUI(ThreadsGUI gui) {
        this.gui = gui;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblOldPassword = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        lblConfirmNewPassword = new javax.swing.JLabel();
        txtConfirmNewPassword = new javax.swing.JPasswordField();
        lblChangePassword = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings :: ChatR - Send and Receive Messages");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(186, 220, 88));
        jPanel2.setPreferredSize(new java.awt.Dimension(714, 87));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/chat-logo-128-white.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Settings");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 506, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblOldPassword.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        lblOldPassword.setForeground(new java.awt.Color(106, 176, 76));
        lblOldPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOldPassword.setText("old password");

        txtOldPassword.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtOldPassword.setToolTipText("Min. 8 Characters Long: An Uppercase, Lowercase, Number and No whitespaces");
        txtOldPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        txtOldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOldPasswordFocusLost(evt);
            }
        });

        lblNewPassword.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(106, 176, 76));
        lblNewPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewPassword.setText("new password");

        txtNewPassword.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtNewPassword.setToolTipText("Min. 8 Characters Long: An Uppercase, Lowercase, Number and No whitespaces");
        txtNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        txtNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNewPasswordFocusLost(evt);
            }
        });

        lblConfirmNewPassword.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        lblConfirmNewPassword.setForeground(new java.awt.Color(106, 176, 76));
        lblConfirmNewPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmNewPassword.setText("confirm new password");

        txtConfirmNewPassword.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtConfirmNewPassword.setToolTipText("Min. 8 Characters Long: An Uppercase, Lowercase, Number and No whitespaces");
        txtConfirmNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        txtConfirmNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmNewPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmNewPasswordFocusLost(evt);
            }
        });

        lblChangePassword.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblChangePassword.setForeground(new java.awt.Color(106, 176, 76));
        lblChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangePassword.setText("Change Password");

        btnSave.setBackground(new java.awt.Color(186, 220, 88));
        btnSave.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Reset");
        btnSave.setToolTipText("Click to Reset Password");
        btnSave.setBorder(null);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblOldPassword, txtOldPassword});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblNewPassword, txtNewPassword});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblConfirmNewPassword, txtConfirmNewPassword});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblOldPassword, txtOldPassword});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblNewPassword, txtNewPassword});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblConfirmNewPassword, txtConfirmNewPassword});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Once this GUI is closed, the ThreadsGUI which was previously disabled is enabled.
     * @param evt WindowEvent - Window Closing
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Dispose this GUI while enabling the Threads GUI
        this.dispose();
        gui.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Function defining txtOldPassword FocusEvent - Focus Gained.
     * Border Color of txtOldPassword PasswordField is changed.
     * @param evt FocusEvent - Focus Gained
     */
    private void txtOldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOldPasswordFocusGained
        txtOldPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 220, 88), 2, true));
    }//GEN-LAST:event_txtOldPasswordFocusGained
    
    /**
     * Function defining txtOldPassword FocusEvent - Focus Lost.
     * Border Color of txtOldPassword PasswordField is changed back to the original colour.
     * @param evt FocusEvent - Focus Lost
     */
    private void txtOldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOldPasswordFocusLost
        txtOldPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
    }//GEN-LAST:event_txtOldPasswordFocusLost
    
    /**
     * Function defining txtNewPassword FocusEvent - Focus Gained.
     * Border Color of txtNewPassword PasswordField is changed.
     * @param evt FocusEvent - Focus Gained
     */
    private void txtNewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPasswordFocusGained
        txtNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 220, 88), 2, true));
    }//GEN-LAST:event_txtNewPasswordFocusGained
    
    /**
     * Function defining txtNewPassword FocusEvent - Focus Lost.
     * Border Color of txtNewPassword PasswordField is changed back to the original colour.
     * @param evt FocusEvent - Focus Lost
     */
    private void txtNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPasswordFocusLost
        txtNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
    }//GEN-LAST:event_txtNewPasswordFocusLost
    
    /**
     * Function defining txtConfirmNewPassword FocusEvent - Focus Gained.
     * Border Color of txtConfirmNewPassword PasswordField is changed.
     * @param evt FocusEvent - Focus Gained
     */
    private void txtConfirmNewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmNewPasswordFocusGained
        txtConfirmNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 220, 88), 2, true));
    }//GEN-LAST:event_txtConfirmNewPasswordFocusGained
    
    /**
     * Function defining txtOldPassword FocusEvent - Focus Lost.
     * Border Color of txtOldPassword PasswordField is changed back to the original colour.
     * @param evt FocusEvent - Focus Lost
     */
    private void txtConfirmNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmNewPasswordFocusLost
        txtConfirmNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
    }//GEN-LAST:event_txtConfirmNewPasswordFocusLost
    
    /**
     * Function defining btnSave ActionEvent - Button Clicked.
     * Password is validated - Check if all fields filled, new password and old password matched,
     * Check if the old password value matches the actual existing password, check if new password matches the defined
     * rule. If all are correct, update the password and provide an informative message to the user.
     * @param evt ActionEvent - Button Clicked
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        if(txtOldPassword.getText().trim().length() > 0 && txtNewPassword.getText().trim().length() > 0 && txtConfirmNewPassword.getText().trim().length() > 0) {
            
            String oldPassword = new String(txtOldPassword.getPassword());
            String newPassword = new String(txtNewPassword.getPassword());
            String confirmNewPassword = new String(txtConfirmNewPassword.getPassword());
            
            if(oldPassword.equals(ChatR_Client.getUser().getPassword())) {
                // Password should be atleast 8 Characters Long
                // Atleast One Uppercase Letter
                // Atleast One Lowercase Letter
                // Atleast One Number
                // No Whitespaces allowed
                if(newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")) {
                    
                    if(newPassword.equals(confirmNewPassword)) {
                        // Assign New Password to User
                        ChatR_Client.getUser().setPassword(newPassword);
                        
                        if(updatePassword(ChatR_Client.getUser())) {
                        
                            JOptionPane.showMessageDialog(null, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            
                        }
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "New Password doesn't match with Confirm Password", "Password Change Error", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Invalid Password\nAtleast 8 Characters Long\nOne Uppercase, Lowercase and Number\nNo Whitespaces allowed", "Password Change Error", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            } else {
                
                JOptionPane.showMessageDialog(null, "Old Password doesn't match existing password", "Password Change Error", JOptionPane.ERROR_MESSAGE);
                
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Fields cannot be empty.", "Password Change Error", JOptionPane.ERROR_MESSAGE);
            
        }
            
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form if the User is logged in */
        if(ChatR_Client.getUser() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SettingsGUI().setVisible(true);
                }
            });
        } else {
            LoginGUI gui = new LoginGUI();
            gui.setVisible(true);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblChangePassword;
    private javax.swing.JLabel lblConfirmNewPassword;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JPasswordField txtConfirmNewPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables

    private static boolean updatePassword(chatr_client.Users user) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.updatePassword(user);
    }
}
