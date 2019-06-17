package com.jimenezict.demo.AccountServiceTest;

import com.jimenezict.demo.services.account.AccountService;
import com.jimenezict.demo.model.dto.WithDraw;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithdrawAnAmountExtremValuesTest {

    @Autowired
    private AccountService accountService;

    private WithDraw isNullWithdraw;

    @Before
    public void init(){
        isNullWithdraw = new WithDraw();
    }

    @Test
    public void notValidAccount() {
        WithDraw withDraw = accountService.withDrawAnAmount("01000",10);
        assertEquals(new Integer(0),withDraw.getNotes_5());
        assertEquals(new Integer(0),withDraw.getNotes_10());
        assertEquals(new Integer(0),withDraw.getNotes_20());
        assertEquals(new Integer(0),withDraw.getNotes_50());
    }

    @Test
    public void tooBigAmount() {
        WithDraw withDraw = accountService.withDrawAnAmount("01001",255);
        assertEquals(new Integer(0),withDraw.getNotes_5());
        assertEquals(new Integer(0),withDraw.getNotes_10());
        assertEquals(new Integer(0),withDraw.getNotes_20());
        assertEquals(new Integer(0),withDraw.getNotes_50());
    }

    @Test
    public void tooSmallAmount() {
        WithDraw withDraw = accountService.withDrawAnAmount("01001",19);
        assertEquals(new Integer(0),withDraw.getNotes_5());
        assertEquals(new Integer(0),withDraw.getNotes_10());
        assertEquals(new Integer(0),withDraw.getNotes_20());
        assertEquals(new Integer(0),withDraw.getNotes_50());
    }

}