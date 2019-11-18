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
    private String currentId; // ID dell'utente attualmente loggato

    public AndroidClient(String ip, int port ) {
        this.ip = ip;
        this.port = port;
    }

    public AndroidClient(String ip, int port , String currentId) {
        this.ip = ip;
        this.port = port;
        this.currentId = currentId;
    }
    //INSERT TEXT
    public boolean research(String location, String words) {
        if (words.equals("") || location.equals("")) return false;
        Socket serverSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
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
        PrintWriter output = null;
        BufferedReader input = null;
        String words="";
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
    //REGISTRAZIONE UTENTE
    public boolean signIn(String id, String name, String surname) {
        if (id.equals("") || name.equals("") || surname.equals("")) return false;
        Socket serverSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("signin");
            String result = input.readLine();
            if(result.equals("FAIL")) return false;
            output.println(id);
            output.println(name);
            output.println(surname);
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
    //CANCELLAZIONE REGISTRAZIONE UTENTE
    public boolean removeUser() {
        Socket serverSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("remove");
            String result = input.readLine();
            if(result.equals("FAIL")) return false;
            output.println(currentId);
            result = input.readLine();
            if(result.equals("FAIL")) return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }  finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //LOGOUT
    public boolean logOut() {
        Socket serverSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("logout");
            String result = input.readLine();
            if(result.equals("FAIL")) return false;
            output.println(currentId);
            result = input.readLine();
            if(result.equals("FAIL")) return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }  finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //LOGIN
    public boolean logIn(String id) {
        Socket serverSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
        try {
            serverSocket = new Socket(ip, port);
            output =  new PrintWriter(serverSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            output.println("login");
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
    }

    //LOGIN
    public boolean sndmsg(String id,String cmd) {
        Socket serverSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
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
    }



}