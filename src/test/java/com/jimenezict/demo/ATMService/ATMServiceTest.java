package com.jimenezict.demo.ATMService;


import com.jimenezict.demo.model.BankDAO;
import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.services.atm.ATMService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ATMServiceTest {

    @Autowired
    private ATMService ATMService;

    @Autowired
    private BankDAO bankDAO;

    @Test
    public void setUpATM() {
        ATMStatus ATMStatus = new ATMStatus();
        ATMStatus.setNotes_5(10);
        ATMStatus.setNotes_10(10);
        ATMStatus.setNotes_20(10);
        ATMStatus.setNotes_50(10);
        ATMService.replenish(ATMStatus);
        ATMStatus atm = bankDAO.getTheNotesOfTheBank();
        assertEquals(new Integer(10),atm.getNotes_5());
        assertEquals(new Integer(10),atm.getNotes_10());
        assertEquals(new Integer(10),atm.getNotes_20());
        assertEquals(new Integer(10),atm.getNotes_50());
    }
}