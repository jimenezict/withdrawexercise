package com.jimenezict.demo.WithdrawServiceTest;


import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;
import com.jimenezict.demo.services.account.withdraw.WithdrawService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithdrawAnAmountValidValuesPoorBankTest {

    @Autowired
    private WithdrawService withdrawService;

    ATMStatus atmStatus;

    @Before
    public void init(){
        atmStatus = new ATMStatus();
        atmStatus.setNotes_5(10000000);
        atmStatus.setNotes_10(10000000);
        atmStatus.setNotes_20(0);
        atmStatus.setNotes_50(0);
    }

    @Test
    public void generatesTheWithdrawByNotesTest20() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(20, atmStatus);
        assertEquals(new Integer(2),nullWithDraw.getNotes_5());
        assertEquals(new Integer(1),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest25() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(25, atmStatus);
        assertEquals(new Integer(1),nullWithDraw.getNotes_5());
        assertEquals(new Integer(2),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest30() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(30, atmStatus);
        assertEquals(new Integer(2),nullWithDraw.getNotes_5());
        assertEquals(new Integer(2),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest35() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(35, atmStatus);
        assertEquals(new Integer(1),nullWithDraw.getNotes_5());
        assertEquals(new Integer(3),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest40() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(40, atmStatus);
        assertEquals(new Integer(2),nullWithDraw.getNotes_5());
        assertEquals(new Integer(3),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest45() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(45, atmStatus);
        assertEquals(new Integer(1),nullWithDraw.getNotes_5());
        assertEquals(new Integer(4),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest50() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(50, atmStatus);
        assertEquals(new Integer(2),nullWithDraw.getNotes_5());
        assertEquals(new Integer(4),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest55() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(55, atmStatus);
        assertEquals(new Integer(1),nullWithDraw.getNotes_5());
        assertEquals(new Integer(5),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest60() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(60, atmStatus);
        assertEquals(new Integer(2),nullWithDraw.getNotes_5());
        assertEquals(new Integer(5),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }

    @Test
    public void generatesTheWithdrawByNotesTest95() {
        WithDraw nullWithDraw = withdrawService.generatesTheWithdrawByNotes(95, atmStatus);
        assertEquals(new Integer(1),nullWithDraw.getNotes_5());
        assertEquals(new Integer(9),nullWithDraw.getNotes_10());
        assertEquals(new Integer(0),nullWithDraw.getNotes_20());
        assertEquals(new Integer(0),nullWithDraw.getNotes_50());
    }
}
