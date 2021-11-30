package ru.sberbank.interview.task.constant.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TaskException extends RuntimeException {

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    public TaskException(TaskError taskError, String message) {
        this.code = taskError.getErrorCode();
        this.httpStatus = taskError.getHttpStatus();
        this.message = taskError.getMessage() + message;
    }

}

