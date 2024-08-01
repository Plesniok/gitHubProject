package com.dlesniok.githubproject.models.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class Responses {
    /**
     * Creates an APIResponse operation.
     *
     * @param data             The data to include in the response.
     * @param responseHashMap  A map containing response messages.
     * @param key              The key corresponding to the desired response message.
     * @param <T>              The type of data to be included in the response.
     * @return An APIResponse indicating a successful operation.
     */
    public static <T> ResponseEntity<T> ok(T data, Map<String, String> responseHashMap, String key) {
        return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON).body(data);
    }

    public static <T> ResponseEntity<ApiResponse<T>> conflict(T data, Map<String, String> responseHashMap, String key) {
        ApiResponse responseObject = ApiResponse.builder()
                .status(HttpStatus.CONFLICT.value())
                .message(responseHashMap.get(key))
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT.value()).contentType(MediaType.APPLICATION_JSON).body(responseObject);
    }

    public static ResponseEntity<ApiResponse> internalServerError(Map<String, String> responseHashMap, String key) {
        ApiResponse responseObject = ApiResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(responseHashMap.get(key))
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).contentType(MediaType.APPLICATION_JSON).body(responseObject);
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(T data, Map<String, String> responseHashMap, String key) {
        ApiResponse responseObject = ApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(responseHashMap.get(key))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).contentType(MediaType.APPLICATION_JSON).body(responseObject);
    }

    public static <T> ResponseEntity<ApiResponse<T>> notFound(T data, Map<String, String> responseHashMap, String key) {
        ApiResponse responseObject = ApiResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(responseHashMap.get(key))
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).contentType(MediaType.APPLICATION_JSON).body(responseObject);
    }

    public static <T> ResponseEntity<ApiResponse<T>> any(T data, Map<String, String> responseHashMap, String key, int statusCode) {
        ApiResponse responseObject = ApiResponse.builder()
                .status(statusCode)
                .message(responseHashMap.get(key))
                .build();

        return ResponseEntity.status(statusCode).contentType(MediaType.APPLICATION_JSON).body(responseObject);
    }

}

