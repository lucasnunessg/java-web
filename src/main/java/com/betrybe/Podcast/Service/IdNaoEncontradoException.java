package com.betrybe.Podcast.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNaoEncontradoException extends RuntimeException{
    public IdNaoEncontradoException(String message) {
        super(message);
    }
}
