package Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nhan
 */
public class Server extends JFrame implements ActionListener{
        private JButton close;
        public JTextArea user;
        private ServerSocket server;
        public Hashtable<String, ServerThread> listUser;
        private Connection conn = null;
        private Statement stmt = null;
        private PreparedStatement pstmt;
        private int port;
        private String ip;
        private String serverName;
        
        public Server( int port)
        {
                        super("Message : Server");
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        this.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e){
                                        try {
                                                server.close();
                                                System.exit(0);
                                        } catch (IOException e1) {
                                                e1.printStackTrace();
                                        }
                                }
                        });
                        this.port = port;
                        setSize(400, 400);
                        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/bg_1.png")));
                        addItem();
                        setVisible(true);
                        connectDatabase();
                        go();
        }
        
        public Server( int port, String ip, String nameServer )
        {
                        super("Message : Server");
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        this.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e){
                                        try {
                                                server.close();
                                                System.exit(0);
                                        } catch (IOException e1) {
                                                e1.printStackTrace();
                                        }
                                }
                        });
                        setSize(400, 400);
                        addItem();
                        this.port = port;
                        this.ip=ip;
                        this.serverName=nameServer;
                        // System.out.println("Cái trong hàm khởi tạo: "+serverName);
                        setVisible(true);
                        connectDatabase();
                        go();
        }
        
        private void  connectDatabase(){
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:wechat.db");
                stmt = conn.createStatement();
                System.out.println("Connection Success");
            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                System.out.println("Connection failed: "+e);
                JOptionPane.showMessageDialog(this, "Faile to connect database", "Message Dialog", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        
        public boolean insertUser(String nickName, String passWord){
             if(checkUserName(nickName)){
                 try{
                    System.out.println(passWord);
                    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    java.util.Date date = new java.util.Date();
                    String sql = "INSERT INTO user(nickName, passWord, date) VALUES(?,?,?) ";
                    pstmt = conn.prepareStatement(sql); 
                    pstmt.setString(1, nickName);
                    pstmt.setString(2, passWord);
                    pstmt.setDate(3,Date.valueOf(dateFormat.format(date)));
                    pstmt.executeUpdate();
                    return true;
                }catch (SQLException  e){
                    System.out.println("Insert to user failed: "+e.getMessage());
                }
             }
            return false;
        }
        
        private void getAllUser(){
            try{
                String sql = "SELECT * FROM user ";
                ResultSet rs    = stmt.executeQuery(sql);
                while (rs.next()) {
                 System.out.println(rs.getInt("idUser") +  "\t" + 
                                   rs.getString("nickName") + "\t" +
                                   rs.getString("passWord")  + "\t" +
                                    rs.getDate("date"));
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
            
        public boolean checkUser(String nickName, String passWord){
            try{
                String sql = "SELECT * FROM user WHERE nickName=? and passWord=?";
                pstmt = conn.prepareStatement(sql); 
                pstmt.setString(1, nickName);
                pstmt.setString(2, passWord);
                ResultSet rs    = pstmt.executeQuery();
                while (rs.next()) {
                        return true;
                }
                return false;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return false;
        }
        
        public boolean checkUserName(String nickName){
            try{
                String sql = "SELECT * FROM user WHERE nickName=?";
                pstmt = conn.prepareStatement(sql); 
                pstmt.setString(1, nickName);
                ResultSet rs    = pstmt.executeQuery();
                System.out.println(rs.getFetchSize());
                if(rs.next()) return false;
                return true;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return false;
        }
        
        public void closeConnection(){
            try{
                conn.close();
                stmt.close();
            }
            catch(Exception e){
                System.out.println("Close database false : "+e.getMessage());
            }
        }
        
        private void addItem() {
            setLayout(new BorderLayout());

            add(new JLabel("Trạng thái server : \n"),BorderLayout.NORTH);
            add(new JPanel(),BorderLayout.EAST);
            add(new JPanel(),BorderLayout.WEST);

            user = new JTextArea(10,20);
            user.setEditable(false);
            add(new JScrollPane(user),BorderLayout.CENTER);

            close = new JButton("Close Server");
            close.addActionListener(this);
            add(close,BorderLayout.SOUTH);

            user.append("Máy chủ đã được mở.\n");
        }

        private void go(){
                try {
                        listUser = new Hashtable<String, ServerThread>();
                       
                        server = new ServerSocket(this.port);
                        user.append("Máy chủ bắt đầu phục vụ tại port " + this.port + "\n");
                        while(true){
                                Socket client = server.accept();
                                new ServerThread(this,client);
                        }
                        
                } catch (IOException e) {
                        user.append("Không thể khởi động máy chủ\n");
                }
        }

        public void actionPerformed(ActionEvent e) {
                
            try {
                        closeConnection();
                        server.close();
                } catch (IOException e1) {
                        user.append("Không thể dừng được máy chủ\n");
                        closeConnection();
                }
                System.exit(0);
                
        }

        public void sendAll(String from, String msg){
                Enumeration e = listUser.keys();
                String name=null;
                while(e. hasMoreElements()){
                        name=(String) e.nextElement();
                        if(name.compareTo(from)!=0){ 
                            listUser.get(name).sendMSG("3",msg);
                        }
                }
        }
        
        public void sendFileProper(String from, String nameFile, long fileSize){
            Enumeration e = listUser.keys();
            String name=null;
            while(e. hasMoreElements()){
                    name=(String) e.nextElement();
                    if(name.compareTo(from)!=0){ 
                        listUser.get(name).sendMSG(nameFile);
                        listUser.get(name).sendMSG(fileSize);
                    }
            }
        }
        
        public void sendFileAll(String from, String fileName, long fileSize){
                Enumeration e = listUser.keys();
                String name=null;
                while(e. hasMoreElements()){
                        name=(String) e.nextElement();
                        if(name.compareTo(from)!=0){ 
                            listUser.get(name).sendMSG("6");
                            sendFileProper(from,fileName,fileSize);
                            listUser.get(name).sendFile(fileName,fileSize);
                        }
                }
                //JOptionPane.showMessageDialog(this,"server: Send completed","Message Dialog",JOptionPane.WARNING_MESSAGE);
        }
        
        public void sendImageAll(String from, String fileName, long fileSize){
                Enumeration e = listUser.keys();
                String name=null;
                while(e. hasMoreElements()){
                        name=(String) e.nextElement();
                        if(name.compareTo(from)!=0){ 
                            listUser.get(name).sendMSG("41");
                            sendFileProper(from,fileName,fileSize);
                            listUser.get(name).sendFile(fileName,fileSize);
                        }
                }
               // JOptionPane.showMessageDialog(this,"Server: Send completed","Message Dialog",JOptionPane.WARNING_MESSAGE);
        }
        
        public void sendAllUpdate(String from){
                Enumeration e = listUser.keys();
                String name=null;
                while(e. hasMoreElements()){
                        name=(String) e.nextElement();
                        //System.out.println(name);
                        if(name.compareTo(from)!=0) 
                            listUser.get(name).sendMSG("4",getAllName());
                }
        }

        public String getAllName(){
                Enumeration e = listUser.keys();
                String name="";
                while(e. hasMoreElements()){
                        name+=(String) e.nextElement()+"\n";
                }
                return name;
        } 
        
        public void beginVoiceChat(String from){
            Enumeration e = listUser.keys();
            String name=null;
            while(e. hasMoreElements()){
                    name=(String) e.nextElement();
                    if(name.compareTo(from)!=0){ 
                        listUser.get(name).sendMSG("21",from);

                    }
            }
        }
}
