package com.jimenezict.demo.services.account.withdraw;

import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WithdrawServiceImpl implements WithdrawService{

    Logger withdrawServiceLog = LoggerFactory.getLogger(WithdrawService.class);

    @Override
    public WithDraw generatesTheWithdrawByNotes(Integer amount, ATMStatus atmStatus){
        withdrawServiceLog.info("Requesting an amount of: {}", amount);
        WithDraw withDraw = new WithDraw();

        amount = getAtLeastA5Notes(amount, withDraw);
        amount = calculate50Notes(amount, atmStatus, withDraw);
        amount = calculate20Notes(amount, atmStatus, withDraw);
        amount = calculate10Notes(amount, atmStatus, withDraw);
        calculate5Notes(amount, atmStatus, withDraw);

        return withDraw;
    }

    private Integer getAtLeastA5Notes(Integer amount, WithDraw withDraw) {
        withDraw.setNotes_5(1);
        return amount - 5;
    }

    private Integer calculate5Notes(Integer amount, ATMStatus atmStatus, WithDraw withDraw) {
        int i=0;
        while(amount >= 5 && i < atmStatus.getNotes_5()){
            withDraw.setNotes_5(withDraw.getNotes_5() + 1);
            amount -= 5;
        }
        withdrawServiceLog.info("There are {} of 5 notes on the withdraw", withDraw.getNotes_5());
        return amount;
    }

    private Integer calculate10Notes(Integer amount, ATMStatus atmStatus, WithDraw withDraw) {
        int i=0;
        while(amount >= 10 && i < atmStatus.getNotes_10()){
            withDraw.setNotes_10(withDraw.getNotes_10() + 1);
            amount -= 10;
        }
        withdrawServiceLog.info("There are {} of 10 notes on the withdraw", withDraw.getNotes_10());
        return amount;
    }

    private Integer calculate20Notes(Integer amount, ATMStatus atmStatus, WithDraw withDraw) {
        int i=0;
        while(amount >= 20 && i < atmStatus.getNotes_20()){
            withDraw.setNotes_20(withDraw.getNotes_20() + 1);
            amount -= 20;
        }
        withdrawServiceLog.info("There are {} of 20 notes on the withdraw", withDraw.getNotes_20());
        return amount;
    }

    private Integer calculate50Notes(Integer amount, ATMStatus atmStatus, WithDraw withDraw) {
        int i =0;
        while(amount >= 50 && i < atmStatus.getNotes_50()){
            withDraw.setNotes_50(withDraw.getNotes_50() + 1);
            amount -= 50;
            i++;
        }
        withdrawServiceLog.info("There are {} of 50 notes on the withdraw", withDraw.getNotes_50());
        return amount;
    };

    @Override
    public WithDraw generatesFailedWithdraw(){
        WithDraw withDraw = new WithDraw();
        return withDraw;
    }

    @Override
    public boolean isTheAmountValidOnATM(Integer amount){
        return (amount >= 20 && amount <= 250 && amount%5 ==0);
    }

}
