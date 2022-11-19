package com.example.server;


import org.springframework.stereotype.Service;

@Service
public class Server {


    public String change(String string){
        int i=Integer.parseInt(string);

        string=String.valueOf(i);
        return string;
    }
}
