package org.springmongocrudapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomException extends Exception{
    private String message;
    private Integer errorCode;
}
