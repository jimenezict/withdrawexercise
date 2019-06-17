package com.jimenezict.demo.AccountServiceTest;

import com.jimenezict.demo.model.BankDAO;
import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;
import com.jimenezict.demo.services.account.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithdrawAnAmountValidValuesTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private BankDAO bankDAO;


    private WithDraw isNullWithdraw;

    private void beforeEachTest(){
        initializeUser01001();
    }

    private void afterEachTest(){
        initializeUser01001();
    }

    private void initializeUser01001() {
        ATMStatus ATMStatus = new ATMStatus();
        ATMStatus.setNotes_5(100);
        ATMStatus.setNotes_10(100);
        ATMStatus.setNotes_20(100);
        ATMStatus.setNotes_50(100);
        bankDAO.setTheATMStatus(ATMStatus);
        bankDAO.setAccountBalanceByNumberAValidAmount("01001", 2738.59);
    }

    @Test
    public void notValidAccount() {
        beforeEachTest();
        WithDraw withDraw = accountService.withDrawAnAmount("01000",55);
        assertEquals(new Integer(0),withDraw.getNotes_5());
        assertEquals(new Integer(0),withDraw.getNotes_10());
        assertEquals(new Integer(0),withDraw.getNotes_20());
        assertEquals(new Integer(0),withDraw.getNotes_50());
        afterEachTest();
    }

    @Test
    public void  generatesTheWithdrawByNotesTest25() {
        beforeEachTest();
        WithDraw withDraw = accountService.withDrawAnAmount("01001",25);
        assertEquals(new Integer(1),withDraw.getNotes_5());
        assertEquals(new Integer(0),withDraw.getNotes_10());
        assertEquals(new Integer(1),withDraw.getNotes_20());
        assertEquals(new Integer(0),withDraw.getNotes_50());
        afterEachTest();
    }

    @Test
    public void  generatesTheWithdrawByNotesTest150() {
        beforeEachTest();
        WithDraw withDraw = accountService.withDrawAnAmount("01001",150);
        assertEquals(new Integer(2),withDraw.getNotes_5());
        assertEquals(new Integer(0),withDraw.getNotes_10());
        assertEquals(new Integer(2),withDraw.getNotes_20());
        assertEquals(new Integer(2),withDraw.getNotes_50());
        afterEachTest();
    }

}