package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import com.sparta.post.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class PostDto {
    private Long id;

    private String title;

    private String username;
    private String contents;

    private LocalDateTime modifiedAt;

    private LocalDateTime createdAt;


    public PostDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

}