package com.jimenezict.demo.services.account;

import com.jimenezict.demo.model.dto.WithDraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public String checkBalance(String number);

    public WithDraw withDrawAnAmount(String number, Integer amount);
}
