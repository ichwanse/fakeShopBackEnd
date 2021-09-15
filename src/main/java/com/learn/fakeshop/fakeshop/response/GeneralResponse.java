package com.learn.fakeshop.fakeshop.response;

import java.io.Serializable;

public class GeneralResponse<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public GeneralResponse(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
