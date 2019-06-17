package com.jimenezict.demo.services.account;

import com.jimenezict.demo.model.BankDAO;
import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;

import com.jimenezict.demo.services.account.withdraw.WithdrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    Logger accountServiceImpl = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private BankDAO bankDAO;

    @Autowired
    private WithdrawService withdrawService;

    String NO_VALID_SENTENCE = "There is no user with this account";
    String VALANCE_IS= "The balance is: ";

    @Override
    public String checkBalance(String number){
        accountServiceImpl.info("Checking the balance to {}", number);
        boolean existsAccount = doesExistTheAccountOnTheBank(number);
        return existsAccount? VALANCE_IS + getTheAmountOfAnAccountAsString(number) : NO_VALID_SENTENCE;
    }

    @Override
    public WithDraw withDrawAnAmount(String number, Integer amount){
        accountServiceImpl.info("Calculating withdraw for {} of {}", number, amount);
        if(doesExistTheAccountOnTheBank(number)
                && doesTheUserHasCreditOnTheAmount(number,amount)
                && isTheAmountValidOnATM(amount)){
            WithDraw withDraw = withdrawService.generatesTheWithdrawByNotes(amount, bankDAO.getTheNotesOfTheBank());
            reduceAmountToAccount(number,amount);
            reduceAmountToBank(withDraw);
            return withDraw;
        }
        accountServiceImpl.warn("No valid withdraw for {} of {}", number, amount);
        return withdrawService.generatesFailedWithdraw();
    }

    private void reduceAmountToAccount(String number, Integer amount) {
        bankDAO.reduceTheAmountToTheUser(number, amount);
    }

    private void reduceAmountToBank(WithDraw withDraw){
        ATMStatus atm = bankDAO.getTheNotesOfTheBank();
        atm.setNotes_5(atm.getNotes_5() - withDraw.getNotes_5());
        atm.setNotes_10(atm.getNotes_10() - withDraw.getNotes_10());
        atm.setNotes_20(atm.getNotes_20() - withDraw.getNotes_20());
        atm.setNotes_50(atm.getNotes_50() - withDraw.getNotes_50());
        bankDAO.setTheATMStatus(atm);
    }

    private boolean isTheAmountValidOnATM(Integer amount){
        return withdrawService.isTheAmountValidOnATM(amount);
    }

    private boolean doesExistTheAccountOnTheBank(String number){
        return bankDAO.getAccountBalanceByNumber(number) != null;
    }

    private boolean doesTheUserHasCreditOnTheAmount(String number,Integer amount) {
        return bankDAO.getAccountBalanceByNumber(number) >= amount;
    }

    private String getTheAmountOfAnAccountAsString(String number){
        return bankDAO.getAccountBalanceByNumber(number).toString();
    }

}
