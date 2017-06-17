package Client;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginForm extends javax.swing.JFrame 
{
    private String ip;
    private int port;
    
    public LoginForm(String ip, int port) {
        initComponents();
        this.ip = ip;
        this.port = port;
        //password.setEchoChar('*');
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/bg_1.png")));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nickName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        butLogin = new javax.swing.JButton();
        signUp = new javax.swing.JButton();
        butExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MESSAGE - LOGIN");
        setPreferredSize(new java.awt.Dimension(620, 670));
        setResizable(false);
        setSize(new java.awt.Dimension(620, 670));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(132, 41, 56));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MESSAGE - LOGIN");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 48));

        nickName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        nickName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nickNameKeyPressed(evt);
            }
        });
        getContentPane().add(nickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 320, 40));

        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        password.setEchoChar('*');
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 320, 40));

        butLogin.setBackground(new java.awt.Color(33, 61, 117));
        butLogin.setFont(new java.awt.Font("VNI-Bengus", 0, 18)); // NOI18N
        butLogin.setForeground(new java.awt.Color(189, 197, 208));
        butLogin.setText("LOGIN");
        butLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        butLogin.setMargin(new java.awt.Insets(12, 14, 12, 14));
        butLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLoginActionPerformed(evt);
            }
        });
        getContentPane().add(butLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 120, 40));

        signUp.setBackground(new java.awt.Color(33, 61, 117));
        signUp.setFont(new java.awt.Font("VNI-Bengus", 0, 18)); // NOI18N
        signUp.setForeground(new java.awt.Color(189, 197, 208));
        signUp.setText("SIGN UP");
        signUp.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signUp.setMargin(new java.awt.Insets(12, 14, 12, 14));
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });
        getContentPane().add(signUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 120, 40));

        butExit.setBackground(new java.awt.Color(33, 61, 117));
        butExit.setFont(new java.awt.Font("VNI-Bengus", 0, 18)); // NOI18N
        butExit.setForeground(new java.awt.Color(189, 197, 208));
        butExit.setText("EXIT");
        butExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        butExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });
        getContentPane().add(butExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 120, 40));

        jLabel2.setFont(new java.awt.Font("VNI-Avo", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 61, 117));
        jLabel2.setText("User Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 30));

        jLabel3.setFont(new java.awt.Font("VNI-Avo", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 61, 117));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 120, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg_1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, 190));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 680, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExitActionPerformed
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_butExitActionPerformed

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        SignUp signup = new SignUp(ip, port);
        signup.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signUpActionPerformed

    private void butLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLoginActionPerformed
        try{
            Client main = new Client(ip, port);
            
            //hasing password via md5
            String passText = new String(password.getPassword());
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passText.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println(sb.toString());
            
            if(main.checkLogin(nickName.getText(),sb.toString()) == 1)
            {
                main.getNickName(nickName.getText());
                this.setVisible(false);
                main.setVisible(true);
            }
            else if(main.checkLogin(nickName.getText(),sb.toString()) == -1){
                JOptionPane.showMessageDialog(this,"Tài khoản này đã được đăng nhập ","Message Dialog",JOptionPane.WARNING_MESSAGE);
            }
            else if(main.checkLogin(nickName.getText(),sb.toString()) == 0){
                JOptionPane.showMessageDialog(this,"Tên đăng nhập hoặc tài khoảng không tồn tại !!","Message Dialog",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_butLoginActionPerformed

    private void nickNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nickNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try{
            Client main = new Client(ip, port);
            //hasing password via md5
            String passText = new String(password.getPassword());
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passText.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println(sb.toString());
            
            if(main.checkLogin(nickName.getText(),sb.toString()) == 1)
            {
                main.getNickName(nickName.getText());
                this.setVisible(false);
                main.setVisible(true);
            }
            else if(main.checkLogin(nickName.getText(),sb.toString()) == -1){
                JOptionPane.showMessageDialog(this,"Tài khoản này đã được đăng nhập ","Message Dialog",JOptionPane.WARNING_MESSAGE);
            }
            else if(main.checkLogin(nickName.getText(),sb.toString()) == 0){
                JOptionPane.showMessageDialog(this,"Tên đăng nhập hoặc tài khoảng không tồn tại !!","Message Dialog",JOptionPane.WARNING_MESSAGE);
            }
        } catch(NoSuchAlgorithmException e){
                e.printStackTrace();
            }   
        }
    }//GEN-LAST:event_nickNameKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butExit;
    private javax.swing.JButton butLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nickName;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signUp;
    // End of variables declaration//GEN-END:variables

}
