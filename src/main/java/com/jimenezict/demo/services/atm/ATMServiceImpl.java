package com.jimenezict.demo.services.atm;

import com.jimenezict.demo.model.BankDAO;
import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;
import com.jimenezict.demo.services.account.AccountService;
import com.jimenezict.demo.services.account.withdraw.WithdrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATMServiceImpl implements ATMService {

    Logger ATMServiceLog = LoggerFactory.getLogger(ATMServiceImpl.class);

    @Autowired
    BankDAO bankDAO;

    @Autowired
    AccountService accountService;

    @Override
    public void replenish(ATMStatus atmStatus){
        ATMServiceLog.info("Replenish the ATM");
        bankDAO.setTheATMStatus(atmStatus);
    }

    @Override
    public String checkBalance(String number) {
        return accountService.checkBalance(number);
    }

    @Override
    public WithDraw withDrawAnAmount(String number, Integer amount) {
        return accountService.withDrawAnAmount(number,amount);
    }
}
