package Server;

import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;


public class ServerThread extends Thread{
    public Socket client;
    public Server server;
    private String nickName;
    private String password;
    private DataOutputStream dos;
    private DataInputStream dis;
    private boolean run;
    private String fileName;
    private Long fileSize;


    public ServerThread(Server server, Socket client){
            
            try {
                    this.server=server;
                    this.client=client;
                    dos= new DataOutputStream(client.getOutputStream());
                    dis= new DataInputStream(client.getInputStream());
                    run=true;
                    this.start();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            
    }
    
    public void run(){
            // xữ lý đăng nhập
            String msg=null;
            int check=0;//-1 tk da dang nhap roi, =0 sai tk, =1 oke
            while(run){
                    String mess=getMSG();
                    nickName=getMSG();
                    password=getMSG();
                    int numb=Integer.parseInt(mess);
                    System.err.println("Nick Name: "+  nickName);
                    if(numb==11) //Login
                    {
                        if(checkNick(nickName,password) == false)
                        {
                            check = 0;
                        }else if(checkNick(nickName,password) == true && checkNick(nickName) == true)//tk da dang nhap roi
                        {
                            sendMSG("-1");
                            check=-1;
                            
                        } else check=1;
                    }
                    else if(numb==10)//SignUp
                    {
                        if(signUp(nickName,password)==true)
                            check=1;
                    }
                    
                    if(check == 1)
                    {
                        server.user.append(nickName+" đã kết nối với room\n");
                        server.sendAll(nickName,nickName+" đã vào room\n");
                        server.listUser.put(nickName, this);
                        server.sendAllUpdate(nickName);
                        sendMSG("1");
                        diplayAllUser();
                        while(run){
                                int stt = Integer.parseInt(getMSG());
                                //JOptionPane.showMessageDialog(server,stt,"Message Dialog",JOptionPane.WARNING_MESSAGE);
                                switch(stt){
                                        case 0:
                                                run=false;
                                                server.user.append(this.nickName+" đã thoát khỏi room\n");
                                                logout();
                                                exit();
                                                break;
                                        case 1:
                                                msg = getMSG();
                                                server.sendAll(nickName,nickName+" : "+msg);
                                                break;
                                        case 2:
                                                fileSize=getMSG(true); // get number of filesize
                                                fileName=getMSG();
                                                getFile();
                                                server.sendFileAll(nickName, fileName, fileSize);
                                                break;
                                        case 20: //voice chat
                                                server.beginVoiceChat(nickName);
                                                break;
                                }
                        }
                    } else if(check==0)
                        sendMSG("0");
                    else if(check == -1)
                        sendMSG("-1");
            }
    this.stop();
    }
    private void logout() {
            try {
                    dos.close();
                    dis.close();
                    client.close();
                    server.listUser.remove(this.nickName);
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    private void exit(){
            try {
                    server.sendAllUpdate(nickName);
                    dos.close();
                    dis.close();
                    client.close();
                    server.listUser.remove(this.nickName);
                    server.user.append(nickName+" đã thoát\n");
                    server.sendAll(nickName,nickName+" đã thoát\n");
                    this.run=false;
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    private boolean checkNick(String nick){
            return server.listUser.containsKey(nick);
    }
    private boolean checkNick(String nick,String pass){
            return server.checkUser(nick,pass);
    }
    
    private boolean signUp(String nick,String pass){
        //JOptionPane.showMessageDialog(server,nick,"Message Dialog",JOptionPane.WARNING_MESSAGE);
            return server.insertUser(nick,pass);
    }
    
    public void sendMSG(String data){
            try {
                    dos.writeUTF(data);
                    dos.flush();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    public void sendMSG(long data){
            try {
                    dos.writeLong(data);
                    
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    public void sendMSG(String msg1,String msg2){
            sendMSG(msg1);
            sendMSG(msg2);
    }
    
    private String getMSG(){
            String data=null;
            try {
                    data=dis.readUTF();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return data;
    }
    private long getMSG(boolean b){
            long data=0;
            try {
                    data=dis.readLong();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return data;
    }
    
    public void sendFile(String fileName, long fileSize){
        try{
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            while (fis.read(buffer) > 0) {
                    dos.write(buffer);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void getFile(){
        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            byte[] buffer = new byte[1024];
            int read = 0;
            long remaining = fileSize;
            while((read = dis.read(buffer, 0, Math.min(buffer.length, (int)remaining))) > 0) {
                    remaining -= read;
                    fos.write(buffer, 0, read);
            }
        }
        catch (Exception e)
        { 
            e.printStackTrace();
        }
       
    }
    private void diplayAllUser(){
            String name = server.getAllName();
            sendMSG("4");
            sendMSG(name);
    }

}
