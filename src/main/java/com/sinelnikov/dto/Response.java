package com.sinelnikov.dto;

import lombok.Data;

@Data
public class Response<T> {

    private T content;

    public Response(final T content) {
        this.content = content;
    }

}
