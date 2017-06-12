package com.xw.commons.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by Ankh on 2017/6/12.
 */

public class OperationFailException extends RuntimeException{
    public OperationFailException(String message) {
        super(message);
    }
}
