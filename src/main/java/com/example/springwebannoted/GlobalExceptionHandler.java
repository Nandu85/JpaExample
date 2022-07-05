package com.example.springwebannoted;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleTypeMismatch(ex, headers, status, request);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObj> getError(CustomException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorObj(HttpStatus.IM_USED.value(),e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObj> getError(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorObj(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
    }
}
