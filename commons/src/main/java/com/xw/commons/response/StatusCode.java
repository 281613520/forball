package com.xw.commons.response;

/**
 * Created by AnKh on 2017/5/26.
 */
public enum StatusCode {
    SUCCESS(10001),
    SAVE_SUCCESS(1),
    SAVE_FAIL(2),
    DELETE_SUCCESS(3),
    DELETE_FAIL(4);

    private int code;

    StatusCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
