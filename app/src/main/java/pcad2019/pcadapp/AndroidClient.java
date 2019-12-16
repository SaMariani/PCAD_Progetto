package pcad2019.pcadapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Created by giorgiodelzanno on 09/03/19.
 */

public class AndroidClient {
    protected String ip;
    private int port;

    public AndroidClient(String ip, int port ) {
        this.ip = ip;
        this.port = port;
    }

    //INSERT TEXT
    public boolean research(String location, String words) {
        if (words.equals("") || location.equals("")) return false;
        Socket serverSocket = null;
        PrintWriter output;
        BufferedReader input;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("research");
            String result = input.readLine();
            if(result.equals("FAIL")) return false;
            output.println(location);
            output.println(words);
            result = input.readLine();
            if(result.equals("FAIL")) return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    //PRINT TEXT
    public String print() {
        Socket serverSocket = null;
        PrintWriter output;
        BufferedReader input;
        String words;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("print");
            String result = input.readLine();
            if(result.equals("FAIL")) return "FAIL";
            words = input.readLine();
            if(words.equals("FAIL")) return "FAIL";
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "FAIL";
        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL";
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return words;
    }

    //PRINT TEXT
    public String print3words() {
        Socket serverSocket = null;
        PrintWriter output;
        BufferedReader input;
        String words3;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("mostSearchedW");
            String result = input.readLine();
            if(result.equals("FAIL")) return "FAIL";
            words3 = input.readLine();
            if(words3.equals("FAIL")) return "FAIL";
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "FAIL";
        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL";
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return words3;
    }

    /*LOGIN
    public boolean sndmsg(String id,String cmd) {
        Socket serverSocket = null;
        PrintWriter output;
        BufferedReader input;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader bufferedReader = input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println(cmd);
            String result = input.readLine();
            if(result.equals("FAIL")) return false;
            output.println(id);
            result = input.readLine();
            if(result.equals("FAIL")) return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }  finally {
            try {
                if(serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(Exception ee) {
                ee.printStackTrace();
            }
        }
        currentId = id;
        return true;
    }*/



}