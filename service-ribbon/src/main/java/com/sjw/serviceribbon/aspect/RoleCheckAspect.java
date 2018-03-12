package com.sjw.serviceribbon.aspect;

import com.sjw.serviceribbon.annotation.HasRole;
import com.sjw.serviceribbon.exception.UnauthenticatedException;
import com.sjw.serviceribbon.utils.JWTUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class RoleCheckAspect {
    private Logger logger = LoggerFactory.getLogger(RoleCheckAspect.class);

    @Autowired
    JWTUtils jwtUtils;

    @Before("@annotation(hasRole)")
    public void roleCheck(HasRole hasRole) throws Throwable {
        logger.info("Before method, running hasRole");
        logger.info("Role: "+hasRole.value());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getResponse();
        String token = request.getHeader("Authentication");
        logger.info(token);
        if(token != null && token != "")
            if(jwtUtils.verify(token,"qyqy"))
                if(jwtUtils.getTokenRole(token).equals(hasRole.value()))
                    logger.info("Pass role authentication");
                else
                    throw new UnauthenticatedException("You haven't required role");
            else
                throw new UnauthenticatedException("Can't verify exception");
        else {
            //response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new UnauthenticatedException("Haven't authority info");
        }
    }
}
