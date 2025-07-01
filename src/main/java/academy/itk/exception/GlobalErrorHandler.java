package academy.itk.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class GlobalErrorHandler {

    @AllArgsConstructor
    public static class ErrorMessage {
        String message;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleConstraintViolationException(ConstraintViolationException e) {
        return new ErrorMessage("Ошибка валидации входящих данных");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentsNotValidException(MethodArgumentNotValidException e) {
        return new ErrorMessage("Ошибка валидации параметров методов");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNotFountException(NotFoundException e) {
        return new ErrorMessage(e.getMessage());
    }

    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleJsonProcessingException(JsonProcessingException e) {
        return new ErrorMessage("Ошибка обработки JSON: " + e.getOriginalMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(Exception e) {
        return new ErrorMessage("Внутренняя ошибка сервера");
    }
}
