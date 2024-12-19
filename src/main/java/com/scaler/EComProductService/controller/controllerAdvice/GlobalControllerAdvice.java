package com.scaler.EComProductService.controller.controllerAdvice;

import com.scaler.EComProductService.dto.ErrorMessageDTO;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value= NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException (Exception exception){
        String exceptionResponse = "Error : Something went wrong, Code: "  + HttpStatus.INTERNAL_SERVER_ERROR;
        exceptionResponse = exception.getMessage();
        return ResponseEntity.ok(exceptionResponse);
    }

    @ExceptionHandler(value= ProductNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleProductNotFundException(Exception exception){
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO();
        errorMessageDTO.setErrorMessage(exception.getMessage());
        errorMessageDTO.setErrorCode(404);
//        return new ResponseEntity(errorMessageDTO,HttpStatus.NOT_FOUND); -> This also works
        return new ResponseEntity<>(errorMessageDTO,HttpStatus.NOT_FOUND);
//        return ResponseEntity.ok(errorMessageDTO);
//        return ResponseEntity.notFound(errorMessageDTO); -> Error, No Input, return status(HttpStatus.NOT_FOUND);

    }


}
