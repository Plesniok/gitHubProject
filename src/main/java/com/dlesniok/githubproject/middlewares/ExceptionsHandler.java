package com.dlesniok.githubproject.middlewares;

import com.dlesniok.githubproject.exceptions.NotFoundException;
import com.dlesniok.githubproject.models.api.ApiResponse;
import com.dlesniok.githubproject.models.api.Constant;
import com.dlesniok.githubproject.models.api.Responses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
        import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiResponse<Object>> notFoundError(NotFoundException ex) {
        return Responses.notFound(null, Constant.getProductsResponsesHashMap(), Constant.GIT_HUB_PROJECT.concat(ex.getMessage()));

    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse<String>> notValid(MethodArgumentNotValidException e, HttpServletRequest ignoredRequest) {

        String invalidParametersErrorMessage = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toSet())
                .toString()
                .replaceAll("\\[*]*", "");

        return Responses.badRequest(null, Constant.getProductsResponsesHashMap(), Constant.GIT_HUB_PROJECT.concat(invalidParametersErrorMessage));

    }

}


