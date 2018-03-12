package com.sjw.servicefeign;

import com.sjw.feigninterface.FeignHi;
import com.sjw.servicefeign.annotation.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    FeignHi feignHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @HasRole("manager")
    public String sayHi(@RequestParam String name){
        return feignHi.feignSayHi(name);
    }

}
