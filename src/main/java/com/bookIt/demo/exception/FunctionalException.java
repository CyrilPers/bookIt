package com.bookIt.demo.exception;

import com.bookIt.demo.enums.code.ErrorCodeEnum;

public class FunctionalException extends Exception {

        public FunctionalException(String message) {
            super(message);
        }

        public FunctionalException(ErrorCodeEnum message) {
            super(message.toString());
        }
}