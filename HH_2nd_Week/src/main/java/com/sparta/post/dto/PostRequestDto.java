package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class PostRequestDto {

    private String username;

    private String contents;

    private String password;

    private String title;

    private LocalDateTime modifiedAt;

    private LocalDateTime createdAt;


    public PostRequestDto(Post post) {
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.password = post.getPassword();
        this.title = post.getTitle();
    }

}
