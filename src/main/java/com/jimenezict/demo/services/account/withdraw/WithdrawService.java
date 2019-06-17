package com.jimenezict.demo.services.account.withdraw;

import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;
import org.springframework.stereotype.Service;

@Service
public interface WithdrawService {

    public WithDraw generatesTheWithdrawByNotes(Integer amount, ATMStatus atmStatus);

    public WithDraw generatesFailedWithdraw();

    public boolean isTheAmountValidOnATM(Integer amount);
}
