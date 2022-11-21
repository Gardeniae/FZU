package com.example.Donation;

import com.example.domain.money;
import com.example.mapper.MoneyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DonationTest {

    @Autowired
    private MoneyMapper moneyMapper;

    @Test
    public void test1(){
        money m = moneyMapper.SelectById(1);
        Integer cur = m.getCurrent();
        System.out.println(cur);
    }
}
