package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhan
 */
public class ClientThread extends Thread{
        private boolean run;
        private DataOutputStream dos;
        private DataInputStream dis;
        private Client client;
        private  String savePath;
        private  Long fileSize;
        public ClientThread(Client client,DataInputStream dis){
                run=true;
                this.client=client;
                this.dis=dis;
                this.start();
        }
        
        public void run(){
                String msg1,msg2;
                while(run)
                {
                    try {
                            msg1=dis.readUTF();
                            msg2=dis.readUTF();
                            int stt = Integer.parseInt(msg1);
                            switch(stt){
                                case 3:case 4: case 5://4 update, 3 nhan tin tu client khac
                                     client.getMSG(msg1,msg2);
                                     break;
                                     //goi file
                                case 6:
                                    client.getMSG(msg1,msg2);
                                    askSaveFile(msg2);
                                    break;
                                case 41:
                                    JOptionPane.showMessageDialog(client,"Preparing to recieve an image","Message Dialog",JOptionPane.WARNING_MESSAGE);
                                    client.getMSG(msg1,msg2);
                                    fileSize=dis.readLong();
                                    client.saveImage(msg2,fileSize);
                                    //client.getImage(msg2);
                                    break;
                                case 21:
                                    client.getMSG(msg1,msg2);
                                    
                                    askVoiceChat(msg2);
                                    break;
                            }
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
                }
                try {
                        dis.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        public void asksaveImage(String msg2){
        try{
                savePath="";
                //String ms=dis.readUTF();
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save the image?","Notice",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    fileSize=dis.readLong();
                    String fileName=msg2;
                    //client.msg.append(fileName);
                    JFileChooser j = new JFileChooser();
                    j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int opt = j.showSaveDialog(client);
                    if(opt == JFileChooser.APPROVE_OPTION){
                        savePath=j.getSelectedFile().getPath();
                        //JOptionPane.showMessageDialog(client,"Thông tin file nhận từ server Name"+fileName+"-Size "+fileSize,"Message Dialog",JOptionPane.WARNING_MESSAGE);
                        client.saveImage(savePath+"\\"+msg2,fileSize);
                    }
                }
                else  client.saveImage(msg2,fileSize);
               
                client.getImage(savePath);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        
    }
        private void askSaveFile(String msg2){
            try{
                //String ms=dis.readUTF();
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save file?","Notice",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    fileSize=dis.readLong();
                    String fileName=msg2;
                    //client.msg.append(fileName);
                    JFileChooser j = new JFileChooser();
                    j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int opt = j.showSaveDialog(client);
                    if(opt == JFileChooser.APPROVE_OPTION){
                        savePath=j.getSelectedFile().getPath();
                        client.saveFile(savePath+"\\"+msg2,fileSize);
                        //JOptionPane.showMessageDialog(client,"Thông tin file nhận từ server Name"+fileName+"-Size "+fileSize,"Message Dialog",JOptionPane.WARNING_MESSAGE);
                        
                    }
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
            
        }
        private void askVoiceChat(String name){
            
                //String ms=dis.readUTF();
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, name+ "is calling","Notice",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION)
                {
                    client.init_audio();    // TODO add your handling code here:
                    client.init_audio1();
                }
                
        }
        
        public void stopThread() throws IOException{
           this.interrupt();
            this.run=false;
        }  
}