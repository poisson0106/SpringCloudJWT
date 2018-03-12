package com.sjw.serviceribbon;

import com.sjw.serviceribbon.annotation.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    @HasRole("manager")
    public String hi(@RequestParam String name, HttpServletRequest request){
        return helloService.hiService(name);
    }
}
