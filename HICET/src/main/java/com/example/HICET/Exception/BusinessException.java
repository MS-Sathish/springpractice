package com.example.HICET.Exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException{
    
    private String errorCode;
    private String errorMessage;
    public BusinessException( String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public BusinessException(){

    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    

}
