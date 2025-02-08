package com.hzlucasf.waifu.exception;

public class WaifuNotFoundException extends RuntimeException {
    public WaifuNotFoundException() {
    }

    public WaifuNotFoundException(String message) {
        super(message);
    }
}
