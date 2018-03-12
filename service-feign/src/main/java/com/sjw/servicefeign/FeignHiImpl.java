package com.sjw.servicefeign;

import com.sjw.feigninterface.FeignHi;
import org.springframework.stereotype.Component;

@Component
public class FeignHiImpl implements FeignHi {
    @Override
    public String feignSayHi(String username) {
        return "Sorry "+username;
    }
}
