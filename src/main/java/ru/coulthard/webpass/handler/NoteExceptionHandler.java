package ru.coulthard.webpass.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.coulthard.webpass.dto.ErrorDto;

import javax.validation.ValidationException;

@RestControllerAdvice("ru.coulthard.webpass.controller")
@Slf4j
public class NoteExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.warn("Ошибка валидации");
        return new ResponseEntity<>(
                new ErrorDto("Ошибка валидации", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
