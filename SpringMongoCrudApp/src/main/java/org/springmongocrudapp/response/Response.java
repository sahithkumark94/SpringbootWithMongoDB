package org.springmongocrudapp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Response {
    private String message;
    private Integer status;
    private String exception;
    private Object data;
}
