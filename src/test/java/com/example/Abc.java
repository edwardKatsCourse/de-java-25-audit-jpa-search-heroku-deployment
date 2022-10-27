package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class Abc {

    @Mock
    private Person person;

    @Test
    void abc() {

        // void
//        Mockito.doNothing()
//                .when(person)
//                .printData();


        // void exception
//        Mockito.doThrow(IllegalArgumentException.class)
//                .when(person)
//                .printData();

        // return type w\  param => exception
//        Mockito.doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND))
//                        .when(person)
//                                .getData(ArgumentMatchers.eq("not found"));
//
        // return type w\  param => various exceptions
//        Mockito.doThrow(new ResponseStatusException(HttpStatus.UNAUTHORIZED))
//                        .when(person)
//                                .getData(ArgumentMatchers.eq("no auth"));

        // // return type w\out param => exception
//        Mockito.doThrow(new ResponseStatusException(HttpStatus.OK))
//                        .when(person)
//                                .getData();

        // MapStruct
        System.out.println();
    }
}

class Person {

    public String getData() {
        return "person data";
    }

    public String getData(String param) {
        return "person data " + param;
    }

    public void printData() {
        System.out.println("print data");
    }
}
