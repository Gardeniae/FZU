package com.example.Controller;


import com.example.service.ChangeToChinese;
import com.example.service.judgeType;
import com.example.service.transform;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
int i;


    String result;
    @PostMapping("/App/get")
    public String Get(String string){

        judgeType type=new judgeType();
        int flag=type.judgeX(string);
        if(flag == 1){
            transform t1  = new transform();
            result=t1.op(string);
        }
        else if(flag == 0){
            ChangeToChinese t2=new ChangeToChinese();
            result=t2.int2chineseNum(string);
        }
        else{
            result="输入错误!";
        }
        return result;
    }

}
