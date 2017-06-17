package Client;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import say.swing.JFontChooser;

/**
 *
 * @author Nhan
 */
public class Client extends javax.swing.JFrame {

    private Socket client;
    private ClientThread dataStream;
    private DataOutputStream dos;
    private DataInputStream dis;
    private BufferedImage ImageToken;
    private String nick = "";
    private boolean isFile;
    private  File selectedFile;
    private String ip;
    private final int port;
    
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        go(ip, port);
        initComponents();
        txtMSG.setEditable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/bg_1.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filebut = new javax.swing.JButton();
        Namelab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        message = new javax.swing.JTextField();
        Sendbut1 = new javax.swing.JButton();
        GIFbut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        online = new javax.swing.JTextArea();
        VoiceChat = new javax.swing.JButton();
        ENDVC = new javax.swing.JButton();
        FontBut = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMSG = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(this.ip + " :" + String.valueOf(this.port)
        );
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        filebut.setText("File");
        filebut.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        filebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filebutActionPerformed(evt);
            }
        });
        getContentPane().add(filebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 75, 35));

        Namelab.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Namelab.setText("Namelab");
        getContentPane().add(Namelab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 475, 33));

        jLabel1.setFont(new java.awt.Font("Thames", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(132, 41, 56));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MESSAGE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 713, 58));

        message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageKeyPressed(evt);
            }
        });
        getContentPane().add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 340, 32));

        Sendbut1.setFont(new java.awt.Font("VNI-Avo", 0, 14)); // NOI18N
        Sendbut1.setText("Send");
        Sendbut1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Sendbut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sendbut1ActionPerformed(evt);
            }
        });
        getContentPane().add(Sendbut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 90, 32));

        GIFbut.setText("Image");
        GIFbut.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        GIFbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GIFbutActionPerformed(evt);
            }
        });
        getContentPane().add(GIFbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 80, 35));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("VNI-DOS Sample Font ", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Member");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 178, 27));

        online.setEditable(false);
        online.setColumns(20);
        online.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        online.setRows(5);
        jScrollPane2.setViewportView(online);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, 180, 277));

        VoiceChat.setText("Call");
        VoiceChat.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        VoiceChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoiceChatActionPerformed(evt);
            }
        });
        jPanel1.add(VoiceChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, 34));

        ENDVC.setText("Hang Up");
        ENDVC.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        ENDVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENDVCActionPerformed(evt);
            }
        });
        jPanel1.add(ENDVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 80, 34));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 210, 387));

        FontBut.setText("Font");
        FontBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        FontBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontButActionPerformed(evt);
            }
        });
        getContentPane().add(FontBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 71, 35));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setViewportView(txtMSG);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 460, 270));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 710, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Sendbut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sendbut1ActionPerformed
        if(!isFile){
            checkSend(message.getText()+"\n");
            message.setText("");
        } else{
            checkSend(selectedFile);
            message.setText("");
            isFile=false;
        }
        
    }//GEN-LAST:event_Sendbut1ActionPerformed

    private void messageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            checkSend(message.getText()+"\n");
            message.setText("");
        }
    }//GEN-LAST:event_messageKeyPressed

    private void filebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filebutActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            message.setText(selectedFile.getName());
            isFile=true;
           
        }
    }//GEN-LAST:event_filebutActionPerformed

    private void FontButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontButActionPerformed
        JFontChooser fontChooser = new JFontChooser();
        int result = fontChooser.showDialog(this);
        if (result == JFontChooser.OK_OPTION)
        {
            Font font = fontChooser.getSelectedFont(); 
            this.txtMSG.setFont(font);
        } 
    }//GEN-LAST:event_FontButActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(HIDE_ON_CLOSE );
        this.setVisible(false);
        sendMSG("0");
    }//GEN-LAST:event_formWindowClosing

    public static boolean runCalling = false;
    public String add_server = ip;
    
    public static AudioFormat getaudioformat(){
        float sampleRate = 8000.0F;
        int sampleSizeInbits = 16;
        int channel = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInbits, channel, signed, bigEndian);
    }
    TargetDataLine audio_in;
    
    public void init_audio(){
        try {
            AudioFormat format = getaudioformat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if(!AudioSystem.isLineSupported(info)){
                System.out.println("not suport");
                System.exit(0);
            }
            audio_in = (TargetDataLine) AudioSystem.getLine(info);
            audio_in.open(format);
            audio_in.start();
            Client_CV r = new Client_CV();
            InetAddress inet = InetAddress.getByName(add_server);
            r.audio_in = audio_in;
            r.dout = new DatagramSocket();
            r.server_ip = inet;
            r.server_port = port;
            runCalling = true;
            r.start();
            VoiceChat.setEnabled(false);
            ENDVC.setEnabled(true);
        } catch (LineUnavailableException | UnknownHostException | SocketException ex) {
            //Logger.getLogger(client_fr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public SourceDataLine audio_out;
    public void init_audio1(){
        try {
            AudioFormat format = getaudioformat();
            DataLine.Info info_out = new DataLine.Info(SourceDataLine.class, format);
            if(!AudioSystem.isLineSupported(info_out)){
                //System.out.println("not suport");
                JOptionPane.showMessageDialog(this,"Drive not suport","Message Dialog",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            audio_out = (SourceDataLine)AudioSystem.getLine(info_out);
            audio_out.open(format);
            audio_out.start();
            Client_CV_Out p = new Client_CV_Out();
            p.din = new DatagramSocket(port);
            p.audio_out = audio_out;
            runCalling = true;
            p.start();
        } catch (LineUnavailableException | SocketException ex) {
            //Logger.getLogger(server_fr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void VoiceChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoiceChatActionPerformed
            init_audio();    // TODO add your handling code here:
            init_audio1();
            sendMSG("20");
    }//GEN-LAST:event_VoiceChatActionPerformed

    private void ENDVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENDVCActionPerformed
        // TODO add your handling code here:
        runCalling = false;
        VoiceChat.setEnabled(true);
         ENDVC.setEnabled(false);
    }//GEN-LAST:event_ENDVCActionPerformed

    private void GIFbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GIFbutActionPerformed
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        j.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        int opt = j.showOpenDialog(this);
        if(opt == JFileChooser.APPROVE_OPTION){
            String savePath=j.getSelectedFile().getPath();
            File m=new File(savePath);
            //if(m.length()<=2500){
                checkSendImg(m);
                this.getImage(savePath);
               // checkSend(" Gửi 1 ảnh: "+m.getName()+"\n");
               
                
            //}
            //else JOptionPane.showMessageDialog(this,"Ảnh quá lớn, vui lòng chọn ảnh có kích thước nhỏ hơn 2.5M","Message Dialog",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_GIFbutActionPerformed

    //get image to send
    public BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }
    public void getImage(String savePath){
        try{
                InputStream is = new BufferedInputStream(new FileInputStream(savePath));
                BufferedImage img=ImageIO.read(is);
                is.close();
                int w=img.getWidth();
                int h=img.getHeight();
                
                int nW= w>150?150:w;
                int nH=h*nW/w;
                
                double fW= (double)nW/w;
                double fH=(double)nH/h;
                
                img= this.scale(img, img.getType(), w, h ,fW , fH);
                img = img.getSubimage(0, 0, nW, nH);
                
                StyledDocument doc = txtMSG.getStyledDocument();

                SimpleAttributeSet style = new SimpleAttributeSet();
                StyleConstants.setIcon(style, new ImageIcon(img));
                StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
                doc.insertString(doc.getLength(), "\n", style);
               //JOptionPane.showMessageDialog(this,"Begin Send file to server complete","Message Dialog",JOptionPane.WARNING_MESSAGE);
            } catch(Exception ex){
                ex.printStackTrace();
            }
    }
    
    //Tạo Client ở Port 7777 để các Client kết nối
    private void go(String ip, int port) {
            isFile=false;
            try {
                    client = new Socket(ip, port);
                    dos=new DataOutputStream(client.getOutputStream());
                    dis=new DataInputStream(client.getInputStream());
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,"Kết nối thât bại, xin hãy kiểm tra lại ip.","Message Dialog",JOptionPane.WARNING_MESSAGE);
            }
	
    }
    
    //Gởi dữ liệu đến các Client
    private void sendMSG(String data){
            try {
                    dos.writeUTF(data);
                    System.out.println("Client: "+data);
                    dos.flush();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    //Gởi dữ liệu đến các Client
    private void sendMSG(long data){
            try {
                    dos.writeLong(data);
                    System.out.println("Client: "+data);
                    dos.flush();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    //Nhận dữ liệu từ swerver 
    private String getMSG(){
            String data=null;
            try {
                    data=dis.readUTF();
                   
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return data;
    }
    
    public void getMSG(String msg1, String msg2) throws IOException{
            int stt = Integer.parseInt(msg1);
            switch (stt) {
            // tin nhắn của những người khác
            case 3: case 6:
                    StyledDocument doc = txtMSG.getStyledDocument();
                    SimpleAttributeSet center = new SimpleAttributeSet();
                    StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                    
                    StyleConstants.setForeground(center, new Color(75,79,86));
                    StyleConstants.setBackground(center, new Color(241,240,240));
                   
                    try
                    {
                        doc.insertString(doc.getLength(), msg2 , center);
                    }
                    catch(Exception e) { System.out.println(e);}
                    break;
            // update danh sách online
            
            case 4:
                    this.online.setText(msg2);
                    break;
            // server đóng cửa
            case 5:
                    dataStream.stopThread();
                    exit();
                    break;
            // bổ sung sau
            default:
                    break;
            }
    }
    
    private void checkSend(String msg){
            if(msg.compareTo("\n")!=0){
                    StyledDocument doc = txtMSG.getStyledDocument();
                    SimpleAttributeSet center = new SimpleAttributeSet();
                    StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
                    
                    StyleConstants.setForeground(center, Color.WHITE);
                    StyleConstants.setBackground(center, new Color(64,128,255));
                   
                    try
                    {
                        int length = doc.getLength();
                        doc.insertString(doc.getLength(),msg , center);
                        doc.setParagraphAttributes(length+1, 1, center, false);
                    }
                    catch(Exception e) { System.out.println(e);}
            sendMSG("1");
            sendMSG(msg);
            }
    }
    private void beginVoiceChat(){
        sendMSG("20");
    }
    
    private void checkSendImg(File file){
        if(file.isFile()){
            sendMSG("40");
            sendImage(file);
        }
    }
    private void checkSend( File file){
        if(file.isFile()){
            sendMSG("2");
            sendFile(file);
        }
    }
    
    private void sendFile(File file){
        try{
            sendMSG(file.length());
            sendMSG(file.getName());
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            while (fis.read(buffer) > 0) {
                    dos.write(buffer);
                  //  dos.flush();
            }
            fis.close();
            dis=new DataInputStream(client.getInputStream());
            JOptionPane.showMessageDialog(this,"Send file to complete","Message Dialog",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void sendImage(File file){
        try{
            sendMSG(file.length());
            sendMSG(file.getName());
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            while (fis.read(buffer) > 0) {
                    dos.write(buffer);
            }
            fis.close();
            dis=new DataInputStream(client.getInputStream());
            dos=new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void saveFile(String path, long fileSize){
        try
        {
            FileOutputStream fos = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
                
            long filesize = fileSize; // Send file size in separate msg
            int read = 0;
           
            long remaining = filesize;
            while((read = dis.read(buffer, 0, Math.min(buffer.length, (int)remaining))) > 0) {
                    remaining -= read;
                    fos.write(buffer, 0, read);
            }
            
            fos.close();
            JOptionPane.showMessageDialog(this,"Received file complete","Message Dialog",JOptionPane.WARNING_MESSAGE);
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public boolean saveImage(String path,long fileSize){
        try
        {
            FileOutputStream fos = new FileOutputStream(path);
            long filesize = fileSize; // Send file size in separate msg
            byte[] buffer = new byte[1024];
            int read = 0;
            long remaining = filesize;
            while((read = dis.read(buffer, 0, Math.min(buffer.length, (int)remaining))) > 0) {
                    remaining -= read;
                    fos.write(buffer, 0, read);
                    //fos.flush();
            }
            fos.close();
            getImage(path);
            
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean checkLogin(String nick){
            if(nick.compareTo("")==0)
                    return false;
            else if(nick.compareTo("0")==0){
                    return false;
            }
            else{
                    sendMSG(nick);
                    int sst = Integer.parseInt(getMSG());
                    if(sst == 0)   return false;
                    else return true;
            }
    }
    
    public int checkLogin(String nick,String pass){
            if(nick.compareTo("")==0 || pass.compareTo("")==0 || nick.compareTo("0")==0 ||pass.compareTo("0")==0)
                    return 0;
            else{
                    sendMSG("11");
                    sendMSG(nick);
                    sendMSG(pass);
                    int sst = Integer.parseInt(getMSG());
                    return sst;
            }
    }
    
    public boolean checkSignUp(String nick,String pass){
            if(nick.compareTo("")==0 || pass.compareTo("")==0 || nick.compareTo("0")==0 ||pass.compareTo("0")==0)
                    return false;
            else{
                    sendMSG("10");
                    sendMSG(nick);
                    sendMSG(pass);
                    int sst = Integer.parseInt(getMSG());
                    if(sst == 0)   return false;
                    else return true;
            }
    }
    
    public void getNickName(String name)
    {
        this.nick = name;
        Namelab.setText("Xin Chào " + name + " ! " );
        StyledDocument doc = txtMSG.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, Color.RED);
        try
        {
            doc.insertString(doc.getLength(), "Đã đăng nhập thành công\n", keyWord );
        }
        catch(Exception e) { System.out.println(e); }
        dataStream = new ClientThread(this, this.dis);
    }
    
    private void exit(){
            try {
                    sendMSG("0");
                    dos.close();
                    dis.close();
                    client.close();
                    dataStream.stopThread();
            } catch (IOException e1) {
                    e1.printStackTrace();
            }
            System.exit(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ENDVC;
    private javax.swing.JButton FontBut;
    private javax.swing.JButton GIFbut;
    private javax.swing.JLabel Namelab;
    private javax.swing.JButton Sendbut1;
    private javax.swing.JButton VoiceChat;
    private javax.swing.JButton filebut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField message;
    private javax.swing.JTextArea online;
    public javax.swing.JTextPane txtMSG;
    // End of variables declaration//GEN-END:variables
}
