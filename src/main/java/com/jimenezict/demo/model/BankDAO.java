package com.jimenezict.demo.model;

import org.springframework.stereotype.Service;
import com.jimenezict.demo.model.dto.ATMStatus;

@Service
public interface BankDAO {

    Double getAccountBalanceByNumber(String number);

    void reduceTheAmountToTheUser(String account, Integer amount);

    ATMStatus getTheNotesOfTheBank();

    void setTheATMStatus(ATMStatus atmStatus);

    void setAccountBalanceByNumberAValidAmount(String number, double amount);
}
