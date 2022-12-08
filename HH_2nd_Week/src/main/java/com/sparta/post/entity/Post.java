package com.sparta.post.entity;


import com.sparta.post.dto.PostDto;
import com.sparta.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor

public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //제목
    @Column(nullable = false)
    private String title;
    //유저이름
    @Column(nullable = false)
    private String username;

    //패스워드
    @Column(nullable = false)
    private String password;

    //내용
    @Column(nullable = false)
    private String contents;

    @CreatedDate                //생성일자
    private LocalDateTime createdAt;

    @LastModifiedDate           //수정 일자
    private LocalDateTime modifiedAt;

    public Post(PostRequestDto postrequestDto) {
        this.username = postrequestDto.getUsername();
        this.contents = postrequestDto.getContents();
        this.password = postrequestDto.getPassword();
        this.title = postrequestDto.getTitle();
    }

    public Post(PostDto postDto){
        this.id = postDto.getId();
        this.username = postDto.getUsername();
        this.title = postDto.getTitle();
        this.contents = postDto.getContents();

    }

    public void updatePost(PostRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}
