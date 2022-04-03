package com.example.practices.exception;

public class PracticeNotFound  extends  RuntimeException{

    PracticeNotFound(String msg){

        super(msg);

    }
}
