package com.example.jsonrpc.exception.handler;

import com.example.jsonrpc.exception.JsonRpcException;
import com.example.jsonrpc.exception.MethodNotFoundException;
import com.example.jsonrpc.model.dto.ExceptionResponse;
import com.example.jsonrpc.model.dto.RpcException;
import com.example.jsonrpc.model.enums.RpcCode;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 16:29 *
 */

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RpcException> handleMethodNotFoundException(JsonRpcException ex) {
        return formatExceptionResponse(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RpcException> handleMethodArgumentNotValidException() {
        return formatExceptionResponse(HttpStatus.BAD_REQUEST, RpcCode.INVALID_REQUEST, null);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RpcException> handleHttpMessageNotReadableException() {
        return formatExceptionResponse(HttpStatus.BAD_REQUEST, RpcCode.INVALID_REQUEST, null);
    }


    @ExceptionHandler(JsonParseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RpcException> handleJsonParseException() {
        return formatExceptionResponse(HttpStatus.BAD_REQUEST, RpcCode.PARSE_ERROR, null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RpcException> handleInternalServerError() {
        return formatExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, RpcCode.INTERNAL_ERROR, null);
    }

    private ResponseEntity<RpcException> formatExceptionResponse(JsonRpcException ex, HttpStatus status) {
        return ResponseEntity.status(status).body(exceptionBuilder(ex.getMessage(), ex.getCode(), ex.getId()));
    }

    private ResponseEntity<RpcException> formatExceptionResponse(HttpStatus status, RpcCode code, Object id) {
        return ResponseEntity.status(status).body(exceptionBuilder(code.getMessage(), code.getCode(), id));
    }

    private RpcException exceptionBuilder(String message, Integer code, Object id) {
        return RpcException.builder()
                .jsonRpc("2.0")
                .id(id)
                .error(ExceptionResponse.builder()
                        .code(code)
                        .message(message)
                        .build())
                .build();
    }
}
