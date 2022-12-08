package com.sparta.post.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto extends ResponseDto{

    @Column(nullable = false)
    private PostDto postDto;

    public PostResponseDto(String result, String message, PostDto postDto) {
        super(result, message);
        this.postDto = postDto;
    }
}