package Client;

import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
/**
 *
 * @author Nhan
 */
public class SignUp extends javax.swing.JFrame 
{
    private String ip;
    private int port;
    public SignUp(String ip, int port) {
        this.ip = ip;
        this.port = port;
        initComponents();
        passSign.setEchoChar('*');
        repeatPass.setEchoChar('*');
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/bg_1.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameSign = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passSign = new javax.swing.JPasswordField();
        repeatPass = new javax.swing.JPasswordField();
        signUp = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(870, 520));
        setMinimumSize(new java.awt.Dimension(870, 520));
        setPreferredSize(new java.awt.Dimension(870, 520));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameSign.setFont(new java.awt.Font("Viner Hand ITC", 0, 16)); // NOI18N
        nameSign.setToolTipText("");
        nameSign.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(nameSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 300, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 170, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MESSAGE - SIGN UP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 870, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Repeat password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 170, -1));

        passSign.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passSignActionPerformed(evt);
            }
        });
        getContentPane().add(passSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 300, 30));

        repeatPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(repeatPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 300, 30));

        signUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        signUp.setText("Sign up");
        signUp.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });
        getContentPane().add(signUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 140, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg_1.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 250, 250));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5759_3.jpg"))); // NOI18N
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        if(passSign.getText().compareTo(repeatPass.getText())!=0) {
            JOptionPane.showMessageDialog(this,"Password và repeat password không hợp hệ","Message Dialog",JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            Client main = new Client(this.ip, this.port);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passSign.getText().getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                 sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println(passSign.getText());
            System.out.println(sb.toString());
            if(main.checkSignUp(nameSign.getText(),sb.toString()))
            {
                this.setVisible(false);
                main.setVisible(true);
                main.getNickName(nameSign.getText());
            }
            else{
                JOptionPane.showMessageDialog(this,"Tài khoảng này đã được đăng ký, vui lòng chọn nick khác","Message Dialog",JOptionPane.WARNING_MESSAGE);
            }
       }
       catch(NoSuchAlgorithmException e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_signUpActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
        LoginForm login = new LoginForm(ip, port);
        login.setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void passSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passSignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passSignActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameSign;
    private javax.swing.JPasswordField passSign;
    private javax.swing.JPasswordField repeatPass;
    private javax.swing.JButton signUp;
    // End of variables declaration//GEN-END:variables
}
