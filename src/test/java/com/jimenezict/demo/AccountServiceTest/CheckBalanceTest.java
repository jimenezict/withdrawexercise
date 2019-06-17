package com.jimenezict.demo.AccountServiceTest;

import com.jimenezict.demo.services.account.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckBalanceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void checkBalance01001() {
        String balance = accountService.checkBalance("01001");
        Assert.assertEquals("The balance is: 2738.59",balance);
    }

    @Test
    public void checkBalance01002() {
        String balance = accountService.checkBalance("01002");
        Assert.assertEquals("The balance is: 23.0",balance);
    }

    @Test
    public void checkBalance01003() {
        String balance = accountService.checkBalance("01003");
        Assert.assertEquals("The balance is: 0.0",balance);
    }

    @Test
    public void checkBalanceInvalidUser() {
        String balance = accountService.checkBalance("01000");
        Assert.assertEquals("There is no user with this account",balance);
    }

}