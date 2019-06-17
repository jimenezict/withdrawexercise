package com.jimenezict.demo.BankDTO;

import com.jimenezict.demo.model.BankDAO;
import com.jimenezict.demo.model.dto.ATMStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankDTOTest {

    @Autowired
    private BankDAO bankDAO;

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
    public void getBankStatus(){
        beforeEachTest();
        ATMStatus atm = bankDAO.getTheNotesOfTheBank();
        assertEquals(new Integer(100),atm.getNotes_5());
        assertEquals(new Integer(100),atm.getNotes_10());
        assertEquals(new Integer(100),atm.getNotes_20());
        assertEquals(new Integer(100),atm.getNotes_50());
        afterEachTest();
    }

    @Test
    public void setAndGetBankStatus(){
        beforeEachTest();
        ATMStatus atm = bankDAO.getTheNotesOfTheBank();
        assertEquals(new Integer(100),atm.getNotes_5());
        assertEquals(new Integer(100),atm.getNotes_10());
        assertEquals(new Integer(100),atm.getNotes_20());
        assertEquals(new Integer(100),atm.getNotes_50());
        afterEachTest();
    }

    @Test
    public void setAndGetAccountBalance(){
        beforeEachTest();
        bankDAO.setAccountBalanceByNumberAValidAmount("01001",1000.00);
        assertEquals(1000.00,bankDAO.getAccountBalanceByNumber("01001"),0.0);
        afterEachTest();
    }

    @Test
    public void setAnAmmountByAccount(){
        beforeEachTest();
        bankDAO.setAccountBalanceByNumberAValidAmount("01001",1000.00);
        assertEquals(1000.00,bankDAO.getAccountBalanceByNumber("01001"),0.0);
        afterEachTest();
    }

    @Test
    public void reduceAnAmmountByAccount(){
        beforeEachTest();
        bankDAO.reduceTheAmountToTheUser("01001",20);
        assertEquals(2718.59,bankDAO.getAccountBalanceByNumber("01001"),0.0);
        afterEachTest();
    }
}
