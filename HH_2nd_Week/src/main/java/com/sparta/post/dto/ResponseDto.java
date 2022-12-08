package com.sparta.post.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    @Column(nullable = false)
    private String result;
    @Column(nullable = false)
    private String message;


    public ResponseDto(String result, String message){
        this.result = result;
        this.message = message;

    }

}