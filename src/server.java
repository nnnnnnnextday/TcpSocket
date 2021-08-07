
//server side programming

import  java.net.*;
import  java.io.*;

public class server {

    public  static  void main(String[] args){
        try{
            boolean flag=true;
            Socket clientSocket= null;
            String  inputLine;

            ServerSocket  serverSocket =new  ServerSocket(1088);
            System.out.println("Server listen on" +serverSocket.getLocalPort());

            while(flag){
                clientSocket = serverSocket.accept();
                DataInputStream is=new DataInputStream(
                        new  BufferedInputStream(clientSocket.getInputStream()));
                PrintStream  os=new PrintStream(
                        new  BufferedOutputStream(clientSocket.getOutputStream()));

                while((inputLine= is.readLine()) != null){
                    if(inputLine.equals("Stop!")){
                        flag = false;
                        break;
                    }
                    os.println(inputLine+"1234");
                    os.flush();
                }
                os.close();
                is.close();
                clientSocket.close();
            }
            serverSocket.close();

        }catch(IOException  e){
            System.err.println("Exception:" + e);
        }
    }
}