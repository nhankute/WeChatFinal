package Main;

import Client.LoginForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Nhan
 */
public class Rooms extends JFrame implements ActionListener{
    private Hashtable<String,String> AllRooms = new Hashtable<String, String> ();
    private int countRoom = 0;
    private JButton butReload;
    private JButton jButton2;
    private JPanel Room;
    private JLabel label;
    private JScrollPane scroll;
    private LoginForm client;
    
    public Rooms() {
         super("Rooms Message app");
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        
                        System.exit(0);
                    }
            });
            setSize(400, 400);
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/bg_1.png")));
        this.setBackground(Color.WHITE);
        setVisible(true);
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        label = new JLabel();
        label.setText("List rooms");
        label.setForeground(new Color(22,19,12));
        label.setFont(new Font("Tahoma", 0, 28));
        //label.setForeground(new java.awt.Color(0,0,255));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.NORTH);

        Room = new JPanel();
        Room.setBounds(0, 50, 400, 400);
        add(Room);
        
        scroll = new JScrollPane();
        Room.add(scroll);
        Room.validate();
        
        jButton2 = new JButton("Reload rooms");
        jButton2.addActionListener(this);
        //jButton2.setBorder(new Border );
        add(jButton2,BorderLayout.SOUTH);
    }                                   

    
    public void actionPerformed(ActionEvent e) {
        Room.removeAll();
        Room.revalidate();
        Room.repaint();
        if(e.getSource() == jButton2){
        String name = null;
        int loop = 1;
        int port = 0;
        try {
            while(loop < 255){
                DatagramSocket ds = new DatagramSocket(1025);
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, 1024);
                ds.setSoTimeout(10000); //10s
                    try{
                            ds.receive(dp);
                            String str = new String(dp.getData(), 0, dp.getLength());
                            for (int i = 0; i < str.length(); i++) {
                                if(str.charAt(i)=='+')
                                {
                                    name = str.substring(i + 1 );
                                    str = str.substring(0, i);
                                    for (int j = 0; j < name.length(); j++) {
                                        if(name.charAt(j)=='+'){
                                            port = Integer.parseInt(name.substring(0, j));
                                            name = name.substring(j + 1);
                                            j=name.length();
                                        }
                                    }
                                    i=str.length();
                                }
                              }
                            if(!AllRooms.containsKey(name))
                            {
                                countRoom++;
                                AllRooms.put(name, str);
                                javax.swing.JButton b = new javax.swing.JButton();
                                creatnewroomBut(countRoom, name, str, port);
                            }
                        loop++;
                    
                    }catch (SocketTimeoutException ste) {
                        loop=256;
                        System.out.println("### Timed out after 10 seconds ");
                    } catch (IOException ex) {
                        Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
                    }
            ds.close();
            }
        } catch (SocketException ex) {
            System.out.println(ex);
        } 
        }
    }

    private void creatnewroomBut(int room, String name, final String ip, final int port ) {
        javax.swing.JButton b = new javax.swing.JButton();
        b.setText("Room : "  + name);
        b.setFont(new Font("Tahoma", 0, 16));
        b.setForeground(new Color(59,62,64));
        b.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        b.setBounds(0, room*50, 554, 50);
        b.setSize(320, 40);
        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(320,40));
        b.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        Room.add(b, BorderLayout.AFTER_LAST_LINE);
        Room.validate();
        
        
        
        b.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread join = new Thread(new Runnable(){
                    public void run(){
                        LoginForm client = new LoginForm(ip, port);
                        client.setVisible(true);
                    }
                });
                join.start();
                
            //System.out.print("aaaaa0");
            }
        });
    }
}
