package com.jimenezict.demo.services.atm;

import com.jimenezict.demo.model.dto.ATMStatus;
import com.jimenezict.demo.model.dto.WithDraw;
import org.springframework.stereotype.Service;

@Service
public interface ATMService {

    public void replenish(ATMStatus atmStatus);

    public String checkBalance(String number);

    public WithDraw withDrawAnAmount(String number, Integer amount);

}
