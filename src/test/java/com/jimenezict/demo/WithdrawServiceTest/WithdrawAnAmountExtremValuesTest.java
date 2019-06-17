package com.jimenezict.demo.WithdrawServiceTest;


import com.jimenezict.demo.model.dto.WithDraw;
import com.jimenezict.demo.services.account.withdraw.WithdrawService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithdrawAnAmountExtremValuesTest {

    @Autowired
    private WithdrawService withdrawService;

    @Test
    public void generatesFailedWithdraw() {
        WithDraw nullWithDraw = withdrawService.generatesFailedWithdraw();
        assertEquals(new Integer(0),nullWithDraw.getNotes_5());
        assertEquals(new Integer(0),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void tooSmallAmount() {
        boolean isValidAmount = withdrawService.isTheAmountValidOnATM(19);
        assertFalse(isValidAmount);
    }

    @Test
    public void tooBigAmount() {
        boolean isValidAmount = withdrawService.isTheAmountValidOnATM(251);
        assertFalse(isValidAmount);
    }

    @Test
    public void isMultipleOfFiveAmount() {
        boolean isValidAmount = withdrawService.isTheAmountValidOnATM(100);
        assertTrue(isValidAmount);
    }

    @Test
    public void isNotMultipleOfFiveAmount() {
        boolean isValidAmount = withdrawService.isTheAmountValidOnATM(99);
        assertFalse(isValidAmount);
    }
}