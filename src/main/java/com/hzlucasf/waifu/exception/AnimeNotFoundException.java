package com.hzlucasf.waifu.exception;

public class AnimeNotFoundException extends RuntimeException {
    public AnimeNotFoundException() {
    }

    public AnimeNotFoundException(String message) {
        super(message);
    }
}
