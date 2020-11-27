package com.example.registration.exception;

/**
 * @program: registration
 * @description:
 * @author: meihua
 * @created: 2020/11/27 14:20
 */
public class RomeException extends Exception{
    public RomeException() {
        super("Rome 出现异常！");
    }

    public RomeException(String msg) {
        super(msg);
    }

}
