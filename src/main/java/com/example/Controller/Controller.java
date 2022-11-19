package com.example.Controller;


import com.example.server.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Controller {


    @Resource
    private Server server;

    @GetMapping("/App/get")
    public String get(String string){


        string=server.change(string);
        return string;
    }

}
