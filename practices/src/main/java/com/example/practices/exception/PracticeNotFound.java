package com.example.practices.exception;

public class PracticeNotFound  extends  RuntimeException{

    public PracticeNotFound(String msg){

        super(msg);

    }
}
