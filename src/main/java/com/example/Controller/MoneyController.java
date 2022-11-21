package com.example.Controller;

import com.example.domain.money;
import com.example.mapper.MoneyMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class MoneyController {

    @Autowired
    private MoneyMapper moneyMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/money")       //捐款操作
    public String donation(@RequestParam Integer user_id, @RequestParam Integer push_Money, @RequestParam Integer id){
        if(push_Money > 0){
            Integer current_Money = userMapper.SelectById_integral(user_id);
            if(push_Money<=current_Money){
                current_Money -= push_Money;
                money m =  moneyMapper.SelectById(id);
                Integer update_current = m.getCurrent();        //1.获取当前进度
                Integer need_Money = m.getTarget() - m.getCurrent();
                if(need_Money>=push_Money){
                    update_current += push_Money;
                    moneyMapper.Update(id,update_current);                //更新捐款数据
                    userMapper.Update_integral(user_id,current_Money);      ////更新用户拥有的积分
                    return "Success!";
                }
                else {
                    update_current += need_Money;
                    moneyMapper.Update(id,update_current);                //更新捐款数据
                    current_Money += (push_Money - need_Money);
                    userMapper.Update_integral(user_id,current_Money);     //更新用户拥有的积分
                    return "Success! 超额返回您：" + (push_Money - need_Money) + "元";
                }
            }
            else {
                return "Failed!";
            }
        }
        else{
            return "不能输入小于等于0的数!";
        }
    }

    @GetMapping("/fresh")                   //2.用分页的方式，返回当前捐款信息
    public List<money> fresh(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        pageNum = (pageNum - 1)* pageSize;
        return moneyMapper.Select_All(pageNum,pageSize);
    }


}
