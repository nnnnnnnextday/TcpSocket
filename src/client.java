//Client Side Programming

import  java.net.*;
import  java.io.*;

public class client {

    /**
     * Constructor.
     */
    public client () {
    }


    public static void main(String args[]) {

        try{
            Socket  echoSocket = new  Socket("127.0.0.1",1088) ;
            OutputStream  os=echoSocket.getOutputStream();
            DataInputStream  is=
                    new DataInputStream(echoSocket.getInputStream());
            int  c;
            String  responseLine;
            while((c=System.in.read()) != -1){
                os.write((byte)c);
                if(c == '\n'){
                    os.flush();
                    responseLine = is.readLine();
                    System.out.println("echo:" + responseLine);
                }
            }
            os.close();
            is.close();
            echoSocket.close();
        }catch(Exception  e){
            System.err.println("Exception:" + e);
        }
    }
}
