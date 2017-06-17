package Main;

import Client.LoginForm;
import Server.Server;
import Server.Server;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nhan
 */
public class MainApp extends javax.swing.JFrame {
    private ImageIcon icon;
    private JLabel label;
    public MainApp()  {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/bg_1.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Clientbut = new javax.swing.JButton();
        Serverbut = new javax.swing.JButton();
        NameServer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 102, 255));
        setForeground(java.awt.Color.white);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 460));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 175, 40));

        Clientbut.setBackground(new java.awt.Color(255, 255, 255));
        Clientbut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Clientbut.setText("Login");
        Clientbut.setBorder(null);
        Clientbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientbutActionPerformed(evt);
            }
        });
        jPanel1.add(Clientbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 175, 40));

        Serverbut.setBackground(new java.awt.Color(255, 255, 255));
        Serverbut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serverbut.setText("Create new Server");
        Serverbut.setBorder(null);
        Serverbut.setBorderPainted(false);
        Serverbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerbutActionPerformed(evt);
            }
        });
        jPanel1.add(Serverbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 175, 43));

        NameServer.setBackground(new java.awt.Color(245, 245, 245));
        NameServer.setForeground(new java.awt.Color(48, 52, 52));
        NameServer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        NameServer.setCaretColor(new java.awt.Color(0, 153, 255));
        jPanel1.add(NameServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 205, 42));

        jLabel1.setFont(new java.awt.Font("VNI-Chancery", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(48, 52, 52));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MESSAGE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 529, 54));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg_1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 250, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5759_2.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(529, 450));
        jLabel2.setMinimumSize(new java.awt.Dimension(529, 450));
        jLabel2.setPreferredSize(new java.awt.Dimension(529, 450));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(529, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ServerbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerbutActionPerformed
        this.name = NameServer.getText();
        String nameSV= this.name;
        if (NameServer.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền tên phòng !!", "Message Dialog", JOptionPane.WARNING_MESSAGE);

        } else {
            /**
            * @Tìm port phù hợp để chạy server trước
            */
            int i = -32767;
            while(!available(i+33793)){
                i++;
            }

            int newport = i + 33793;
            this.port = i + 33793;
            if(i<31742){
                Thread sendip = new Thread(new Runnable() {
                    public void run() {
                        while (true) {
                            try {
                                DatagramSocket ds = new DatagramSocket();
                                Enumeration nis = NetworkInterface.getNetworkInterfaces();
                                while (nis.hasMoreElements()) {
                                    NetworkInterface ni = (NetworkInterface) nis.nextElement();
                                    Enumeration ias = ni.getInetAddresses();
                                    while (ias.hasMoreElements()) {
                                        String str =  InetAddress.getLocalHost().getHostAddress() + "+" + Integer.toString(newport) + "+" + NameServer.getText();
                                        //System.out.println(InetAddress.getLocalHost().getHostAddress());
                                        //System.out.println(Integer.toString(newport));
                                        InetAddress ia = (InetAddress) ias.nextElement();
                                        if (!Character.isLetter(str.charAt(0))) {
                                            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ia, 1025);
                                            ds.send(dp);
                                        }
                                    }
                                }
                            } catch (SocketException ex) {
                                System.out.println(ex + "  1");
                            } catch (IOException ex) {
                                System.out.println(ex + "  2");
                            }
                        }
                    }
                });
                sendip.start();
                Thread service;
                service = new Thread(new Runnable() {
                    public void run() {

                        //  System.out.println("Cái dùng để khởi tạo"+nameSV);
                        //server = new Server(newport,InetAddress.getLocalHost().getHostAddress(), nameSV);
                        server = new Server(newport);

                    }
                });
                service.start();
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(this, "Bạn đã tạo quá số phòng quy đinh ( tối đa chỉ 64508 phòng thôi nhá) !!", "Message Dialog", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ServerbutActionPerformed

    private void ClientbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientbutActionPerformed
        Rooms room = new Rooms();
        this.dispose();
    }//GEN-LAST:event_ClientbutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private int port;
    private String ip;
    private String name;
    private Server server;

    public static boolean available(int port) {
    if (port < 1026 || port > 65535) {
        return false;
    }
    ServerSocket ss = null;
    DatagramSocket ds = null;
    try {
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
        ds = new DatagramSocket(port);
        ds.setReuseAddress(true);
        return true;
    } catch (IOException e) {
    } finally {
        if (ds != null) {
            ds.close();
        }

        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                /* should not be thrown */
            }
        }
    }

    return false;
}
    
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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clientbut;
    private javax.swing.JTextField NameServer;
    private javax.swing.JButton Serverbut;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
