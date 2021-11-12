package ru.sberbank.interview.task.constant.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum TaskError {

    NOT_ALL_ID_EXSIST(1004, "Не найден объект с id ", HttpStatus.BAD_REQUEST);

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    TaskError(int errorCode, String message, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
