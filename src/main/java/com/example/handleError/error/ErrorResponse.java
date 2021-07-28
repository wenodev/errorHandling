package com.example.handleError.error;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private List<String> message;

    @Builder
    public ErrorResponse(List<String> message){
        this.message = message;
    }

    public static ErrorResponse of(List<String> message){
        return new ErrorResponse(message);
    }

}
