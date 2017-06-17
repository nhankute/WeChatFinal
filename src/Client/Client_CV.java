/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author bao
 */
public class Client_CV extends Thread{
    public TargetDataLine audio_in = null;
    public DatagramSocket dout;
    byte byte_buff[] = new byte[1024];
    public InetAddress server_ip;
    public int server_port;
    public void run(){
        while(Client.runCalling){
            try {
                audio_in.read(byte_buff, 0, byte_buff.length);
                DatagramPacket data = new DatagramPacket(byte_buff, byte_buff.length, server_ip, server_port);
                
                dout.send(data);
            } catch (IOException ex) {
                //Logger.getLogger(recorder_thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        audio_in.close();
        audio_in.drain();
        //System.out.println("Thread stop");
    }
}