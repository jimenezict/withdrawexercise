package com.jimenezict.demo.model;
import com.jimenezict.demo.model.dto.ATMStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BankDAOImpl implements BankDAO {

    @Override
    public Double getAccountBalanceByNumber(String number) {
        Bank bank = Bank.getInstance();
        Account account = bank.getAccounts().get(number);
        return (account == null)? null: account.getBalance();
    }

    @Override
    public void reduceTheAmountToTheUser(String account, Integer amount) {
        Map<String,Account> accounts = Bank.getInstance().getAccounts();

        Double balance = Bank.getInstance().getAccounts().get(account).getBalance();
        Account accountToUpdate = Bank.getInstance().getAccounts().get(account);
        accountToUpdate.setBalance(balance - amount);
        accounts.put(account, accountToUpdate);

        Bank.getInstance().setAccounts(accounts);
    }

    @Override
    public ATMStatus getTheNotesOfTheBank(){
        return  parseAtm(Bank.getInstance().getAtm());
    }

    @Override
    public void setTheATMStatus(ATMStatus atmStatus){
        Bank.getInstance().setAtm(parseStatusATM(atmStatus));
    }

    @Override
    public void setAccountBalanceByNumberAValidAmount(String number, double amount) {
        Map<String,Account> accounts = Bank.getInstance().getAccounts();
        accounts.get(number).setBalance(amount);
    }

    private ATMStatus parseAtm(ATM atm) {
        ATMStatus atmStatus = new ATMStatus();
        atmStatus.setNotes_5(atm.getNotes_5());
        atmStatus.setNotes_10(atm.getNotes_10());
        atmStatus.setNotes_20(atm.getNotes_20());
        atmStatus.setNotes_50(atm.getNotes_50());
        return atmStatus;
    }

    private ATM parseStatusATM(ATMStatus atmStatus) {
        ATM atm = new ATM();
        atm.setNotes_5(atmStatus.getNotes_5());
        atm.setNotes_10(atmStatus.getNotes_10());
        atm.setNotes_20(atmStatus.getNotes_20());
        atm.setNotes_50(atmStatus.getNotes_50());
        return atm;
    }

}
