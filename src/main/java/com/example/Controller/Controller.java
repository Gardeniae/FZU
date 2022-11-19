package com.example.Controller;


import com.example.service.ChangeToChinese;
import com.example.service.judgeType;
import com.example.service.transform;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {



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
        return result;
//        ChangeToChinese t2=new ChangeToChinese();
//        result=t2.int2chineseNum(string);
//        return result;
//        transform t1  = new transform();
//        result=t1.op(string);
//        return  result;
    }

}
