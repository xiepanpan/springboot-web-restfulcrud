package com.xiepanpan.springboot.exception;

/**
 * @description: 自定义用户不存在异常
 * @author: xiepanpan
 * @create: 2018-12-10 17:29
 **/
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(){
        super("用户不存在");
    }

}
