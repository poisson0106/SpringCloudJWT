package com.sjw.feigninterface;

import com.sjw.servicefeign.FeignHiImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = FeignHiImpl.class)
public interface FeignHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String feignSayHi(@RequestParam(value = "name") String username);
}
