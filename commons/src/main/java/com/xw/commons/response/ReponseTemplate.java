package com.xw.commons.response;

import lombok.Data;
import lombok.ToString;

/**
 * Created by AnKh on 2017/5/26.
 */
@Data
@ToString
public class ReponseTemplate<T> {
    /**
     *状态码
     */
    private int status;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 包装的数据
     */
    private T data;

    public ReponseTemplate(final int status) {
        this(StatusCode.SUCCESS.getCode(),null,null);
    }

    public ReponseTemplate(StatusCode statusCode,String message) {
        this(statusCode.getCode(),message,null);
    }

    public ReponseTemplate(T data) {
        this(StatusCode.SUCCESS.getCode(),null,data);
    }

    public ReponseTemplate(final int status, final String message, final T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
