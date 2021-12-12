package com.epam.cube.dao;

import javax.xml.crypto.Data;

public class DataException extends Exception{

    public DataException(){
        super();
    }
    public DataException(String message){
        super(message);
    }

    public DataException(String message, Throwable cause){
        super(message,cause);
    }
}
