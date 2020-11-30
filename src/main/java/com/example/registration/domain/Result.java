package com.example.registration.domain;


/**
 *  返回对象实体
 */
public class Result<T> {
 
   public int code;

   public boolean flag;

   private String msg;
 
   private T data;

   public Result() {
   }


   public Result(int code, boolean flag, String msg, T data) {
      this.code = code;
      this.flag = flag;
      this.msg = msg;
      this.data = data;
   }

   public Result<T> setCode(RetCode retCode) {
      this.code = retCode.code;
      return this;
   }
 
   public int getCode() {
      return code;
   }
 
   public Result<T> setCode(int code) {
      this.code = code;
      return this;
   }
 
   public String getMsg() {
      return msg;
   }
 
   public Result<T> setMsg(String msg) {
      this.msg = msg;
      return this;
   }
 
   public T getData() {
      return data;
   }
 
   public Result<T> setData(T data) {
      this.data = data;
      return this;
   }

   public boolean isFlag() {
      return flag;
   }

   public void setFlag(boolean flag) {
      this.flag = flag;
   }
}